package com.example.demo.dtos;

import com.example.demo.entities.MaxLimit;
import com.example.demo.entities.RemainingLimit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDTO {
    private long id;
    private String account_number;
    private String name;
    private String surname;
    private CurrencyEnum currency;
    private MaxLimit userMaxLimit;
    private RemainingLimit userRemainingLimit;
    private double balance;
}
