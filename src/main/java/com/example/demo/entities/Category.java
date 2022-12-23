package com.example.demo.entities;

import com.example.demo.dtos.CategoryDTO;
import com.example.demo.dtos.CategoryType;
import com.example.demo.dtos.CurrencyEnum;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "category")
@Component
@JsonIdentityInfo(scope = Category.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "category_type")
    @Enumerated(EnumType.STRING)
    private CategoryType categoryType;

    @Column(name = "account_number")
    private String account_number;

    @Column(name = "account_name")
    private String account_name;

    @Column(name = "currency_shortname")
    @Enumerated(EnumType.STRING)
    private CurrencyEnum currency;

    @Column(name = "balance")
    private double balance;

    public CategoryDTO toDto() {
        return new CategoryDTO(
                this.id,
                this.categoryType,
                this.account_number,
                this.account_name,
                this.currency,
                this.balance
        );
    }
}
