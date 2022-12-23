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
public class RemainingLimitDTO {
    private long id;
    private CurrencyEnum currencyUSD;
    private double product_remaining_limit;
    private double service_remaining_limit;
    private LocalDateTime dateTime = LocalDateTime.now();
}
