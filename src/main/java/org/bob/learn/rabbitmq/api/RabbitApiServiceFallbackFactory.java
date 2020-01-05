package org.bob.learn.rabbitmq.api;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 设备API服务熔断实现类
 */
@Slf4j
@Component
public class RabbitApiServiceFallbackFactory implements FallbackFactory<RabbitApiService> {




    @Override
    public RabbitApiService create(Throwable throwable) {

        return new RabbitApiService() {


            @Override
            public String sendMsg() {
                log.info(throwable.toString());
                return "Error";
            }
        };
    }
}
