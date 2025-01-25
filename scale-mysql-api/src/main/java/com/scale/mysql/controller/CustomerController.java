package com.scale.mysql.controller;

import com.scale.mysql.dto.CreateCustomerRequest;
import com.scale.mysql.entity.Customer;
import com.scale.mysql.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api")
@RequiredArgsConstructor
@Slf4j
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/customers")
    public ResponseEntity<Customer> createCustomer(@RequestBody CreateCustomerRequest createCustomerRequest) {
        Customer createdCustomer = customerService.saveCustomer(createCustomerRequest);
        log.info("Customer successfully created for:  " + createdCustomer.getName());
        return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
    }
}
