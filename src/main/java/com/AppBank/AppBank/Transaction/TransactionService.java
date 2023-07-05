package com.AppBank.AppBank.Transaction;

import java.util.List;

public class TransactionService {
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }
}
