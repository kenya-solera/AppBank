package com.AppBank.AppBank.entities;

import com.AppBank.AppBank.Transaction.Transaction;
import com.AppBank.AppBank.User;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    private BigDecimal balance; //using BigDecimal because it is more precise for financial operations

    @NonNull
    //Connect to user: many to one
    private User owner;
    //Connect to transactions: many to many
    private List<Transaction> transactions;



}
