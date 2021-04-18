package com.junbetterway.banking.cbs.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.junbetterway.banking.cbs.enumeration.WalletType;
import com.junbetterway.banking.cbs.model.WalletAccount;

/**
 * Custom row mapper for {@link WalletAccount} in order to initialize values of related aggregates.
 *
 * @author junbetterway
 */
public class CustomWalletAccountRowMapper implements RowMapper<WalletAccount> {

  @Override
  public WalletAccount mapRow(ResultSet rs, int rowNum) throws SQLException {
    return WalletAccount.builder().id(rs.getLong("id")).customerId(rs.getLong("customer_id"))
        .walletType(WalletType.valueOf(rs.getString("wallet_type")))
        .accountNumber(rs.getString("account_number")).balance(rs.getBigDecimal("balance"))
        .customerName(rs.getString("customer_name")).build();
  }

}
