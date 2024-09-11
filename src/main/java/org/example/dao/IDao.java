package org.example.dao;

import org.example.models.BankCustomer;
import org.example.models.LoginResponse;
import org.example.models.Product;

import java.util.List;

public interface IDao {

    void saveInDatabase(BankCustomer bankCustomer);
    BankCustomer findBankCustomerById(String customerName);
    LoginResponse verifyBankCustomerByLoginDetails(String userName, String password);
    void deleteFromDatabase(String customerName);
    void updateInDatabase(String customerName, BankCustomer bankCustomer);
    List<Product> getProductsOfCustomer(int customerId);
    void createProduct(Product product);

  }
