package com.junbetterway.banking.cbs.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;

import com.junbetterway.banking.cbs.enumeration.CivilStatusType;

import lombok.extern.log4j.Log4j2;

/**
 * Writer converter to transform {@link CivilStatusType} to {@link String}.
 *
 * <p>
 * Note: Custom conversion of enum to other than string type (e.g., int) is not yet supported. See
 * this <a href="https://github.com/spring-projects/spring-data-jdbc/issues/629">open issue</a>.
 * </p>
 *
 * @author junbetterway
 */
@Log4j2
@WritingConverter
public class CivilStatusEnumToIntConverter implements Converter<CivilStatusType, String> {

  @Override
  public String convert(CivilStatusType source) {
    log.info("Writer converter? {} -> {}", source, source.getId());
    return String.valueOf(source.getId());
  }

}
