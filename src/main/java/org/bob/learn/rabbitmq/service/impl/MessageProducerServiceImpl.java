package org.bob.learn.rabbitmq.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.bob.learn.rabbitmq.common.util.CommonUtils;
import org.bob.learn.rabbitmq.service.MessageProducerService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@EnableAsync
public class MessageProducerServiceImpl implements MessageProducerService {

     @Autowired
     private RabbitTemplate rabbitTemplate;
        @Override
        @Async
        public void sendMessageBy() {
        rabbitTemplate.convertAndSend("de","paytimeout", CommonUtils.uuid());
    }

}
