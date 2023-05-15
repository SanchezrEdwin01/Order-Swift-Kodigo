package com.example.orderswift.controller;


import com.example.orderswift.model.Transaction;
import com.example.orderswift.service.Transaction.TransactionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class TransactionControllerTest {

    @Mock
    private TransactionService transactionService;

    @InjectMocks
    private TransactionController transactionController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetTransactions() {
        List<Transaction> transactions = Arrays.asList(new Transaction(), new Transaction());
        when(transactionService.getAllTransactions()).thenReturn(transactions);

        List<Transaction> result = transactionController.getTransactions();

        assertEquals(transactions, result);
        verify(transactionService, times(1)).getAllTransactions();
    }

    @Test
    void testGetTransactionById() {
        Integer transId = 1;
        Transaction transaction = new Transaction();
        when(transactionService.getTransactionById(transId)).thenReturn(transaction);

        Transaction result = transactionController.getTransactionById(transId);

        assertEquals(transaction, result);
        verify(transactionService, times(1)).getTransactionById(transId);
    }

    @Test
    void testAddTransaction() {
        Transaction transaction = new Transaction();
        when(transactionService.createTransaction(transaction)).thenReturn(transaction);
        ResponseEntity<Transaction> expectedResponse = new ResponseEntity<>(transaction, HttpStatus.CREATED);

        ResponseEntity<Transaction> result = transactionController.addTransaction(transaction);

        assertEquals(expectedResponse, result);
        verify(transactionService, times(1)).createTransaction(transaction);
    }

    @Test
    void testEditTransaction() {
        Integer transId = 1;
        Transaction existingTransaction = new Transaction();
        Transaction newTransaction = new Transaction();
        when(transactionService.updateTransaction(transId, newTransaction)).thenReturn(existingTransaction);
        ResponseEntity<Transaction> expectedResponse = new ResponseEntity<>(existingTransaction, HttpStatus.OK);

        ResponseEntity<Transaction> result = transactionController.editTransaction(transId, newTransaction);

        assertEquals(expectedResponse, result);
        verify(transactionService, times(1)).updateTransaction(transId, newTransaction);
    }

    @Test
    void testRemoveTransaction() {
        Integer transId = 1;
        String successMessage = "Transaction deleted successfully";
        when(transactionService.deleteTransaction(transId)).thenReturn(successMessage);
        ResponseEntity<String> expectedResponse = new ResponseEntity<>(successMessage, HttpStatus.NO_CONTENT);

        ResponseEntity<String> result = transactionController.removeTransaction(transId);

        assertEquals(expectedResponse, result);
        verify(transactionService, times(1)).deleteTransaction(transId);
    }
}

