package com.example.demo.entities;

import com.example.demo.dtos.CurrencyEnum;
import com.example.demo.dtos.UserDTO;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Component
@Table(name = "users")
@JsonIdentityInfo(scope = User.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "account_number")
    private String account_number;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "currency_shortname")
    @Enumerated(EnumType.STRING)
    private CurrencyEnum currency;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "maxLimit_id")
    private MaxLimit userMaxLimit;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "remainingLimit_id")
    private RemainingLimit userRemainingLimit;

    @Column(name = "balance")
    private double balance;

    public UserDTO toDto() {
        return new UserDTO(
                this.id,
                this.account_number,
                this.name,
                this.surname,
                this.currency,
                this.userMaxLimit,
                this.userRemainingLimit,
                this.balance
        );
    }
}
