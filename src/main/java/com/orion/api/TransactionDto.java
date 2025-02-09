package com.orion.api;

import com.orion.model.Transaction;

public record TransactionDto (
        Long id,
        String type,
        String date,
        String accountNumber,
        String currency,
        String amount,
        String merchantName,
        String merchantLogo
){
  public static TransactionDto from(Transaction transaction) {
      return new TransactionDto(
              transaction.getId(),
              transaction.getType(),
              transaction.getDate(),
              transaction.getAccountNumber(),
              transaction.getCurrency(),
              transaction.getAmount(),
              transaction.getMerchantName(),
              transaction.getMerchantLogo()
      );
  }

}
