package com.junbetterway.banking.cbs.dto;

import java.math.BigDecimal;

import com.junbetterway.banking.cbs.enumeration.WalletType;
import com.junbetterway.banking.cbs.model.WalletAccount;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * DTO class for {@link WalletAccount}.
 *
 * @author junbetterway
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
public class WalletAccountDto extends BaseEntityDto {

  private WalletType walletType;
  private String accountNumber;
  private BigDecimal balance;
  private Long customerId;
  private String customerName;
  private String type;

}
