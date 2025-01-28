package com.acme.orion.api;

import com.acme.orion.model.Transaction;
import com.acme.orion.service.TransactionService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

  private final TransactionService transactionService;

  public TransactionController(TransactionService transactionService) {
    this.transactionService = transactionService;
  }

  @GetMapping("/transactions/{accountNumber}")
  List<Transaction> getTransactions(@PathVariable String accountNumber) {
    return transactionService.findAllByAccountNumber(accountNumber);
  }
}
