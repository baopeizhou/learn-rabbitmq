package org.bob.learn.rabbitmq.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * RabbitMQ配置类
 */
@Slf4j
@Configuration
public class RabbitMQConfig {

    @Bean
    DirectExchange directExchange() {
        return new DirectExchange("de");
    }

    @Bean
    Binding payBinding() {
        return BindingBuilder.bind(new Queue("paytimeout",true)).to(directExchange()).with("paytimeout" );
    }
}
