package com.poto.stock;

import com.poto.stock.consumer.CustomGateway;
import com.poto.stock.repository.OptionsRepository;
import com.poto.stock.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockController {

    @Autowired
    StockRepository stockRepository;

    @Autowired
    OptionsRepository optionsRepository;

    @Autowired
    CustomGateway customGateway;

    @GetMapping("/stockReport")
    public String getStockReport() {
        Message<String> message = MessageBuilder.withPayload("report").build();
        Message<String> result = customGateway.print(message);
        if (result.getPayload().contains("filepath")) {
            return "File path: " + result.getPayload().split(":")[1] + "\n";
        }
        return "No filepath\n";
    }

}