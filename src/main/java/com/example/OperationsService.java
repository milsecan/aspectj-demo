package com.example;

import org.springframework.stereotype.Service;
import java.util.Arrays;

@Service
public class OperationsService {

    public int sum(SumDto sumDto) {
        return Arrays.stream(sumDto.getItems()).sum();
    }
}
