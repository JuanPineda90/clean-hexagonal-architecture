package com.paymentchain.usecase.customer;

import com.paymentchain.model.customer.Customer;
import com.paymentchain.model.customer.gateways.CustomerRepository;
import com.paymentchain.model.customerproduct.CustomerProduct;
import com.paymentchain.model.customerproduct.CustomerProductDTO;
import com.paymentchain.model.customerproduct.CustomerProductMapper;
import com.paymentchain.model.customerproduct.gateways.CustomerProductRepository;
import com.paymentchain.model.customerwithproducts.CustomerWithProducts;
import com.paymentchain.model.exception.BusinessException;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CustomerUseCase {
    private final CustomerRepository customerRepository;
    private final CustomerProductRepository customerProductRepository;

    public Customer getCustomerByID(long id){
        Customer customer = customerRepository.getCustomer(id);
        if (customer == null) {
            throw new BusinessException("Cliente con ID " + id + " no existe.");
        }
        return customer;
    }

    public List<Customer> getAllCustomers(){
        List<Customer> customers = customerRepository.getAllCustomer();
        if (customers == null || customers.isEmpty()) {
            throw new BusinessException("No existen clientes registrados.");
        }
        return customers;
    }

    public Customer saveCustomer(Customer customer){
        if (customer.getName() == null || customer.getName().isEmpty()) {
            throw new BusinessException("El nombre del cliente es obligatorio.");
        }
        return customerRepository.saveCustomer(customer);
    }

    public Customer updateCustomer(Customer customer){
        if (customer.getId() <= 0) {
            throw new BusinessException("ID de cliente inválido para actualización.");
        }
        Customer existing = customerRepository.getCustomer(customer.getId());
        if (existing == null) {
            throw new BusinessException("No se puede actualizar, el cliente no existe.");
        }
        return customerRepository.updateCustomer(customer);
    }

    public void deleteCustomer(long id){
        Customer existing = customerRepository.getCustomer(id);
        if (existing == null) {
            throw new BusinessException("No se puede eliminar, el cliente no existe.");
        }
        customerRepository.deleteCustomer(id);
    }

    public CustomerWithProducts getCustomerWithProducts(long customerId) {
        Customer customer = customerRepository.getCustomer(customerId);
        if (customer == null) {
            throw new BusinessException("Cliente con ID " + customerId + " no existe.");
        }
        List<CustomerProduct> products = customerProductRepository.findProductsByCustomerId(customerId);
        List<CustomerProductDTO> productDTOs = products.stream()
                .map(CustomerProductMapper::fromProduct)
                .toList();
        return CustomerWithProducts.builder()
                .customer(customer)
                .products(productDTOs)
                .build();
    }
}
