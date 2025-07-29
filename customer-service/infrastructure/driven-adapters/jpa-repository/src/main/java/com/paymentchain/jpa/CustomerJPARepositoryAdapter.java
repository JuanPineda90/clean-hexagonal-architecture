package com.paymentchain.jpa;

import com.paymentchain.jpa.helper.AdapterOperations;
import com.paymentchain.model.customer.Customer;
import com.paymentchain.model.customer.gateways.CustomerRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerJPARepositoryAdapter extends AdapterOperations<Customer, CustomerEntity, Long, CustomerJPARepository>
implements CustomerRepository
{

    public CustomerJPARepositoryAdapter(CustomerJPARepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Customer.class));
    }

    @Override
    public Customer getCustomer(long id) {
        return this.toEntity(this.repository.findById(id).orElse(null));
    }

    @Override
    public List<Customer> getAllCustomer() {
        return findAll();
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return this.toEntity(this.repository.save(this.toData(customer)));
    }

    @Override
    public void deleteCustomer(long id) {
        this.repository.deleteById(id);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return this.toEntity(this.repository.save(this.toData(customer)));
    }
}
