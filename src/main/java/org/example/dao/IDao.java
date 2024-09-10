package org.example.dao;

import org.example.models.BankCustomer;

  public interface IDao {

    public void saveInDatabase(BankCustomer bankCustomer);
    public BankCustomer findBankCustomerByName(String customerName);
    public Integer verifyBankCustomerByLoginDetails(String userName, String password);
    public void deleteFromDatabase(String customerName);

    public void updateInDatabase(String customerName, BankCustomer bankCustomer);

  }
