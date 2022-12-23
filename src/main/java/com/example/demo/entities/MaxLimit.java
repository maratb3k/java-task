package com.example.demo.entities;

import com.example.demo.dtos.CurrencyEnum;
import com.example.demo.dtos.MaxLimitDTO;
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
@AllArgsConstructor
@Component
@Table(name = "max_limits")
@JsonIdentityInfo(scope = MaxLimit.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class MaxLimit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "currency_shortname")
    @Enumerated(EnumType.STRING)
    private CurrencyEnum currencyUSD;

    @Column(name = "product_max_limit")
    private double product_max_limit;

    @Column(name = "service_max_limit")
    private double service_max_limit;

    @Column(name = "date_time")
    private LocalDateTime dateTime = LocalDateTime.now();

    public MaxLimitDTO toDto() {
        return new MaxLimitDTO(
                this.id,
                this.currencyUSD,
                this.product_max_limit,
                this.service_max_limit,
                this.dateTime
        );
    }
}
