package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OperationsServiceTest {

    private OperationsService operationsService;

    @BeforeEach
    void setUp() {
        operationsService = new OperationsService();
    }

    @Test
    void testSumWithPositiveNumbers() {
        int[] numbers = {1, 2, 3, 4, 5};
        SumDto sumDto = new SumDto();
        sumDto.setItems(numbers);
        assertEquals(15, operationsService.sum(sumDto));
    }

    @Test
    void testSumWithNegativeNumbers() {
        int[] numbers = {-1, -2, -3, -4, -5};
        SumDto sumDto = new SumDto();
        sumDto.setItems(numbers);
        assertEquals(-15, operationsService.sum(sumDto));
    }

    @Test
    void testSumWithMixedNumbers() {
        int[] numbers = {-1, 2, -3, 4, -5};
        SumDto sumDto = new SumDto();
        sumDto.setItems(numbers);
        assertEquals(-3, operationsService.sum(sumDto));
    }

    @Test
    void testSumWithEmptyArray() {
        int[] numbers = {};
        SumDto sumDto = new SumDto();
        sumDto.setItems(numbers);
        assertEquals(0, operationsService.sum(sumDto));
    }

    @Test
    void testSumWithSingleElement() {
        int[] numbers = {42};
        SumDto sumDto = new SumDto();
        sumDto.setItems(numbers);
        assertEquals(42, operationsService.sum(sumDto));
    }

    @Test
    void testSumWithLargeNumbers() {
        int[] numbers = {Integer.MAX_VALUE, 1, 2};
        SumDto sumDto = new SumDto();
        sumDto.setItems(numbers);
        assertEquals(Integer.MAX_VALUE + 3, operationsService.sum(sumDto));
    }

    @Test
    void testSumWithOverflow() {
        int[] numbers = {Integer.MAX_VALUE, Integer.MAX_VALUE};
        SumDto sumDto = new SumDto();
        sumDto.setItems(numbers);
        assertEquals(-2, operationsService.sum(sumDto));
    }
}