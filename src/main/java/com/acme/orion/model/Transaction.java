package com.acme.orion.model;

import lombok.Data;

@Data
public class Transaction {
  private String id;
  private String type;
  private String date;
  private String accountNumber;
  private String currency;
  private String amount;
  private String merchantName;
  private String merchantLogo;
}
