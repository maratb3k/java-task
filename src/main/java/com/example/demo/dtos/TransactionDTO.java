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
public class TransactionDTO {
    private long id;
    private long account_from;
    private long account_to;
    private CurrencyEnum currency;
    private double sum;
    private boolean limitExceeded;
    private LocalDateTime dateTime;
}
