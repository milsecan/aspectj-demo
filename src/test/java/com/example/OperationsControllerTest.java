package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(OperationsController.class)
public class OperationsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OperationsService operationsService;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        // No setup needed as we're using @WebMvcTest
    }

    @Test
    void testSumWithValidInput() throws Exception {
        SumDto sumDto = new SumDto();
        sumDto.setItems(new int[]{1, 2, 3});

        when(operationsService.sum(any())).thenReturn(6);

        mockMvc.perform(post("/operations/sum")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(sumDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(6));

        verify(operationsService).sum(new int[]{1, 2, 3});
    }

    @Test
    void testSumWithNegativeNumbers() throws Exception {
        SumDto sumDto = new SumDto();
        sumDto.setItems(new int[]{-1, -2, -3});

        when(operationsService.sum(any())).thenReturn(-6);

        mockMvc.perform(post("/operations/sum")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(sumDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(-6));

        verify(operationsService).sum(new int[]{-1, -2, -3});
    }

    @Test
    void testSumWithEmptyArray() throws Exception {
        SumDto sumDto = new SumDto();
        sumDto.setItems(new int[]{});

        when(operationsService.sum(any())).thenReturn(0);

        mockMvc.perform(post("/operations/sum")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(sumDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(0));

        verify(operationsService).sum(new int[]{});
    }

    @Test
    void testSumWithLargeNumbers() throws Exception {
        SumDto sumDto = new SumDto();
        sumDto.setItems(new int[]{Integer.MAX_VALUE, 1});

        when(operationsService.sum(any())).thenReturn(Integer.MAX_VALUE + 1);

        mockMvc.perform(post("/operations/sum")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(sumDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(Integer.MAX_VALUE + 1));

        verify(operationsService).sum(new int[]{Integer.MAX_VALUE, 1});
    }
}
