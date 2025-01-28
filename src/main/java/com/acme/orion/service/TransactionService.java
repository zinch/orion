package com.acme.orion.service;

import com.acme.orion.model.Transaction;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
  public List<Transaction> findAllByAccountNumber(String accountNumber) {
    // Test Data Object 1: Online Purchase
    var onlinePurchase = new Transaction();
    onlinePurchase.setType("Purchase");
    onlinePurchase.setDate("2025-01-28");
    onlinePurchase.setAccountNumber("123456789");
    onlinePurchase.setCurrency("USD");
    onlinePurchase.setAmount("150.25");
    onlinePurchase.setMerchantName("Amazon");
    onlinePurchase.setMerchantLogo("https://amazon.com/logo.png");

// Test Data Object 2: ATM Withdrawal
    var atmWithdrawal = new Transaction();
    atmWithdrawal.setType("Withdrawal");
    atmWithdrawal.setDate("2025-01-25");
    atmWithdrawal.setAccountNumber("987654321");
    atmWithdrawal.setCurrency("EUR");
    atmWithdrawal.setAmount("50.00");
    atmWithdrawal.setMerchantName("ATM Terminal");
    atmWithdrawal.setMerchantLogo("https://atmprovider.com/logo.png");

// Test Data Object 3: Salary Credit
    var salaryCredit = new Transaction();
    salaryCredit.setType("Credit");
    salaryCredit.setDate("2025-01-15");
    salaryCredit.setAccountNumber("112233445");
    salaryCredit.setCurrency("INR");
    salaryCredit.setAmount("75000.00");
    salaryCredit.setMerchantName("Employer Pvt Ltd");
    salaryCredit.setMerchantLogo("https://employer.com/logo.png");

// Test Data Object 4: Bill Payment
    var billPayment = new Transaction();
    billPayment.setType("Bill Payment");
    billPayment.setDate("2025-01-20");
    billPayment.setAccountNumber("556677889");
    billPayment.setCurrency("GBP");
    billPayment.setAmount("120.75");
    billPayment.setMerchantName("Utility Provider");
    billPayment.setMerchantLogo("https://utilityprovider.com/logo.png");

    return List.of(onlinePurchase, atmWithdrawal, salaryCredit, billPayment);
  }
}
