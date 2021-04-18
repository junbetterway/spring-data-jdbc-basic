package com.junbetterway.banking.cbs.repository;

import org.springframework.data.repository.CrudRepository;

import com.junbetterway.banking.cbs.model.GroupLoan;

/**
 * Repository interface for {@link GroupLoan}.
 *
 * @author junbetterway
 */
public interface GroupLoanRepository extends CrudRepository<GroupLoan, Long> {

}
