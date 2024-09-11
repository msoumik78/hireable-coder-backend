package org.example.dao;

import org.example.models.Transaction;
import java.util.List;

public interface IDao {

    void createTransaction(Transaction transaction);
    List<Transaction> getTransactions(String fromAccount);

  }
