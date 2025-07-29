package com.paymentchain.model.customerproduct;

import com.paymentchain.model.customer.Customer;
import lombok.*;

@Data
public class CustomerProduct {
    private long id;
    private String code;
    private String name;
    private long customerId;
}