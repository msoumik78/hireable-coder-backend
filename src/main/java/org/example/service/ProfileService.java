package org.example.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.dao.IDao;
import org.example.model.Person;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class ProfileService {

  private IDao iDao;

    public Person getCustomerDetail(String bankCustomerName) {
      Person personDetail = iDao.getPersonDetail(bankCustomerName);
      if (personDetail != null) {
        return personDetail;
      } else {
        handleInvalidInput(bankCustomerName);
        return null;
      }
    }

  private static void handleInvalidInput(String bankCustomerName) {
    String exceptionDetails = STR."Customer with name \{bankCustomerName} does not exist";
    log.warn(exceptionDetails);
    throw new RuntimeException(exceptionDetails);
  }

}
