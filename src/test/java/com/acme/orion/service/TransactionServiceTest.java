package com.acme.orion.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class TransactionServiceTest {

  @Test
  void should_return_from_3_to_5_transactions() {
    var transactionService = new TransactionService();

    var transactions = transactionService.findAllByAccountNumber("acme");

    assertThat(transactions).hasSize(4);
  }
}
