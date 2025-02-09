package com.orion.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import com.orion.model.Transaction;
import com.orion.persistence.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class TransactionServiceTest {
    @Mock
    TransactionRepository transactionRepository;

    @BeforeEach
    void setUp() {
        var onlinePurchase = new Transaction();
        onlinePurchase.setType("Purchase");
        onlinePurchase.setDate("2025-01-28");
        onlinePurchase.setAccountNumber("123456789");
        onlinePurchase.setCurrency("USD");
        onlinePurchase.setAmount("150.25");
        onlinePurchase.setMerchantName("Amazon");
        onlinePurchase.setMerchantLogo("https://amazon.com/logo.png");

        var atmWithdrawal = new Transaction();
        atmWithdrawal.setType("Withdrawal");
        atmWithdrawal.setDate("2025-01-25");
        atmWithdrawal.setAccountNumber("123456789");
        atmWithdrawal.setCurrency("EUR");
        atmWithdrawal.setAmount("50.00");
        atmWithdrawal.setMerchantName("ATM Terminal");
        atmWithdrawal.setMerchantLogo("https://atmprovider.com/logo.png");

        var salaryCredit = new Transaction();
        salaryCredit.setType("Credit");
        salaryCredit.setDate("2025-01-15");
        salaryCredit.setAccountNumber("123456789");
        salaryCredit.setCurrency("INR");
        salaryCredit.setAmount("75000.00");
        salaryCredit.setMerchantName("Employer Pvt Ltd");
        salaryCredit.setMerchantLogo("https://employer.com/logo.png");

        var billPayment = new Transaction();
        billPayment.setType("Bill Payment");
        billPayment.setDate("2025-01-20");
        billPayment.setAccountNumber("123456789");
        billPayment.setCurrency("GBP");
        billPayment.setAmount("120.75");
        billPayment.setMerchantName("Utility Provider");
        billPayment.setMerchantLogo("https://utilityprovider.com/logo.png");

        when(transactionRepository.findByAccountNumber(anyString()))
                .thenReturn(List.of(onlinePurchase, atmWithdrawal, salaryCredit, billPayment));
    }

    @Test
    void should_return_from_4_transactions() {
        var transactionService = new TransactionService(transactionRepository);

        var transactions = transactionService.findAllByAccountNumber("acme");

        assertThat(transactions).hasSize(4);
    }
}
