package com.junbetterway.banking.cbs.repository;

import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import com.junbetterway.banking.cbs.model.Customer;
import com.junbetterway.banking.cbs.model.SavingsAccount;

/**
 * Repository interface for {@link Customer}.
 *
 * @author junbetterway
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {

  @Query("SELECT savings.* FROM customer customer "
      + "JOIN savings_account savings ON savings.customer_id = customer.id "
      + "WHERE customer.id = :customerId AND savings.id = :savingsId")
  Optional<SavingsAccount> findByCustomerIdAndBySavingsId(Long customerId, Long savingsId);

}
