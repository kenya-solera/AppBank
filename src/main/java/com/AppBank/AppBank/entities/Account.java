package com.AppBank.AppBank.entities;

import com.AppBank.AppBank.Transaction.Transaction;
import com.AppBank.AppBank.User.User;
import jakarta.persistence.*;
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
    @ManyToOne
    @JoinColumn(name="owner_id")
    private User owner;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "account_transaction",
    joinColumns = @JoinColumn(name = "transaction_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "account_id", referencedColumnName = "id"))
    private List<Transaction> transactions;

}
