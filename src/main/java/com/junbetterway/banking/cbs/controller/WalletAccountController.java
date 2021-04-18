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
import com.junbetterway.banking.cbs.model.WalletAccount;
import com.junbetterway.banking.cbs.service.WalletAccountService;

import lombok.RequiredArgsConstructor;

/**
 * Controller APIs for {@link Customer}.
 *
 * @author junbetterway
 */
@RestController
@RequestMapping("api/v1/wallet")
@RequiredArgsConstructor
public class WalletAccountController {

  private final WalletAccountService walletAccountService;

  @PostMapping
  public ResponseEntity<WalletAccount> save(@RequestBody WalletAccount account) {
    return ResponseEntity.status(HttpStatus.CREATED).body(walletAccountService.save(account));
  }

  @GetMapping("{accountId}")
  public ResponseEntity<Object> readCustomer(@PathVariable Long accountId) {
    return ResponseEntity.status(HttpStatus.OK)
        .body(walletAccountService.findByAccountIdWithProjections(accountId));
  }
}
