package com.paymentchain.model.customerwithproducts;
import com.paymentchain.model.customer.Customer;
import com.paymentchain.model.customerproduct.CustomerProduct;
import com.paymentchain.model.customerproduct.CustomerProductDTO;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Getter;
//import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
//@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class CustomerWithProducts {
    private Customer customer;
    private List<CustomerProductDTO> products;
}
