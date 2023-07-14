package com.AppBank.AppBank.Account;

import com.AppBank.AppBank.Transaction.Transaction;
import com.AppBank.AppBank.User.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private BigDecimal balance; //using BigDecimal because it is more precise for financial operations

    @ManyToOne
    @JoinColumn(name="owner_id")
    @JsonBackReference
    private User owner;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "account_transaction",
    joinColumns = @JoinColumn(name = "transaction_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "account_id", referencedColumnName = "id"))
    @JsonManagedReference
    private List<Transaction> transactions;

}
