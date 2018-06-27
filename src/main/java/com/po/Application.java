package com.po;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by ZJ on 26/06/2018.
 */
@PropertySource({"classpath:application.properties"})
@ImportResource(locations = {"classpath:mongo-context.xml", "classpath:elastic-context.xml"})
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.po.es", "com.po.mongo"})
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
