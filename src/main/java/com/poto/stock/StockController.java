package com.poto.stock;

import com.poto.stock.consumer.CustomGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockController {


    @GetMapping("/stockprice")
    public String getStockPrice() {
//        Message<String> message = MessageBuilder.withPayload("Test Msg").build();
//        Message<String> result = customGateway.print(message);
//        System.out.println(result.getPayload());
        return "getStockPrice!";
    }


}