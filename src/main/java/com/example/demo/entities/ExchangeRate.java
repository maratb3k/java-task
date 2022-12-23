package com.example.demo.entities;

import com.example.demo.dtos.ExchangeRateDTO;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Component
@Table(name = "max_limits")
@AllArgsConstructor
@JsonIdentityInfo(scope = ExchangeRate.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class ExchangeRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "symbol")
    private String symbol;

    @Column(name = "date_time")
    private LocalDateTime dateTime;

    @Column(name = "close")
    private Double closeValue;


    public ExchangeRateDTO toDto() {
        return new ExchangeRateDTO(
                this.id,
                this.symbol,
                this.dateTime,
                this.closeValue
        );
    }
}
