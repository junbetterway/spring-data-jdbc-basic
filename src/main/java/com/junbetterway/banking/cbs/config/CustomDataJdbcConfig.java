package com.junbetterway.banking.cbs.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.core.convert.JdbcCustomConversions;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;

import com.junbetterway.banking.cbs.converter.CivilStatusEnumToIntConverter;
import com.junbetterway.banking.cbs.converter.IntToCivilStatusEnumConverter;

/**
 * Custom configuration for Spring Data JDBC.
 *
 * @author junbetterway
 */
@Configuration
public class CustomDataJdbcConfig extends AbstractJdbcConfiguration {

  @Bean
  @Override
  public JdbcCustomConversions jdbcCustomConversions() {
    return new JdbcCustomConversions(
        Arrays.asList(new CivilStatusEnumToIntConverter(), new IntToCivilStatusEnumConverter()));
  }

}
