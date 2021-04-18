package com.junbetterway.banking.cbs.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Transient;

import com.junbetterway.banking.cbs.enumeration.WalletType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * Model for wallet accounts.
 *
 * @author junbetterway
 */
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class WalletAccount extends BaseEntity {

  private WalletType walletType;
  private String accountNumber;
  private BigDecimal balance;
  private Long customerId;

  // View purposes
  @Transient
  private String customerName;

  @Transient
  private String type;

}
