package com.milad.Module3_2;

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

    public static int seq1(int n) {
        if (n == 0) { // Base case
            return 25;
        }
        return -2 + seq1(n-1); // Recursive step
    }

    public static int seq2(int n) {
        if (n == 0) { // Base case
            return 1;
        }
        return 2 * seq2(n-1); // Recursive step
    }

    public static int seq3(int n) {
        if (n == 0 || n == 1) { // Base case
            return 2;
        }
        return seq3(n-1) + seq3(n-2); // Recursive step
    }

    public static int seq4(int n) {
        if (n == 0 || n == 1) { // Base case
            return 3;
        }
        return seq4(n-1) + seq4(n-2); // Recursive step
    }

    public static int seq5(int n) {
        if (n == 0) { // Base case
            return 1;
        }
        return (n+1) * seq5(n-1); // Recursive step
    }
}
