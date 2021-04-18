package com.junbetterway.banking.cbs.model;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;

import com.junbetterway.banking.cbs.enumeration.CivilStatusType;

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
  private CivilStatusType civilStatus;

  // Represents @OneToOne relationship
  // Note: @Column is optional: Just define a 'customer' column on Address table
  @Column("customer_id")
  private Address address;

  // Represents @OneToMany relationship
  // Note: @MappedCollection is optional: Just define a 'customer' column on SavingsAccount table
  @MappedCollection(idColumn = "customer_id")
  @Builder.Default
  private Set<SavingsAccount> accounts = new HashSet<>();

  public void addAccount(SavingsAccount account) {
    this.accounts.add(account);
  }

  // View-related
  @Transient
  private Integer civilStatusId;

}
