package com.junbetterway.banking.cbs.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.junbetterway.banking.cbs.dto.WalletAccountDto;
import com.junbetterway.banking.cbs.enumeration.WalletType;
import com.junbetterway.banking.cbs.model.WalletAccount;
import com.junbetterway.banking.cbs.repository.WalletAccountRepository;

import lombok.RequiredArgsConstructor;

/**
 * Service component for {@link WalletAccount}
 *
 * @author junbetterway
 */
@Service
@RequiredArgsConstructor
public class WalletAccountService {

  private final WalletAccountRepository repository;
  private final CustomerService customerService;

  @Transactional
  public WalletAccount save(WalletAccount account) {
    if (!customerService.existsByCustomerId(account.getCustomerId())) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer ID does not exist!");
    }
    if (null == account.getType() || WalletType.notExist(account.getType())) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid wallet type selected!");
    }
    account.setWalletType(WalletType.valueOf(account.getType()));
    return repository.save(account);
  }

  @Transactional(readOnly = true)
  public WalletAccount findByAccountId(Long accountId) {
    return repository.findById(accountId)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
            "Wallet Account ID does not exist!"));
  }

  @Transactional(readOnly = true)
  public WalletAccountDto findByAccountIdWithProjections(Long accountId) {
    return repository.findByIdWithProjections(accountId)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
            "Wallet Account ID does not exist!"));
  }

}
