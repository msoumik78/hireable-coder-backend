package org.example.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.dao.IDao;
import org.example.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class ProductsService {
  private final IDao iDao;

  public List<Product> getProductList(int customerId) {
    return iDao.getProductsOfCustomer(customerId);
  }

  public void createProduct(Product product) {
    iDao.createProduct(product);
  }
}
