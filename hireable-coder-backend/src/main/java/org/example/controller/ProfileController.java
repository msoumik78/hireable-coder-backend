package org.example.controller;


import lombok.AllArgsConstructor;
import org.example.model.Person;
import org.example.service.ProfileService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/1/profile")
@AllArgsConstructor
public class ProfileController {


    private ProfileService profileService;

    @GetMapping(value = "/{customerName}", produces = {"application/json"})
    @CrossOrigin(origins = "http://localhost:3000")
    public Person getCustomerDetails(@PathVariable("customerName") final String bankCustomerName) {System.out.println("Controller called");
      return profileService.getCustomerDetail(bankCustomerName);
    }

}
