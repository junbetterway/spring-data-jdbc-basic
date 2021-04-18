package com.junbetterway.banking.cbs.enumeration;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Enumeration type for civil status.
 *
 * @author junbetterway
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@AllArgsConstructor
@Getter
public enum CivilStatusType {

  SINGLE(1, "civil.status.single", "Single"), MARRIED(2, "civil.status.married",
      "Married"), DIVORCED(3, "civil.status.divorced", "Divorced");

  private final Integer id;
  private final String code;
  private final String value;

  private static Map<Integer, CivilStatusType> intToEnumMap = new HashMap<>();

  static {
    intToEnumMap = Arrays.stream(values())
        .collect(Collectors.toMap(type -> type.getId(), Function.identity()));
  }

  public static CivilStatusType fromInt(final Integer id) {
    return intToEnumMap.get(id);
  }

}
