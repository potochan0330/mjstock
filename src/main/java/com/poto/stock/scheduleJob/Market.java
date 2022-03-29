package com.poto.stock.scheduleJob;

import com.poto.stock.consumer.CustomGateway;
import com.poto.stock.entity.Options;
import com.poto.stock.entity.Stock;
import com.poto.stock.repository.OptionsRepository;
import com.poto.stock.repository.StockRepository;
import org.apache.commons.math3.distribution.NormalDistribution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class Market {

    @Autowired
    private CustomGateway customGateway;

    @Autowired
    StockRepository stockRepository;

    @Autowired
    OptionsRepository optionsRepository;

    @Scheduled(fixedDelay = 500)
    public void updateMarket(){
        Double sleepTime = Math.random() * 1500;
        updateStockPrice(sleepTime+500);
        updateOptionPrice();

        Message<String> message = MessageBuilder.withPayload("updated").build();
        Message<String> result = customGateway.print(message);

        try {
            TimeUnit.MILLISECONDS.sleep(sleepTime.longValue());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void updateStockPrice(Double updateTime) {
        List<Stock> stockList = stockRepository.findAll();
        for(Stock stock: stockList){
            Double newPrice;
            Double changeValue = 0.0;
            Double curPrice = stock.getLatest_price();
            Double annual_sd = stock.getAnnual_sd();
            Double expected_return = stock.getExpected_return();
            NormalDistribution normalDistribution = new NormalDistribution();
            changeValue = expected_return*(updateTime/1000)/7257600+annual_sd*normalDistribution.sample()*Math.sqrt((updateTime/1000)/7257600);
            newPrice = curPrice + changeValue;
            DecimalFormat df = new DecimalFormat("#.####");
            df.setRoundingMode(RoundingMode.HALF_UP);
//            System.out.println("new price " + df.format(newPrice));
            if(newPrice > 0){
                stock.setLatest_price(Double.parseDouble(df.format(newPrice)));
            }else {
                stock.setLatest_price(0.0);
            }
            stockRepository.save(stock);
        }
    }

    public void updateOptionPrice() {
        List<Options> options = optionsRepository.findAll();
        for(Options option : options){
            Stock stock = stockRepository.getByCode(option.getCode());
            Double newPrice;
            Double maturityTime = option.getMaturity_year();
            Double strikePrice = option.getStrike_price();
            Double interestRate = 0.02;
            Double price = stock.getLatest_price();
            Double annual_sd = stock.getAnnual_sd();

            Double d1 = (Math.log(price/strikePrice)+(interestRate+annual_sd*annual_sd/2)*maturityTime)/(annual_sd*Math.sqrt(maturityTime));
            Double d2 = d1-annual_sd*Math.sqrt(maturityTime);
            if(option.getType() == 1) {
                newPrice = price * d1 - strikePrice * Math.exp(-interestRate * maturityTime) * d2;
            }else{
                newPrice = strikePrice * Math.exp(-interestRate * maturityTime) * (-d2) - price * (-d1);
            }
            DecimalFormat df = new DecimalFormat("#.####");
            df.setRoundingMode(RoundingMode.HALF_UP);
            option.setOption_price(Double.parseDouble(df.format(newPrice)));
            optionsRepository.save(option);
        }
    }

}
