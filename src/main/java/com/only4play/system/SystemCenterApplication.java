package com.only4play.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author gim
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SystemCenterApplication {

  public static void main(String[] args) {
    SpringApplication.run(SystemCenterApplication.class, args);
  }

}
