package com.AppBank.AppBank.Transaction;

import com.AppBank.AppBank.Account.Account;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.bind.annotation.ResponseBody;
import java.time.LocalDateTime;

@Entity
@Table
@ResponseBody
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Transaction {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )


private Long id;

//private String transaction_id;

private Double amount;

private LocalDateTime date;

private Integer likes;

//TODO añadir la foto del usuario

@ManyToOne
@JoinColumn(name="accountSender_id")
private Account accountSender;

@ManyToOne
@JoinColumn(name="accountReceiver_id")
private Account accountReceiver;

}


