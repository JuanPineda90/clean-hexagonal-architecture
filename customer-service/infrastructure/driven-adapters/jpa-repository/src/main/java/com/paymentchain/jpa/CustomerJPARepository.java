package com.paymentchain.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface CustomerJPARepository extends CrudRepository<CustomerEntity, Long>, QueryByExampleExecutor<CustomerEntity> {
}