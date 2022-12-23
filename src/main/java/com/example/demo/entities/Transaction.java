package com.example.demo.entities;

import com.example.demo.dtos.CategoryType;
import com.example.demo.dtos.CurrencyEnum;
import com.example.demo.dtos.TransactionDTO;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Component
@ToString
@Table(name = "expense_transactions")
@JsonIdentityInfo(scope = Transaction.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "account_from")
    private long account_from;

    @Column(name = "account_to")
    private long account_to;

    @Column(name = "currency_shortname")
    @Enumerated(EnumType.STRING)
    private CurrencyEnum currency;

    @Column(name = "sum")
    private double sum;

    @Column(name = "limit_exceeded")
    private boolean limitExceeded;
    @Column(name = "date_time")
    private LocalDateTime dateTime;

    public Transaction(long id, long account_from, long account_to, CurrencyEnum currency, double sum, boolean limitExceeded, LocalDateTime dateTime) {
        this.id = id;
        this.account_from = account_from;
        this.account_to = account_to;
        this.currency = currency;
        this.sum = sum;
        this.limitExceeded = false;
        this.dateTime = dateTime;
    }

    public TransactionDTO toDto() {
        return new TransactionDTO(
                this.id,
                this.account_from,
                this.account_to,
                this.currency,
                this.sum,
                this.limitExceeded,
                this.dateTime
        );
    }

    public void transferFromUser(User user, Category category) {
        double max_limit = 0;
        double remaining_limit = 0;
        if(category.getCategoryType() == CategoryType.PRODUCT) {
            max_limit = user.getUserMaxLimit().getProduct_max_limit();
            remaining_limit = user.getUserRemainingLimit().getProduct_remaining_limit();
        } else if(category.getCategoryType() == CategoryType.SERVICE) {
            max_limit = user.getUserMaxLimit().getService_max_limit();
            remaining_limit = user.getUserRemainingLimit().getService_remaining_limit();
        }
        double category_balance = category.getBalance() + this.getSum();
        category.setBalance(category_balance);
        double user_balance = user.getBalance() - this.getSum();
        user.setBalance(user_balance);
        remaining_limit -= this.getSum();
        if(category.getCategoryType() == CategoryType.PRODUCT) {
            user.getUserRemainingLimit().setProduct_remaining_limit(remaining_limit);
        }
        else {
            user.getUserRemainingLimit().setService_remaining_limit(remaining_limit);
        }
        if(remaining_limit < 0)
            this.limitExceeded = true;
            //throw new LimitExceededException("You have exceeded the limit");
    }
}
