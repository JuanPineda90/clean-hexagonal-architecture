package com.paymentchain.usecase.product;

import com.paymentchain.model.product.Product;
import com.paymentchain.model.product.gateways.ProductRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ProductUseCase {
    private final ProductRepository productRepository;

    public Product getProductById(long id){
        return productRepository.getProductById(id);
    }

    public List<Product> getProductsByCustomerId(long customerId){
        return productRepository.getProductsByCustomerId(customerId);
    }

    public Product saveProduct(Product product){
        return productRepository.saveProduct(product);
    }

    public void deleteProduct(long id){
        productRepository.deleteProduct(id);
    }

    public Product updateProduct(Product product){
        return productRepository.updateProduct(product);
    }

}
