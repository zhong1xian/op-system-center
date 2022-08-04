package com.only4play.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * @author gim
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableElasticsearchRepositories(basePackages = "com.only4play.system.infrastructure.elastic")
public class SystemCenterApplication {

  public static void main(String[] args) {
    SpringApplication.run(SystemCenterApplication.class, args);
  }

}
