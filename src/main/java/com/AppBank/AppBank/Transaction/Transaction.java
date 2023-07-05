package com.AppBank.AppBank.Transaction;

import jakarta.persistence.*;
import org.springframework.web.bind.annotation.ResponseBody;
import java.time.LocalDateTime;

@Entity
@Table
@ResponseBody
public class Transaction {
    @Id
    @SequenceGenerator(
            name = "transaction_id_seq",
            sequenceName = "transaction_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "transaction_id_seq"
    )


private Long id;

//private String transaction_id;

private Double amount;

private Long from_account_id;

private Long to_account_id;

private LocalDateTime date;

private Integer likes;

//TODO añadir la foto del usuario

//@ManyToOne
//@JoinColumn(name = "account_id")
//private Account account;



public Transaction(){}

public Transaction(Long id, /*String transaction_id,*/ Double amount, Long from_account_id, Long to_account_id){
        this.id = id;
        //this.transaction_id = transaction_id;
        this.amount = amount;
        this.from_account_id = from_account_id;
        this.to_account_id = to_account_id;
        this.date = LocalDateTime.now();
        this.likes = 0;
        }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public String getTransactionId() {
//        return transaction_id;
//    }

//    public void setTransactionId(String transaction_id) {
//        this.transaction_id = transaction_id;
//    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Long getFrom_id() {
        return from_account_id;
    }

    public void setFrom_id(Long from_id) {
        this.from_account_id = from_id;
    }

    public Long getTo_id() {
        return to_account_id;
    }

    public void setTo_id(Long to_id) {
        this.to_account_id = to_id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                //", transactionId='" + transaction_id + '\'' +
                ", amount=" + amount +
                ", from_account_id=" + from_account_id +
                ", to_id=" + to_account_id +
                ", date=" + date +
                ", likes=" + likes +
                '}';
    }
}


