package com.junbetterway.banking.cbs.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * Model for the bank account.
 *
 * @author junbetterway
 */
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class SavingsAccount extends BaseEntity {

  private String accountNumber;
  private BigDecimal balance;

}
