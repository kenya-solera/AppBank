package com.AppBank.AppBank.Transaction;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TransactionConfig {

    @Bean
    CommandLineRunner commandLineRunner(TransactionRepository repository) {
        return args -> {
            Transaction transacion1 = (new Transaction(
                    1L,
                    "1A",
                    100d,
                    1000L,
                    10000L)
            );
            Transaction transaction2 = (new Transaction(
                    2L,
                    "2A",
                    200d,
                    2000L,
                    20000L));
        };
    }
}
