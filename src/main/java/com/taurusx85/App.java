package com.taurusx85;


import com.taurusx85.annotation.Log;

public class App {

    public static void main(String[] args) {
       print("Hello, World!");
    }


    @Log
    private static void print(String s) {
        System.out.println(s);
    }
}
