package com.paymentchain.jpa;

import com.paymentchain.jpa.helper.AdapterOperations;
import com.paymentchain.model.product.Product;
import com.paymentchain.model.product.gateways.ProductRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductJPARepositoryAdapter extends AdapterOperations<Product, ProductEntity, Long, ProductJPARepository>
implements ProductRepository
{

    public ProductJPARepositoryAdapter(ProductJPARepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Product.class));
    }

    @Override
    public Product getProductById(long id) {
        return this.toEntity(this.repository.findById(id).orElse(null));
    }

    @Override
    public List<Product> getProductsByCustomerId(long customerId) {
        return repository.findByCustomerId(customerId).stream()
                .map(entity -> mapper.map(entity, Product.class))
                .collect(Collectors.toList());
    }

    @Override
    public Product saveProduct(Product product) {
        return this.toEntity(this.repository.save(this.toData(product)));
    }

    @Override
    public void deleteProduct(long id) {
        this.repository.deleteById(id);
    }

    @Override
    public Product updateProduct(Product product) {
        return this.toEntity(this.repository.save(this.toData(product)));
    }
}
