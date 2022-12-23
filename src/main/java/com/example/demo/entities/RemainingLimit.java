package com.example.demo.entities;

import com.example.demo.dtos.CurrencyEnum;
import com.example.demo.dtos.RemainingLimitDTO;
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
@Table(name = "remaining_limits")
@JsonIdentityInfo(scope = RemainingLimit.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class RemainingLimit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "currency_shortname")
    @Enumerated(EnumType.STRING)
    private CurrencyEnum currencyUSD;

    @Column(name = "product_remaining_limit")
    private double product_remaining_limit;

    @Column(name = "service_remaining_limit")
    private double service_remaining_limit;

    @Column(name = "date_time")
    private LocalDateTime dateTime = LocalDateTime.now();

    public RemainingLimitDTO toDto() {
        return new RemainingLimitDTO(
                this.id,
                this.currencyUSD,
                this.product_remaining_limit,
                this.service_remaining_limit,
                this.dateTime
        );
    }
}
