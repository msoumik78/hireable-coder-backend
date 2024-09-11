package org.example.dao;

import lombok.RequiredArgsConstructor;
import org.example.models.Transaction;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DaoImpl implements IDao{

  private final JdbcTemplate jdbcTemplate;
  private final String fetchTransactionListSQL = "Select from_account ,to_account, amount, transfer_date from transactions where customer_id = ?";
  private final String createTransaction = "INSERT INTO transactions(customer_id, from_account ,to_account ,amount ,transfer_date) VALUES (?, ?,?, ?,?)";

  @Override
  public void createTransaction(Transaction transaction) {
    jdbcTemplate.update(createTransaction,transaction.customerId(), transaction.fromAccount(), transaction.toAccount(), transaction.amount(),
      (transaction.transactionDate() != null) ? transaction.transactionDate() : LocalDate.now());
  }

  @Override
  public List<Transaction> getTransactions(String customerId) {
    List<Transaction> transactionList =
      jdbcTemplate.query(
        fetchTransactionListSQL,new Object[]{customerId},
        (rs, rowNum) ->
          new Transaction(
            1,
            rs.getString(1),
            rs.getString(2),
            rs.getInt(3),
            rs.getDate(4)
          )
      );
    return transactionList;
  }
}
