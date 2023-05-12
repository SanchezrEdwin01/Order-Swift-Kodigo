package com.example.orderswift.service.Transaction;

import com.example.orderswift.exception.ResourceNotFoundException;
import com.example.orderswift.model.Order;
import com.example.orderswift.model.Transaction;
import com.example.orderswift.model.User;
import com.example.orderswift.repository.TransactionRepository;
import com.example.orderswift.service.order.OrderService;
import com.example.orderswift.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;
    private final OrderService orderService;
    private final UserService userService;
    @Override
    public Transaction createTransaction(Transaction transaction) {
        User user = orderService.getOrderById(transaction.getOrder().getOrderId())
                .getUser();
        Order order = orderService.getOrderById(transaction.getOrder().getOrderId());
        transaction.setUser(user);
        transaction.setOrder(order);
        return transactionRepository.save(transaction);
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    @Override
    public Transaction getTransactionById(Integer id) {
        return transactionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction not found for the id " + id));
    }

    //updateTransaction could change
    @Override
    public Transaction updateTransaction(Integer id, Transaction transaction) {
        Transaction existingTransaction = this.getTransactionById(id);
        existingTransaction.setUser(transaction.getUser() != null ?
                userService.getUser(transaction.getUser().getUserId())
                        .orElseThrow(() -> new ResourceNotFoundException("User not found")) : existingTransaction.getUser());
        existingTransaction.setOrder(transaction.getOrder() != null ?
                orderService.getOrderById(transaction.getOrder().getOrderId()) : existingTransaction.getOrder());
        existingTransaction.setAmount(transaction.getAmount() != null ? transaction.getAmount() : existingTransaction.getAmount());
        existingTransaction.setPaymentMethod(transaction.getPaymentMethod() != null ? transaction.getPaymentMethod() : existingTransaction.getPaymentMethod());
        return transactionRepository.save(existingTransaction);
    }

    @Override
    public String deleteTransaction(Integer id) {
        Transaction transaction = this.getTransactionById(id);
        transactionRepository.delete(transaction);
        return "Transaction with id " + id + " has been deleted";
    }
}
