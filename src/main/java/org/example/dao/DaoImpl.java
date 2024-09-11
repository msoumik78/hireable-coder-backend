package org.example.dao;

import lombok.RequiredArgsConstructor;
import org.example.models.BankCustomer;
import org.example.models.LoginResponse;
import org.example.models.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DaoImpl implements IDao{

  private final JdbcTemplate jdbcTemplate;

  private final String insertSQL = "INSERT INTO customers(login_name, password, customer_name,customer_age,customer_city,customer_state,customer_profession,customer_email,customer_address) VALUES (?,?, ?,?, ?,?,?,?,?)";
  private final String selectSQL = "Select * from customers where id = ?";
  private final String selectSQLDuringLogin = "Select id, customer_name from customers where login_name = ? and password = ? ";
  private final String deleteSQL = "Delete from customers where customer_name = ?";
  private final String updateSQL = "Update customers set customer_email = ?, customer_address = ?, customer_city = ?, customer_state = ?, customer_profession = ?  where id = ?";
  private final String fetchProductListSQL = "Select productid ,customerid, product_name, product_number,product_balance from products where customerid = ?";
  private final String insertProductSQL = "INSERT INTO products(customerid ,product_name ,product_number ,product_balance) VALUES (?,?, ?,?)";


  @Override
  public void saveInDatabase(BankCustomer bankCustomer) {
    jdbcTemplate.update(insertSQL,bankCustomer.loginName(), bankCustomer.password(), bankCustomer.name(), bankCustomer.age(), bankCustomer.city(), bankCustomer.state(), bankCustomer.profession(), bankCustomer.email(), bankCustomer.address());
  }

  @Override
  public BankCustomer findBankCustomerById(String customerId) {
    return jdbcTemplate.queryForObject(selectSQL,
      new Object[]{customerId},
      (rs, rowNum) ->
        new BankCustomer(
          rs.getInt("id"),
          rs.getString("login_name"),
          "",
          rs.getString("customer_name"),
          rs.getInt("customer_age"),
          rs.getString("customer_city"),
          rs.getString("customer_state"),
          rs.getString("customer_profession"),
          rs.getString("customer_email"),
          rs.getString("customer_address")
        ));
  }

  @Override
  public LoginResponse verifyBankCustomerByLoginDetails(String userName, String password) {
    return jdbcTemplate.queryForObject(selectSQLDuringLogin,
      new Object[]{userName, password},
      (rs, _) ->
        new LoginResponse(
          rs.getInt(1),
          rs.getString(2)
        ));
  }

  @Override
  public void deleteFromDatabase(String customerName) {
    jdbcTemplate.update(deleteSQL,customerName);
  }

  @Override
  public void updateInDatabase(String customerId, BankCustomer bankCustomer) {
    jdbcTemplate.update(updateSQL, bankCustomer.email(), bankCustomer.address(), bankCustomer.city(), bankCustomer.state(), bankCustomer.profession(),customerId);
  }

  @Override
  public List<Product> getProductsOfCustomer(int customerId) {
    List<Product> productList =
      jdbcTemplate.query(
        fetchProductListSQL,new Object[]{customerId},
        (rs, rowNum) ->
          new Product(
            rs.getInt(1),
            rs.getInt(2),
            rs.getString(3),
            rs.getString(4),
            rs.getFloat(5)
          )
      );
    return productList;
  }

  @Override
  public void createProduct(Product product) {
    jdbcTemplate.update(insertProductSQL,product.customerId(), product.productName(), product.productNumber(), product.productBalance());
  }


}
