package com.scale.mysql.service;

import com.scale.mysql.dto.CreateCustomerRequest;
import com.scale.mysql.entity.Customer;
import com.scale.mysql.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Customer saveCustomer(CreateCustomerRequest createCustomerRequest) {
        return customerRepository.save(Customer.builder()
                .createdDate(LocalDateTime.now()).name(createCustomerRequest.getName()).build());
    }
}
