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
    @SequenceGenerator(
            name = "user",
            sequenceName = "user_seq",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.IDENTITY
            ,generator = "user_seq"
    )

    private Long id;

    private String FirstName;

    private String LastName;

    private String userName;

    private String password;

    @OneToMany(mappedBy = "owner")
    private List<Account> accounts;


//    public User(){
//
//    }

//    public User(Long id, String firstName, String lastName, String name, String password) {
//       this.id = id;
//       this.FirstName = firstName;
//       this.LastName = lastName;
//       this.userName = name;
//       this.password = password;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getFirstName() {
//        return FirstName;
//    }
//
//    public void setFirstName(String firstName) {
//        FirstName = firstName;
//    }
//
//    public String getLastName() {
//        return LastName;
//    }
//
//    public void setLastName(String lastName) {
//        LastName = lastName;
//    }
//
//    public String getName() {
//        return userName;
//    }
//
//    public void setName(String name) {
//        this.userName = name;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//
//    @Override
//    public String toString() {
//        return "User{" +
//                "id=" + id +
//                ", FirstName='" + FirstName + '\'' +
//                ", LastName='" + LastName + '\'' +
//                ", name='" + userName + '\'' +
//                ", password='" + password + '\'' +
//                '}';
//    }




}
