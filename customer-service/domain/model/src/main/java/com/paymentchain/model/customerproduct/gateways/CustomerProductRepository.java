package com.paymentchain.model.customerproduct.gateways;

import com.paymentchain.model.customerproduct.CustomerProduct;

import java.util.List;

public interface CustomerProductRepository {
    List<CustomerProduct> findProductsByCustomerId(long customerId);
}

