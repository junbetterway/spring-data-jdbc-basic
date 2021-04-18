package com.junbetterway.banking.cbs.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.junbetterway.banking.cbs.model.Customer;
import com.junbetterway.banking.cbs.model.GroupLoan;
import com.junbetterway.banking.cbs.repository.GroupLoanRepository;

import lombok.RequiredArgsConstructor;

/**
 * Service component for {@link Customer}
 *
 * @author junbetterway
 */
@Service
@RequiredArgsConstructor
public class GroupLoanService {

  private final GroupLoanRepository repository;
  private final CustomerService customerService;

  @Transactional
  public GroupLoan save(GroupLoan groupLoan) {
    return repository.save(groupLoan);
  }

  @Transactional
  public GroupLoan addCustomer(Long groupLoanId, Customer customer) {
    GroupLoan groupLoan = repository.findById(groupLoanId).orElseThrow(
        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Group Loan ID does not exist!"));
    if (!customerService.existsByCustomerId(customer.getId())) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer ID does not exist!");
    }
    groupLoan.addCustomer(customer);
    return repository.save(groupLoan);
  }

  @Transactional(readOnly = true)
  public GroupLoan findByGroupLoanId(Long groupLoanId) {
    return repository.findById(groupLoanId).orElseThrow(
        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Group Loan ID does not exist!"));
  }

  @Transactional
  public void deleteByGroupLoanId(Long groupLoanId) {
    repository.deleteById(groupLoanId);
  }

}
