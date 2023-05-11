package com.example.orderswift.service.Transaction;

import com.example.orderswift.model.Transaction;

import java.util.List;

public interface TransactionService {
    Transaction createTransaction(Transaction transaction);
    List<Transaction> getAllTransactions();
    Transaction getTransactionById(Integer id);
    Transaction updateTransaction(Integer id, Transaction transaction);
    String deleteTransaction(Integer id);
}
