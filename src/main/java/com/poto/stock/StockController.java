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

        File csvOutputFile = new File("profolio.txt");
        try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
            List<Stock> stocks = stockRepository.findAll();
            pw.format("%15s %15s %15s %15s %15s %n", "stock code", "stock type", "price", "quantity", "Total");
            for (Stock stock : stocks) {
                pw.format("%15s %15s %15s %15s %15s %n", stock.getCode(), "common stock", stock.getLatest_price(),
                        stock.getQuantity(), df.format(stock.getLatest_price() * stock.getQuantity()));
                totalNav += stock.getLatest_price() * stock.getQuantity();
            }
            List<Options> options = optionsRepository.findAll();
            for (Options option : options) {
                pw.format("%15s %15s %15s %15s %15s %n", option.getCode(),
                        option.getType() == 1 ? "Call Option" : "Put Option", option.getOption_price(),
                        option.getQuantity(), df.format(option.getOption_price() * option.getQuantity()));
                totalNav += option.getOption_price() * option.getQuantity();
            }
            pw.format("%15s %15s %15s %15s %15s %n", "", "", "", "NAV:", df.format(totalNav));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return "Exported file: " + csvOutputFile.getAbsolutePath() + " \n";
    }

}