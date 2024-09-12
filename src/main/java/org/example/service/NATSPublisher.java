package org.example.service;

import io.nats.client.Connection;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
@RequiredArgsConstructor
public class NATSPublisher {
  private final Connection connection;

  public void sendMessage(String topic, String message) {
    connection.publish(topic, message.getBytes(StandardCharsets.UTF_8));
  }

}
