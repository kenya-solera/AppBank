package com.AppBank.AppBank.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }
    public void addNewTransaction(Transaction transaction) {
        Optional<Transaction> transactionOptional = transactionRepository
                .findTransactionByTransactionId(transaction.getTransactionId());
        if(transactionOptional.isPresent()){
            throw new IllegalStateException("Transaction already exists");
    }
        transactionRepository.save(transaction);
    }

    public Transaction findTransactionById(String transactionId) {
        return transactionRepository.findTransactionByTransactionId(transactionId).orElseThrow(() -> new IllegalStateException("Transaction not found"));
    }

    public List<Transaction>  getAllTransactions()
        {
            return transactionRepository.findAll();
        }
}


