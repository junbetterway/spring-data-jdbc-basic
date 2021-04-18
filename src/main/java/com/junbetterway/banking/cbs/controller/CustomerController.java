package com.junbetterway.banking.cbs.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.junbetterway.banking.cbs.model.Customer;
import com.junbetterway.banking.cbs.model.SavingsAccount;
import com.junbetterway.banking.cbs.service.CustomerService;

import lombok.RequiredArgsConstructor;

/**
 * Controller APIs for {@link Customer}.
 *
 * @author junbetterway
 */
@RestController
@RequestMapping("api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

  private final CustomerService customerService;

  @PostMapping
  public ResponseEntity<Customer> save(@RequestBody Customer customer) {
    return ResponseEntity.status(HttpStatus.CREATED).body(customerService.save(customer));
  }

  @PostMapping("{customerId}/add/savings")
  public ResponseEntity<Customer> addAccount(@PathVariable Long customerId,
      @RequestBody SavingsAccount account) {
    return ResponseEntity.status(HttpStatus.OK)
        .body(customerService.addAccount(customerId, account));
  }

  @GetMapping("{customerId}")
  public ResponseEntity<Customer> readCustomer(@PathVariable Long customerId) {
    return ResponseEntity.status(HttpStatus.OK).body(customerService.findByCustomerId(customerId));
  }

  @GetMapping("{customerId}/account/{savingsId}")
  public ResponseEntity<SavingsAccount> readSavings(@PathVariable Long customerId,
      @PathVariable Long savingsId) {
    return ResponseEntity.status(HttpStatus.OK)
        .body(customerService.findByCustomerIdAndByAccountId(customerId, savingsId));
  }

}
