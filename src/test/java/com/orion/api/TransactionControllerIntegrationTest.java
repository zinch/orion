package com.orion.api;

import com.orion.service.TransactionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TransactionController.class)
class TransactionControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    TransactionService transactionService;

    @Test
    void should_return_transactions() throws Exception {
        mockMvc.perform(get("/api/v1/transactions/123456")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
