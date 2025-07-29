package com.paymentchain.jpa;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String code;
    private String name;
    private String phone;
    private String iban;
    private String surname;
    private String address;
}
