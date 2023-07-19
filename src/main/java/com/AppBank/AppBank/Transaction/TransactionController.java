package com.AppBank.AppBank.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path = "/transactions")

public class TransactionController {
    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public List<TransactionDTO> getAllTransactions() {
        return transactionService.findAllTransactions();
    }

    @GetMapping(path = "/{id}")
    public Transaction getTransactionById(@PathVariable Long id) {
        return transactionService.findTransactionById(id);
    }

    @PostMapping
    public Transaction createTransaction(@RequestBody Transaction transaction){
        return transactionService.addNewTransaction(transaction);
    }
}