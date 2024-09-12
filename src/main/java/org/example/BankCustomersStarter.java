package org.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class BankCustomersStarter {
    public static void main(String[] args) {
        SpringApplication.run(BankCustomersStarter.class, args);
    }

  @Bean
  public CommandLineRunner demo(JdbcTemplate jdbcTemplate) {
    return (_) -> {
      jdbcTemplate.update("Create table customers " +
        "(id bigint auto_increment,login_name VARCHAR(50), " +
        "password VARCHAR(100), customer_name VARCHAR(50),customer_age int,customer_city VARCHAR(50)," +
        "customer_state VARCHAR(50),customer_profession VARCHAR(50), customer_email VARCHAR(100), customer_address " +
        "VARCHAR(100))");
      jdbcTemplate.update("Create table products " +
        "(productid bigint auto_increment,customerid bigint, " +
        "product_name VARCHAR(100), product_number VARCHAR(50),product_balance number" +
        ")");
    };
  }
}
