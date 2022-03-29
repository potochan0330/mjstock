package com.poto.stock;

import com.poto.stock.entity.Options;
import com.poto.stock.entity.Stock;
import com.poto.stock.repository.OptionsRepository;
import com.poto.stock.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class StockController {

    @Autowired
    StockRepository stockRepository;

    @Autowired
    OptionsRepository optionsRepository;

    @GetMapping("/stockReport")
    public String getStockReport() {
        List<String[]> dataLines = new ArrayList<>();
        Double totalNav = 0.0;
        DecimalFormat df = new DecimalFormat("#.####");
        df.setRoundingMode(RoundingMode.HALF_UP);
        List<Stock> stocks = stockRepository.findAll();
        dataLines.add(new String[]{"stock code", "stock type", "price", "quantity", "Total"});
        for (Stock stock : stocks) {
            dataLines.add(new String[]{stock.getCode(), "common stock", stock.getLatest_price().toString(),
                    stock.getQuantity().toString(), df.format(stock.getLatest_price() * stock.getQuantity())});
            totalNav += stock.getLatest_price() * stock.getQuantity();
        }
        List<Options> options = optionsRepository.findAll();
        for (Options option : options) {
            dataLines.add(new String[]{option.getCode(),
                    option.getType() == 1 ? "Call Option" : "Put Option", option.getOption_price().toString(),
                    option.getQuantity().toString(), df.format(option.getOption_price() * option.getQuantity())});
            totalNav += option.getOption_price() * option.getQuantity();
        }
        dataLines.add(new String[]{"", "", "", "NAV", df.format(totalNav)});
        File csvOutputFile = new File("profolio.csv");
        try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
            dataLines.stream()
                    .map(this::convertToCSV)
                    .forEach(pw::println);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return "Exported file: "+csvOutputFile.getAbsolutePath();
    }

    public String convertToCSV(String[] data) {
        return Stream.of(data)
                .collect(Collectors.joining(","));
    }

}