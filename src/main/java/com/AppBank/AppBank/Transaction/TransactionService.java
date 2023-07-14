package com.AppBank.AppBank.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    private List<TransactionDTO> transactionToDTO(List<Transaction> transactions) {
        List<TransactionDTO> result = new ArrayList<TransactionDTO>();
        for(Transaction tx : transactions) {
            String description = tx.getAccountSender().getOwner().getFirstName()
                    + " sent " + tx.getAccountReceiver().getOwner().getFirstName();

            TransactionDTO transactionDTO = new TransactionDTO(tx.getId(), description, tx.getLikes(), tx.getAmount(), tx.getPhoto());
            result.add(transactionDTO);
        }

        return result;
    }
    public List<TransactionDTO> findAllTransactions() {
        List<Transaction> transactions = transactionRepository.findAll();
        return transactionToDTO(transactions);
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


