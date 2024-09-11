package org.example.models;

import java.util.Date;

public record Transaction(int customerId, String fromAccount, String toAccount, int amount, Date transactionDate) {
}
