package com.example.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {
    private long id;
    private CategoryType categoryType;
    private String account_number;
    private String account_name;
    private CurrencyEnum currency;
    private double balance;
}
