package com.paymentchain.model.customerproduct;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerProductDTO {
    private String code;
    private String productName;
}
