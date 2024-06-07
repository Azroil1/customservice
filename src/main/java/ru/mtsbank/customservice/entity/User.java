package ru.mtsbank.customservice.entity;


import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "customer")
public class User {
    @Id
    @Column(name = "id_customers")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "bank_account_id", columnDefinition = "numeric(20,0)")
    private String bankAccountId;
    @Column(name = "phone_number", columnDefinition = "bpchar")
    private String phoneNumber;
    @Column(name = "password")
    private String password;
}
