package com.example;

import java.util.Arrays;

public class SumDto {
    private int[] items;

    public SumDto() {
    }

    public int[] getItems() {
        return items;
    }

    public void setItems(int[] items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "SumDto{" +
                "items=" + Arrays.toString(items) +
                '}';
    }
}
