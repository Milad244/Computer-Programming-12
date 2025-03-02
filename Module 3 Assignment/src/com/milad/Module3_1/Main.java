package com.milad.Module3_1;

public class Main {
    public static void main(String[] args) {
        System.out.println("Fibonacci Sequence");
        for(int i = 0; i < 11; i++) {
            System.out.print("Input: " + i + "\tOutput: " + Sequences.fibonacciSequence(i) + "\n");
        }
    }
}
