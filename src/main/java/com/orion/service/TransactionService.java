package com.orion.service;

import com.orion.model.Transaction;
import java.util.List;

import com.orion.persistence.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionService {
  private final TransactionRepository transactionRepository;

  public List<Transaction> findAllByAccountNumber(String accountNumber) {
    return transactionRepository.findByAccountNumber(accountNumber);
  }
}
