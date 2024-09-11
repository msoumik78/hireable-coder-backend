package org.example.models;

public record BankCustomer(
        int id,
        String loginName,
        String password,
        String name,
        int age,
        String city,
        String state,
        String profession,
        String email,
        String address
)  { }
