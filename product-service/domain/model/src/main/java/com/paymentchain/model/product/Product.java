package com.paymentchain.model.product;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Product {
    private long id;
    private String code;
    private String name;
    private long customerId;
}
