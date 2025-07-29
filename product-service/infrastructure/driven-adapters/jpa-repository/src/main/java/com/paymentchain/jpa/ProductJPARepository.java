package com.paymentchain.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.List;

public interface ProductJPARepository extends CrudRepository<ProductEntity, Long>, QueryByExampleExecutor<ProductEntity> {
    List<ProductEntity> findByCustomerId(long customerId);
}
