package org.bob.learn.rabbitmq.api;

import feign.Client;
import feign.RequestInterceptor;
import feign.RequestTemplate;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.GetMapping;
import sun.net.www.protocol.https.DefaultHostnameVerifier;
import sun.security.ssl.SSLSocketFactoryImpl;
import sun.text.normalizer.UBiDiProps;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.*;
import java.security.cert.CertificateException;

@FeignClient(name = "rabbitApiService", url = "${api.rabbit.address}",configuration = RabbitApiService.RabbitApiConfiguration.class,fallbackFactory = RabbitApiServiceFallbackFactory.class)
public interface RabbitApiService {

    @GetMapping("/rabbit/send")
    String sendMsg();

    @Configuration
    @Import(FeignClientsConfiguration.class)
    class RabbitApiConfiguration {

        @Bean
        public RequestInterceptor requestInterceptor() {
            return requestTemplate -> {
                requestTemplate.header("Content-Type", "application/json");
                requestTemplate.header("Accept", "application/json");
            };
        }

        @Bean
        public Client feignClient() throws Exception {
            Client openfeignClient = new Client.Default( getSSLSocketFactory(), new DefaultHostnameVerifier());
            return openfeignClient;
        }

        public static SSLSocketFactory getSSLSocketFactory()
        {

            try {
                SSLContext sslContext = SSLContext.getInstance("TLS");;
                InputStream keyStroreInput = new FileInputStream("client.p12");
                KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
                keyStore.load(keyStroreInput,"Mm_1989321".toCharArray());

                final TrustManagerFactory trustManagerFactory= TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                trustManagerFactory.init(keyStore);
                sslContext.init(null,trustManagerFactory.getTrustManagers(),new SecureRandom());
                return sslContext.getSocketFactory();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (KeyStoreException | IOException | NoSuchAlgorithmException | CertificateException e) {
                e.printStackTrace();
            } catch (KeyManagementException e) {
                e.printStackTrace();
            }
            return null;
        }

    }
}
