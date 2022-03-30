package com.poto.stock.consumer;

import com.poto.stock.entity.Options;
import com.poto.stock.entity.Stock;
import com.poto.stock.repository.OptionsRepository;
import com.poto.stock.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;

@Component
public class NavConsumer {

    @Autowired
    StockRepository stockRepository;

    @Autowired
    OptionsRepository optionsRepository;

    @ServiceActivator(inputChannel = "stockChannel")
    public Message<String> consumeMessage(Message<String> message) {
        DecimalFormat df = new DecimalFormat("#.####");
        df.setRoundingMode(RoundingMode.HALF_UP);
        Double total = 0.0;
        System.out.println("---------------------------------------------------------------------------------------------");

        List<Stock> stocks = stockRepository.findAll();
        System.out.format("%15s %15s %15s %15s %15s %15s %n", "stock code", "stock type", "price", "quantity", "position", "Market Value");
        for (Stock stock : stocks) {
            System.out.format("%15s %15s %15s %15s %15s %15s %n", stock.getCode(), "common stock", stock.getLatest_price(),
                    stock.getQuantity(), stock.getPosition() == 1 ? "Long" : "Short",
                    df.format(stock.getLatest_price() * stock.getQuantity() * stock.getPosition()));
            total += stock.getLatest_price() * stock.getQuantity() * stock.getPosition();
        }

        List<Options> options = optionsRepository.findAll();
        for (Options option : options) {
            System.out.format("%15s %15s %15s %15s %15s %15s %n", option.getCode(),
                    option.getType() == 1 ? "Call Option" : "Put Option", option.getOption_price(),
                    option.getQuantity(), option.getPosition() == 1 ? "Long" : "Short",
                    df.format(option.getOption_price() * option.getQuantity() * option.getPosition()));
            total += option.getOption_price() * option.getQuantity() * option.getPosition();
        }

        System.out.format("%15s %15s %15s %15s %15s %15s %n", "", "", "", "", "NAV:", df.format(total));
        System.out.println("---------------------------------------------------------------------------------------------");
        return MessageBuilder.withPayload("Message received").build();
    }

}
