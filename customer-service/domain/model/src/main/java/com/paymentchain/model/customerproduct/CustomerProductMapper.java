package com.paymentchain.model.customerproduct;

public class CustomerProductMapper {

    private CustomerProductMapper() {
        // Constructor privado para evitar instanciación
    }

    public static CustomerProductDTO fromProduct(CustomerProduct product) {
        if (product == null) {
            return null;
        }
        return new CustomerProductDTO(
                product.getCode(),
                product.getName()
        );
    }
}
