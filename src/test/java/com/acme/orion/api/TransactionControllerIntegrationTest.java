package com.acme.orion.api;

import com.acme.orion.model.Transaction;
import com.acme.orion.service.TransactionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.http.MediaType;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TransactionController.class)
class TransactionControllerIntegrationTest {
    static final String ACCOUNT_NUMBER = "123456789";
    
    MockMvc mockMvc;

    @MockitoBean
    TransactionService transactionService;

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(new TransactionController(transactionService)).build();
    }

    @Test
    void should_return_transactions() throws Exception {
        var firstOnlinePurchase = makeTransaction("tx1", "2025-01-28", "150.25");
        var secondOnlinePurchase = makeTransaction("tx2", "2025-01-29", "7.99");

        var transactions = List.of(firstOnlinePurchase, secondOnlinePurchase);
        when(transactionService.findAllByAccountNumber(ACCOUNT_NUMBER)).thenReturn(transactions);

        mockMvc.perform(get("/transactions/" + ACCOUNT_NUMBER).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[*].id").value(contains("tx1", "tx2")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[*].amount").value(contains("150.25", "7.99")));
    }

    static Transaction makeTransaction(String txId, String date, String amount) {
        var onlinePurchase = new Transaction();
        onlinePurchase.setId(txId);
        onlinePurchase.setType("Purchase");
        onlinePurchase.setDate(date);
        onlinePurchase.setAccountNumber(ACCOUNT_NUMBER);
        onlinePurchase.setCurrency("USD");
        onlinePurchase.setAmount(amount);
        onlinePurchase.setMerchantName("Amazon");
        onlinePurchase.setMerchantLogo("https://amazon.com/logo.png");
        return onlinePurchase;
    }
}
