package com.example.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MaxLimitDTO {
    private long id;
    private CurrencyEnum currencyUSD;
    private double product_max_limit;
    private double service_max_limit;
    private LocalDateTime dateTime = LocalDateTime.now();
}
