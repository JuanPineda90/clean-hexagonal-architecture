package com.paymentchain.model.customer.gateways;

import com.paymentchain.model.customer.Customer;
import java.util.List;

public interface CustomerRepository {
    Customer getCustomer(long id);
    List<Customer> getAllCustomer();
    Customer saveCustomer(Customer customer);
    void deleteCustomer(long id);
    Customer updateCustomer(Customer customer);
}
