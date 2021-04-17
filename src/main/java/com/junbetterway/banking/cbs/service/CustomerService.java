package com.junbetterway.banking.cbs.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.junbetterway.banking.cbs.model.Customer;
import com.junbetterway.banking.cbs.model.SavingsAccount;
import com.junbetterway.banking.cbs.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;

/**
 * Service component for {@link Customer}
 *
 * @author junbetterway
 */
@Service
@RequiredArgsConstructor
public class CustomerService {

  private final CustomerRepository repository;

  @Transactional
  public Customer save(Customer customer) {
    return repository.save(customer);
  }

  @Transactional
  public Customer addAccount(Long customerId, SavingsAccount account) {
    Customer customer = repository.findById(customerId).orElseThrow(
        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer ID does not exist!"));
    customer.addAccount(account);
    return repository.save(customer);
  }

  @Transactional(readOnly = true)
  public Customer findByCustomerId(Long customerId) {
    return repository.findById(customerId).orElseThrow(
        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer ID does not exist!"));
  }

  @Transactional(readOnly = true)
  public SavingsAccount findByCustomerIdAndByAccountId(Long customerId, Long savingsId) {
    return repository.findByCustomerIdAndBySavingsId(customerId, savingsId)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
            "Customer Savings Account does not exist!"));
  }

}
