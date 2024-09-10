package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.models.BankCustomer;
import org.example.models.LoginDetails;
import org.example.models.LoginResponse;
import org.example.service.BankCustomersService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/1/bank-customers")
@RequiredArgsConstructor
public class BankCustomersController {
  private final BankCustomersService bankCustomersService;

    @GetMapping(value = "/{customerName}", produces = {"application/json"})
    public BankCustomer getCustomerDetails(@PathVariable("customerName") final String bankCustomerName) {
        return bankCustomersService.getCustomerDetail(bankCustomerName);
    }

    @PostMapping(value = "/login-verification", produces = {"application/json"})
    @CrossOrigin(origins = "http://localhost:3000")
    public LoginResponse validateCustomerAndRetrieveDetails(@RequestBody LoginDetails loginDetails) {
      return bankCustomersService.verifyLogin(loginDetails.username(), loginDetails.password());
    }

    @PostMapping(produces = {"application/json"})
    public void createCustomer(@RequestBody BankCustomer bankCustomer) {
        bankCustomersService.createCustomer(bankCustomer);
    }

    @DeleteMapping(value = "/{customerName}")
    public void deleteCustomer(@PathVariable("customerName") final String bankCustomerName) {
        bankCustomersService.removeCustomer(bankCustomerName);
    }

    @PutMapping(value = "/{customerName}")
    public void updateCustomer(@PathVariable("customerName") final String bankCustomerName, @RequestBody BankCustomer bankCustomerUpdated) {
        bankCustomersService.updateCustomer(bankCustomerName, bankCustomerUpdated);
    }

}
