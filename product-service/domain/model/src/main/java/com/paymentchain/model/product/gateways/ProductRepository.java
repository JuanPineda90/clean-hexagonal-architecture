package com.paymentchain.model.product.gateways;

import com.paymentchain.model.product.Product;

import java.util.List;

public interface ProductRepository {
    Product getProductById(long id);
    List<Product> getProductsByCustomerId(long customerId);
    Product saveProduct(Product product);
    void deleteProduct(long id);
    Product updateProduct(Product product);
}
