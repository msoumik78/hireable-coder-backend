package org.example.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.models.BankCustomer;
import org.example.dao.IDao;
import org.example.exception.InvalidInputException;
import org.example.models.LoginResponse;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class BankCustomersService {
  private final IDao iDao;

  public void createCustomer(BankCustomer bankCustomer) {
    iDao.saveInDatabase(bankCustomer);
  }

  public BankCustomer getCustomerDetail(String bankCustomerId) {
    BankCustomer bankCustomer;
    try {
      bankCustomer = iDao.findBankCustomerById(bankCustomerId);
    } catch (EmptyResultDataAccessException e) {
      throw new InvalidInputException("Bankcustomer : "+bankCustomerId+" not found");
    }
    return bankCustomer;
  }

  public LoginResponse verifyLogin(String userName, String password) {
    return iDao.verifyBankCustomerByLoginDetails(userName, password);
  }


  public void removeCustomer(String bankCustomerName) {
    BankCustomer bankCustomer = getCustomerDetail(bankCustomerName);
    iDao.deleteFromDatabase(bankCustomerName);
  }

  public void updateCustomer(String bankCustomerId, BankCustomer bankCustomerUpdated) {
    BankCustomer bankCustomer = getCustomerDetail(bankCustomerId);
    iDao.updateInDatabase(bankCustomerId, bankCustomerUpdated);
  }

}
