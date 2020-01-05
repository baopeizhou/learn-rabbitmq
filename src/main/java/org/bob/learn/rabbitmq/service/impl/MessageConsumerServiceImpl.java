package org.bob.learn.rabbitmq.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.bob.learn.rabbitmq.service.MessageConsumerService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MessageConsumerServiceImpl implements MessageConsumerService {


    @Override
    public void receiveMessageFromQueueConfig(String message) {
        log.info(message);
    }


    @RabbitListener(queues = "paytimeout")
    @Async
    @Override
    public void receiveMessageFromQueuePayTimeout(String message) {
        log.info(message);
    }
}
