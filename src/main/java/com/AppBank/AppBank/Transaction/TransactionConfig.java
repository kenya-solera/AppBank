package com.AppBank.AppBank.Transaction;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TransactionConfig {

    @Bean
    CommandLineRunner commandLineRunner(TransactionRepository repository) {
        return args -> {
            repository.save(new Transaction(1L, 10L, 100L, 1000L, 10000L));
            repository.save(new Transaction(2L, 20L, 200L, 2000L, 20000L));
        };
    }
}
