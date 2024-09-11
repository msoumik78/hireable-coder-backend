package org.example.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.dao.IDao;
import org.example.models.Transaction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class TransactionService {
  private final IDao iDao;

  public List<Transaction> getTransactionList(String customerId) {
    return iDao.getTransactions(customerId);
  }
  public void createTransaction(Transaction transaction) {
    iDao.createTransaction(transaction);
  }
}
