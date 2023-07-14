package com.AppBank.AppBank.Transaction;

import jakarta.persistence.TypedQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    //Optional<Transaction> findByTransactionId(String transaction_id);

    List<Transaction> findByAccountSenderIdOrAccountReceiverId(Long senderId, Long receiverId);

}
