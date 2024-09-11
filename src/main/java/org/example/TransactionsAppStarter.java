package org.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class TransactionsAppStarter {
    public static void main(String[] args) {
        SpringApplication.run(TransactionsAppStarter.class, args);
    }
    @Bean
    public CommandLineRunner demo(JdbcTemplate jdbcTemplate) {
      return (_) -> {
        jdbcTemplate.update("Create table transactions " +
          "(id bigint auto_increment,customer_id int, from_account VARCHAR(50), " +
          "to_account VARCHAR(50), amount number, transfer_date date) ");
      };
    }
}
