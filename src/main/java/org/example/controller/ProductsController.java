package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.models.Product;
import org.example.service.ProductsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/1/products")
@RequiredArgsConstructor
public class ProductsController {

  private final ProductsService productsService;

  @GetMapping(value = "/{customerId}", produces = {"application/json"})
  @CrossOrigin(origins = "http://localhost:3000")
  public List<Product> getProductDetails(@PathVariable("customerId") final String customerId) {
    return productsService.getProductList(Integer.parseInt(customerId));
  }

  @PostMapping
  public void createProduct(@RequestBody Product product) {
    productsService.createProduct(product);
  }

}
