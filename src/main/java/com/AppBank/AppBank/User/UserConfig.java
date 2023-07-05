//package com.AppBank.AppBank.User;
////
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.time.LocalDate;
//import java.time.Month;
//import java.util.List;
//
//@Configuration
//public class UserConfig {
//    @Bean
//    CommandLineRunner commandLineRunner(UserRepository repository){
//        return args -> {
//            User mariam = new User(
//                    1L,
//                    "Mariam",
//                    "mariam.mariam@gmail.com",
//                    "user1", "pass")
//            ;
//            User mariam2 = new User(
//                    2L,
//                    "Mariam",
//                    "mariam.mariam@gmail.com",
//                    "user1", "pass")
//                    ;
//            repository.saveAll(
//                    List.of(mariam,mariam2)
//            );
//        };
//    }
//}

