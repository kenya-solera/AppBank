package com.AppBank.AppBank.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
        List<TransactionDTO> result = new ArrayList<>();
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
        if (transaction.getId() != null) {
        Optional<Transaction> transactionOptional = transactionRepository
                .findById(transaction.getId());
        if(transactionOptional.isPresent()){
            throw new IllegalStateException("Transaction already exists");
    }}
        return transactionRepository.save(transaction);
    }

    public ResponseEntity<?> findTransactionById(Long id) {
        Optional<Transaction> transaction = transactionRepository.findById(id);
        if (transaction.isPresent()) {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            return new ResponseEntity<>(transaction.get(), headers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public List<Transaction>  getAllTransactions()
        {
            return transactionRepository.findAll();
        }

    public void deleteTransaction(Long id){
        transactionRepository.deleteById(id);
    }
}


