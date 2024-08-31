package com.example;

import org.springframework.stereotype.Service;

@Service
public class OperationsService {

    public int sum(int a, int b) {
        return a + b;
    }
}
