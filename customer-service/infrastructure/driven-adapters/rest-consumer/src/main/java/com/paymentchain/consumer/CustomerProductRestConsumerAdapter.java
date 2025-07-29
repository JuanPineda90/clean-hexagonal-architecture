package com.paymentchain.consumer;

import com.paymentchain.model.customerproduct.CustomerProduct;
import com.paymentchain.model.customerproduct.gateways.CustomerProductRepository;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import java.util.List;


@Component
public class CustomerProductRestConsumerAdapter implements CustomerProductRepository {

    private final RestClient restClient;

    public CustomerProductRestConsumerAdapter(@Value("${services.product.url}") String url) {
        this.restClient = RestClient.builder()
                .baseUrl(url)
                .build();
    }

    @Override
    public List<CustomerProduct> findProductsByCustomerId(long customerId) {
        return restClient
                .get()
                .uri("/customerId/{customerId}", customerId) // Ajusta según tu endpoint real
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(new ParameterizedTypeReference<>() {});
    }
}