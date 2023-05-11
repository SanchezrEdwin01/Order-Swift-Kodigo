package com.example.orderswift.controller;

import com.example.orderswift.model.Transaction;
import com.example.orderswift.service.Transaction.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("transaction")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;

    @GetMapping
    public List<Transaction> getTransactions(){
        return transactionService.getAllTransactions();
    }

    @GetMapping("{transId}")
    public Transaction getTransactionById(@PathVariable Integer transId){
        return transactionService.getTransactionById(transId);
    }

    @PostMapping("add")
    public ResponseEntity<Transaction> addTransaction(@RequestBody Transaction transaction){
        return new ResponseEntity<>(transactionService.createTransaction(transaction), HttpStatus.CREATED);
    }

    @PutMapping("{transId}")
    public ResponseEntity<Transaction> editTransaction(@PathVariable Integer transId,
                                                       @RequestBody Transaction transaction){
        return new ResponseEntity<>(transactionService.updateTransaction(transId, transaction), HttpStatus.OK);
    }

    @DeleteMapping("{transId}")
    public ResponseEntity<String> removeTransaction(@PathVariable Integer transId){
        return new ResponseEntity<>(transactionService.deleteTransaction(transId), HttpStatus.NO_CONTENT);
    }
}
