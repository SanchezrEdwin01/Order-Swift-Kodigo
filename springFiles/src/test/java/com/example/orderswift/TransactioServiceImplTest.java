package com.example.orderswift;

import com.example.orderswift.exception.ResourceNotFoundException;
import com.example.orderswift.model.Order;
import com.example.orderswift.model.Transaction;
import com.example.orderswift.model.User;
import com.example.orderswift.repository.TransactionRepository;
import com.example.orderswift.service.Transaction.TransactionServiceImpl;
import com.example.orderswift.service.order.OrderService;
import com.example.orderswift.service.user.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TransactionServiceImplTest {

    private TransactionServiceImpl transactionService;

    @Mock
    private TransactionRepository transactionRepository;

    @Mock
    private OrderService orderService;

    @Mock
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        transactionService = new TransactionServiceImpl(transactionRepository, orderService, userService);
    }


    @Test
    void getAllTransactions_TransactionsExist_ReturnsListOfTransactions() {
        // Arrange
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction());
        transactions.add(new Transaction());

        when(transactionRepository.findAll()).thenReturn(transactions);

        // Act
        List<Transaction> result = transactionService.getAllTransactions();

        // Assert
        assertEquals(transactions, result);
        verify(transactionRepository, times(1)).findAll();
    }

    @Test
    void getTransactionById_ValidId_ReturnsMatchingTransaction() {
        // Arrange
        Integer id = 1;
        Transaction transaction = new Transaction();
        when(transactionRepository.findById(id)).thenReturn(Optional.of(transaction));

        // Act
        Transaction result = transactionService.getTransactionById(id);

        // Assert
        assertEquals(transaction, result);
        verify(transactionRepository, times(1)).findById(id);
    }

    @Test
    void getTransactionById_InvalidId_ThrowsResourceNotFoundException() {
        // Arrange
        Integer id = 1;
        when(transactionRepository.findById(id)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(ResourceNotFoundException.class, () -> transactionService.getTransactionById(id));
        verify(transactionRepository, times(1)).findById(id);
    }

}