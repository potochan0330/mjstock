package com.poto.stock.consumer;


import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.Message;

@MessagingGateway(name = "stockGateway", defaultRequestChannel = "stockChannel")
public interface CustomGateway {

    @Gateway(requestChannel = "stockChannel")
    public Message<String> print(Message<String> message);

}