package com.orion.api;

import com.orion.model.Transaction;
import com.orion.service.TransactionService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController {

  private final TransactionService transactionService;

  public TransactionController(TransactionService transactionService) {
    this.transactionService = transactionService;
  }

  @GetMapping("/{accountNumber}")
  List<Transaction> getTransactions(@PathVariable String accountNumber) {
    return transactionService.findAllByAccountNumber(accountNumber);
  }
}
