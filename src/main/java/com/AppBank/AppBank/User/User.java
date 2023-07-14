package com.AppBank.AppBank.User;


import com.AppBank.AppBank.Account.Account;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Entity
@Table
@ResponseBody
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String FirstName;

    private String LastName;

    private String userName;

    private String password;

    private String phoneNumber;

    @OneToMany(mappedBy = "owner")
    private List<Account> accounts;

}
