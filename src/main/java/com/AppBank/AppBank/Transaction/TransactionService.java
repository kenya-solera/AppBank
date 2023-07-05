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
    public Transaction addNewTransaction(Transaction transaction) {
        Optional<Transaction> transactionOptional = transactionRepository
                .findById(transaction.getId());
        if(transactionOptional.isPresent()){
            throw new IllegalStateException("Transaction already exists");
    }
        return transactionRepository.save(transaction);
    }

    public Transaction findTransactionById(Long id) {
        return transactionRepository.findById(id).orElseThrow(() -> new IllegalStateException("Transaction not found"));
    }

    public List<Transaction>  getAllTransactions()
        {
            return transactionRepository.findAll();
        }


}


