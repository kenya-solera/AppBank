package com.AppBank.AppBank;

import jakarta.persistence.*;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
@ResponseBody
public class User {

    @Id
    @SequenceGenerator(
            name = "user",
            sequenceName = "user_seq",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_seq"
    )

    private Long id;
    private String FirstName;
    private String LastName;
    private String name;
    private String password;


    public User(){

    }

    public User(Long id, String firstName, String lastName, String name, String password) {
       this.id = id;
       this.FirstName = firstName;
       this.LastName = lastName;
       this.name = name;
       this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }




}
