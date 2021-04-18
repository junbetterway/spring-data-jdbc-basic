package com.junbetterway.banking.cbs.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

import com.junbetterway.banking.cbs.enumeration.CivilStatusType;

import lombok.extern.log4j.Log4j2;

/**
 * Reader converter to transform {@link String} to {@link CivilStatusType}.
 *
 * <p>
 * Note: Custom conversion of enum to other than string type (e.g., int) is not yet supported. See
 * this <a href="https://github.com/spring-projects/spring-data-jdbc/issues/629">open issue</a>.
 * </p>
 *
 * @author junbetterway
 */
@Log4j2
@ReadingConverter
public class IntToCivilStatusEnumConverter implements Converter<String, CivilStatusType> {

  @Override
  public CivilStatusType convert(String source) {
    CivilStatusType type = CivilStatusType.fromInt(Integer.valueOf(source));
    log.info("Reader converter? {} -> {}", source, type);
    return type;
  }

}
