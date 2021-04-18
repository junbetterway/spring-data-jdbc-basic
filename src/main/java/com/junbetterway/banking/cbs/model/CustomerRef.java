package com.junbetterway.banking.cbs.model;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Table("customer_grouploan")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class CustomerRef {

  @Column("customer_id")
  private Long customer;

}
