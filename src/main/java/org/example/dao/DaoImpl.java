package org.example.dao;

import lombok.RequiredArgsConstructor;
import org.example.models.BankCustomer;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DaoImpl implements IDao{

  private final JdbcTemplate jdbcTemplate;

  private final String insertSQL = "INSERT INTO customers(login_name, password, customer_name,customer_age,customer_city,customer_state,customer_profession) VALUES (?,?, ?,?, ?,?,?)";
  private final String selectSQL = "Select * from customers where customer_name = ?";
  private final String selectSQLDuringLogin = "Select id from customers where login_name = ? and password = ? ";
  private final String deleteSQL = "Delete from customers where customer_name = ?";
  private final String updateSQL = "Update customers set customer_age = ?, customer_city = ?, customer_state = ?, customer_profession = ? where customer_name = ?";


  @Override
  public void saveInDatabase(BankCustomer bankCustomer) {
    jdbcTemplate.update(insertSQL,bankCustomer.loginName(), bankCustomer.password(), bankCustomer.name(), bankCustomer.age(), bankCustomer.city(), bankCustomer.state(), bankCustomer.profession());
  }

  @Override
  public BankCustomer findBankCustomerByName(String customerName) {
    return jdbcTemplate.queryForObject(selectSQL,
      new Object[]{customerName},
      (rs, rowNum) ->
        new BankCustomer(
          rs.getInt("id"),
          rs.getString("login_name"),
          "",
          rs.getString("customer_name"),
          rs.getInt("customer_age"),
          rs.getString("customer_city"),
          rs.getString("customer_state"),
          rs.getString("customer_profession")
        ));
  }

  @Override
  public Integer verifyBankCustomerByLoginDetails(String userName, String password) {
    int userId;
    try {
      userId = jdbcTemplate.queryForObject(
      selectSQLDuringLogin, new Object[]{userName, password}, Integer.class);
    } catch (DataAccessException e) {
      return -1;
    }
    return userId;
  }

  @Override
  public void deleteFromDatabase(String customerName) {
    jdbcTemplate.update(deleteSQL,customerName);
  }

  @Override
  public void updateInDatabase(String customerName, BankCustomer bankCustomer) {
    jdbcTemplate.update(updateSQL, bankCustomer.age(), bankCustomer.city(), bankCustomer.state(), bankCustomer.profession(), customerName);
  }
}
