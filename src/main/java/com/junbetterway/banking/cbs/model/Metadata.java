package com.junbetterway.banking.cbs.model;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * Abstract class to represent the base entity to be persisted into database.
 *
 * @author junbetterway
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public abstract class Metadata {

  @Id
  @EqualsAndHashCode.Include
  private Long id;

}
