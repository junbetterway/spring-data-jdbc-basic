package com.junbetterway.banking.cbs.callback;

import org.springframework.data.mapping.callback.EntityCallback;
import org.springframework.data.relational.core.mapping.event.AfterSaveCallback;
import org.springframework.stereotype.Component;

import com.junbetterway.banking.cbs.model.Customer;

import lombok.extern.log4j.Log4j2;

/**
 * Customer {@link EntityCallback} to perform additiona actions.
 *
 * @author junbetterway
 */
@Log4j2
@Component
public class CustomerEntityCallback implements AfterSaveCallback<Customer> {

  @Override
  public Customer onAfterSave(Customer aggregate) {
    log.info("onAfterSave -> customer? {}", aggregate);
    return aggregate;
  }

}
