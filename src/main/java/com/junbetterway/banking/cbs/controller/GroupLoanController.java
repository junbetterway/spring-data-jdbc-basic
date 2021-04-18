package com.junbetterway.banking.cbs.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.junbetterway.banking.cbs.model.Customer;
import com.junbetterway.banking.cbs.model.GroupLoan;
import com.junbetterway.banking.cbs.service.GroupLoanService;

import lombok.RequiredArgsConstructor;

/**
 * Controller APIs for {@link GroupLoan}.
 *
 * @author junbetterway
 */
@RestController
@RequestMapping("api/v1/grouploan")
@RequiredArgsConstructor
public class GroupLoanController {

  private final GroupLoanService groupLoanService;

  @PostMapping
  public ResponseEntity<GroupLoan> save(@RequestBody GroupLoan groupLoan) {
    return ResponseEntity.status(HttpStatus.CREATED).body(groupLoanService.save(groupLoan));
  }

  @PostMapping("{groupLoanId}/add/customer")
  public ResponseEntity<GroupLoan> addAccount(@PathVariable Long groupLoanId,
      @RequestBody Customer customer) {
    return ResponseEntity.status(HttpStatus.OK)
        .body(groupLoanService.addCustomer(groupLoanId, customer));
  }

  @GetMapping("{groupLoanId}")
  public ResponseEntity<GroupLoan> readById(@PathVariable Long groupLoanId) {
    return ResponseEntity.status(HttpStatus.OK)
        .body(groupLoanService.findByGroupLoanId(groupLoanId));
  }

  @DeleteMapping("{groupLoanId}")
  public ResponseEntity<Void> deleteById(@PathVariable Long groupLoanId) {
    groupLoanService.deleteByGroupLoanId(groupLoanId);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }

}
