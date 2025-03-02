package com.milad.Module3_1;

public class Sequences {

    /**
     * Recursive algorithm to find get the n-th Fibonacci Number
     * @param n the n-th Fibonacci Number to find as an int
     * @return returns the n-th Fibonacci Number as an int
     */
    public static int fibonacciSequence(int n) {
        if (n == 0 || n == 1) { // Base case
            return n;
        }
        return fibonacciSequence(n-1) + fibonacciSequence(n-2); // Recursive step
    }
}
