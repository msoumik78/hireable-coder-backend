package org.example.models;

public record Product(int productId, int customerId, String productName, String productNumber, float productBalance) {
}
