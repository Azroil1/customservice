package ru.mtsbank.customservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class CustomserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomserviceApplication.class, args);
    }

}
