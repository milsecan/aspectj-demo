package com.example;

import org.springframework.stereotype.Service;
import java.util.Arrays;

@Service
public class OperationsService {

    public int sum(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }
}
