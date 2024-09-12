package org.example.config;

import io.nats.client.Connection;
import io.nats.client.Nats;
import io.nats.client.Options;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class NATSConfig {
  @SneakyThrows
  @Bean
  public Connection createNATSConnection() {
    Options options = Options.builder()
      .server("nats://localhost:4222")
      .build();
    return Nats.connect(options);
  }
}
