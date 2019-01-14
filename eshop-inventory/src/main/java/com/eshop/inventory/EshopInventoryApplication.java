package com.eshop.inventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EshopInventoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(EshopInventoryApplication.class, args);
    }

}