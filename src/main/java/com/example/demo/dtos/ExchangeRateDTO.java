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
public class ExchangeRateDTO {
    private long id;
    private String symbol;
    private LocalDateTime dateTime;
    private Double closeValue;
}
