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
        assertEquals(15, operationsService.sum(numbers));
    }

    @Test
    void testSumWithNegativeNumbers() {
        int[] numbers = {-1, -2, -3, -4, -5};
        assertEquals(-15, operationsService.sum(numbers));
    }

    @Test
    void testSumWithMixedNumbers() {
        int[] numbers = {-1, 2, -3, 4, -5};
        assertEquals(-3, operationsService.sum(numbers));
    }

    @Test
    void testSumWithEmptyArray() {
        int[] numbers = {};
        assertEquals(0, operationsService.sum(numbers));
    }

    @Test
    void testSumWithSingleElement() {
        int[] numbers = {42};
        assertEquals(42, operationsService.sum(numbers));
    }

    @Test
    void testSumWithLargeNumbers() {
        int[] numbers = {Integer.MAX_VALUE, 1, 2};
        assertEquals(Integer.MAX_VALUE + 3, operationsService.sum(numbers));
    }

    @Test
    void testSumWithOverflow() {
        int[] numbers = {Integer.MAX_VALUE, Integer.MAX_VALUE};
        assertEquals(-2, operationsService.sum(numbers));
    }
}
