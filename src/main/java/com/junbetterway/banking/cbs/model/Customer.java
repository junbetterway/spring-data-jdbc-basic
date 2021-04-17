package com.junbetterway.banking.cbs.model;

import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * Model for the bank client/customer.
 *
 * @author junbetterway
 */
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Customer extends BaseEntity {

  private String firstName;
  private String lastName;

  // Represents @OneToOne relationship
  private Address address;

  // Represents @OneToMany relationship
  @Builder.Default
  private Set<SavingsAccount> accounts = new HashSet<>();

  public void addAccount(SavingsAccount account) {
    this.accounts.add(account);
  }

}
