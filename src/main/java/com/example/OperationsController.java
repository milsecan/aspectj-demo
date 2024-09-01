package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/operations")
public class OperationsController {

    private final OperationsService operationsService;

    @Autowired
    public OperationsController(OperationsService operationsService) {
        this.operationsService = operationsService;
    }

    @PostMapping("/sum")
    public ResponseEntity<Map<String, Integer>> sum(@RequestBody SumDto sumDto) {
        int result = operationsService.sum(sumDto);
        Map<String, Integer> response = new HashMap<>();
        response.put("result", result);
        return ResponseEntity.ok(response);
    }
}
