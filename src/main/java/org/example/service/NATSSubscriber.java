package org.example.service;

import io.nats.client.Connection;
import io.nats.client.Dispatcher;
import io.nats.client.Subscription;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.example.dao.IDao;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
@RequiredArgsConstructor
public class NATSSubscriber {

    private final Connection connection;
    private final IDao iDao;
    @PostConstruct
    public void  subscribeToTopic() {
        Dispatcher dispatcher = connection.createDispatcher();
        Subscription subscription = dispatcher.subscribe("transaction",
                msg -> updateAccountDetails(new String(msg.getData(), StandardCharsets.UTF_8)));
        }

    private void updateAccountDetails(String message) {
        String[] messageParts = message.split(":");
        String sourceAccount = messageParts[0];
        String toAccount = messageParts[1];
        String amount = messageParts[2];
        iDao.updateProductBalance(sourceAccount, Integer.parseInt(amount), "DEBIT");
        iDao.updateProductBalance(toAccount, Integer.parseInt(amount), "CREDIT");
    }
}
