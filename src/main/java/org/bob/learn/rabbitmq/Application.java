package org.bob.learn.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@Slf4j
@EnableFeignClients
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        log.info("Redis应用启动开始！");
        SpringApplication.run(Application.class, args);
        log.info("Redis应用启动成功！");
    }
}
