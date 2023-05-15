package com.example.orderswift.controller;

import com.example.orderswift.model.Transaction;
import com.example.orderswift.service.Transaction.TransactionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Transaction", description = "This controller makes a CRUD of all the transactions made in Order Swift")
@RestController
@RequestMapping("transaction")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;

    @Operation(description = "This gets all the transactions made")
    @GetMapping
    public List<Transaction> getTransactions(){
        return transactionService.getAllTransactions();
    }

    @Operation(description = "This operator gets a transaction by its id")
    @GetMapping("{transId}")
    public Transaction getTransactionById(@PathVariable Integer transId){
        return transactionService.getTransactionById(transId);
    }

    @Operation(description = "This operator adds a new transaction")
    @PostMapping("add")
    public ResponseEntity<Transaction> addTransaction(@RequestBody Transaction transaction){
        return new ResponseEntity<>(transactionService.createTransaction(transaction), HttpStatus.CREATED);
    }

    @Operation(description = "This operator updates a transaction by its id")
    @PutMapping("{transId}")
    public ResponseEntity<Transaction> editTransaction(@PathVariable Integer transId,
                                                       @RequestBody Transaction transaction){
        return new ResponseEntity<>(transactionService.updateTransaction(transId, transaction), HttpStatus.OK);
    }

    @Operation(description = "This operator deletes a transaction by its id")
    @DeleteMapping("{transId}")
    public ResponseEntity<String> removeTransaction(@PathVariable Integer transId){
        return new ResponseEntity<>(transactionService.deleteTransaction(transId), HttpStatus.NO_CONTENT);
    }
}
