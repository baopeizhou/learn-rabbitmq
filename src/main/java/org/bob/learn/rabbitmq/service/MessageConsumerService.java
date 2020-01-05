package org.bob.learn.rabbitmq.service;

public interface MessageConsumerService {

    void receiveMessageFromQueueConfig(String message);

    void receiveMessageFromQueuePayTimeout(String message);
}
