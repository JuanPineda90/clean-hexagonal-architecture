package com.paymentchain.api;
import com.paymentchain.model.customer.Customer;
import com.paymentchain.model.customerwithproducts.CustomerWithProducts;
import com.paymentchain.model.exception.BusinessException;
import com.paymentchain.usecase.customer.CustomerUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * API Rest controller.
 * 
 * Example of how to declare and use a use case:
 * <pre>
 * private final MyUseCase useCase;
 * 
 * public String commandName() {
 *     return useCase.execute();
 * }
 * </pre>
 */
@RestController
@RequestMapping(value = "/customer", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRest {
    private final CustomerUseCase customerUseCase;

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(customerUseCase.getCustomerByID(id));
    }

    @GetMapping("/customer-products/{id}")
    public ResponseEntity<CustomerWithProducts> getCustomerWithProducts(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(customerUseCase.getCustomerWithProducts(id));
    }

    @GetMapping("/")
    public ResponseEntity<List<Customer>> listAll() {
        List<Customer> customers = customerUseCase.getAllCustomers();
        return ResponseEntity.ok(customers);
    }

    @PostMapping("/")
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer){
        return ResponseEntity.ok(customerUseCase.saveCustomer(customer));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer){
        return ResponseEntity.ok(customerUseCase.updateCustomer(customer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer (@PathVariable(name = "id") long id){
        customerUseCase.deleteCustomer(id);
        return ResponseEntity.ok("usuario eliminado exitosamente");
    }
}
