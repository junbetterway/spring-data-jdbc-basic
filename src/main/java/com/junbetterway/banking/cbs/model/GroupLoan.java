package com.junbetterway.banking.cbs.model;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.relational.core.mapping.MappedCollection;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * Model for a Group Loan.
 *
 * @author junbetterway
 */
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class GroupLoan extends BaseEntity {

  private String accountNumber;
  private BigDecimal principal;
  private BigDecimal charges;
  private BigDecimal interest;

  // Represents @ManyToMany relationship (between two aggregates: GroupLoan & Customer)
  // Note: @MappedCollection is optional: Just define a 'group_loan' column on CustomerRef table
  @MappedCollection(idColumn = "group_loan_id")
  @Builder.Default
  private Set<CustomerRef> customerIds = new HashSet<>();

  public void addCustomer(Customer customer) {
    this.customerIds.add(new CustomerRef(customer.getId()));
  }

}
