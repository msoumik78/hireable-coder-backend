package org.example.controller;

import com.nimbusds.jose.JOSEException;
import lombok.RequiredArgsConstructor;
import org.example.models.Product;
import org.example.service.AuthService;
import org.example.service.ProductsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/api/1/products")
@RequiredArgsConstructor
public class ProductsController {

  private final ProductsService productsService;
  private final AuthService authService;

  @GetMapping(value = "/{customerId}", produces = {"application/json"})
  @CrossOrigin(origins = "http://localhost:3000")
  public List<Product> getProductDetails(@PathVariable("customerId") final String customerId,
                                         @RequestHeader(name="Authorization") String token) throws ParseException, JOSEException {
    String[] tokens = token.split(" ");
    String onlyToken = tokens[1].trim();
    if (!authService.validateJWT(onlyToken)) {
      throw new RuntimeException("Invalid JWT provided");
    }
    return productsService.getProductList(Integer.parseInt(customerId));
  }

  @PostMapping
  public void createProduct(@RequestBody Product product) {
    productsService.createProduct(product);
  }

}
