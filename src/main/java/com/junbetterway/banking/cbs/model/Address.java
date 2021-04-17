package com.junbetterway.banking.cbs.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * Take note that it does not make sense for an address to stand alone thus, it does not extend the
 * {@link BaseEntity} since, it will always be used as @OneToOne reference to an aggregate root.
 *
 * @author junbetterway
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Address {

  private String city;
  private String state;
  private String country;

}
