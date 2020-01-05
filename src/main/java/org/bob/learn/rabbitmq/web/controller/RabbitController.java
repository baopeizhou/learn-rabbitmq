package org.bob.learn.rabbitmq.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.bob.learn.rabbitmq.service.MessageProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/rabbit")
@RestController
public class RabbitController {

    @Autowired
    private MessageProducerService messageProducerService;

    @GetMapping("/send")
    public String sendMsg(){
        messageProducerService.sendMessageBy();
        return "ok";
    }

}
