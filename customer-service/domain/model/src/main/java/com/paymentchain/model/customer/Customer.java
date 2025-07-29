package com.paymentchain.model.customer;

import lombok.*;

@Data
public class Customer {
    private long id;
    private String code;
    private String name;
    private String phone;
    private String iban;
    private String surname;
    private String address;
}
