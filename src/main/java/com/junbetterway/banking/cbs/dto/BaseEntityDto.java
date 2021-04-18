package com.junbetterway.banking.cbs.dto;

import com.junbetterway.banking.cbs.model.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * DTO class for {@link BaseEntity}.
 *
 * @author junbetterway
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public abstract class BaseEntityDto {

  @EqualsAndHashCode.Include
  private Long id;

}
