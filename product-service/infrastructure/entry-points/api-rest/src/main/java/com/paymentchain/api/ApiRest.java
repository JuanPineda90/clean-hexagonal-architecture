package com.paymentchain.api;
import com.paymentchain.model.product.Product;
import com.paymentchain.usecase.product.ProductUseCase;
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
@RequestMapping(value = "/product", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
class ApiRest {

    private final ProductUseCase productUseCase;

    @GetMapping(path = "/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(productUseCase.getProductById(id));
    }

    @GetMapping(path = "/customerId/{customerId}")
    public ResponseEntity<List<Product>> getProductsByCustomerId(@PathVariable(name = "customerId") long customerId) {
        return ResponseEntity.ok(productUseCase.getProductsByCustomerId(customerId));
    }

    @PostMapping(path = "/")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productUseCase.saveProduct(product));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productUseCase.updateProduct(product));
    }

    @DeleteMapping(path = "/{id}")
    public void deleteProduct(@PathVariable(name = "id") long id) {
        productUseCase.deleteProduct(id);
    }

}