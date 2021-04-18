package com.junbetterway.banking.cbs.enumeration;

import java.util.Arrays;

import com.junbetterway.banking.cbs.model.WalletAccount;

/**
 * Enumeration type for {@link WalletAccount}.
 *
 * @author junbetterway
 */
public enum WalletType {

  INDIVIDUAL, CORPORATION;

  public static boolean notExist(String type) {
    return !has(type);
  }

  public static boolean has(String type) {
    if (null == type) {
      return false;
    }
    return Arrays.stream(values()).anyMatch(value -> value.name().equals(type));
  }

}
