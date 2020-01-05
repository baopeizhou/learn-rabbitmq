package org.bob.learn.rabbitmq.api;

import lombok.extern.slf4j.Slf4j;
import org.bob.learn.rabbitmq.Application;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RabbitApiServiceTest {

    @Autowired
    private RabbitApiService rabbitApiService;

    @Test
    void sendMsg() {
        log.info(rabbitApiService.sendMsg());
    }
}