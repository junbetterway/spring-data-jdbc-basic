package com.junbetterway.banking.cbs.model;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * Abstract class to represent the base entity that requires its own {@code primaryKey}.
 *
 * @author junbetterway
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public abstract class BaseEntity {

  @Id
  @EqualsAndHashCode.Include
  private Long id;

}
