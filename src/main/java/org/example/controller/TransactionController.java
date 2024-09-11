package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.models.Transaction;
import org.example.service.TransactionService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/1/transactions")
@RequiredArgsConstructor
public class TransactionController {

  private final TransactionService transactionService;

  @GetMapping(value = "/{customerId}", produces = {"application/json"})
  @CrossOrigin(origins = "http://localhost:3000")
  public List<Transaction> getTransactionDetails(@PathVariable("customerId") final String customerId) {
    return transactionService.getTransactionList(customerId);
  }

  @PostMapping
  @CrossOrigin(origins = "http://localhost:3000")
  public void createTransaction(@RequestBody Transaction transaction) {
    System.out.println("Tranefer posted : from account = "+transaction.fromAccount()+", to account ="+transaction.toAccount()+", ammount = "+transaction.amount()
    +", customer id = "+transaction.customerId());
    transactionService.createTransaction(transaction);
  }
}
