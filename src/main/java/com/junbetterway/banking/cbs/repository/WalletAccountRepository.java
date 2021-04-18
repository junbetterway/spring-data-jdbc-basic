package com.junbetterway.banking.cbs.repository;

import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import com.junbetterway.banking.cbs.dto.WalletAccountDto;
import com.junbetterway.banking.cbs.model.WalletAccount;
import com.junbetterway.banking.cbs.rowmapper.CustomWalletAccountRowMapper;

/**
 * Repository interface for {@link WalletAccount}.
 *
 * @author junbetterway
 */
public interface WalletAccountRepository extends CrudRepository<WalletAccount, Long> {

  @Query(
      value = "SELECT account.id AS id, account.customer_id AS customer_id, "
          + "account.wallet_type AS wallet_type, account.account_number AS account_number, "
          + "account.balance AS balance, "
          + "CONCAT_WS(' ', customer.first_name, customer.last_name) AS customer_name "
          + "FROM wallet_account account "
          + "JOIN customer customer ON customer.id = account.customer_id WHERE account.id = :id",
      rowMapperClass = CustomWalletAccountRowMapper.class)
  Optional<WalletAccount> findByIdWithAggregatedInfo(Long id);

  @Query(value = "SELECT account.id AS id, account.customer_id AS customer_id, "
      + "account.wallet_type AS wallet_type, account.account_number AS account_number, "
      + "account.balance AS balance, "
      + "CONCAT_WS(' ', customer.first_name, customer.last_name) AS customer_name "
      + "FROM wallet_account account "
      + "JOIN customer customer ON customer.id = account.customer_id WHERE account.id = :id")
  Optional<WalletAccountDto> findByIdWithProjections(Long id);

}
