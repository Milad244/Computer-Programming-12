package com.milad.Recursion;

public class Main {
    public static void main(String[] args) {
        System.out.println(multRecursive(5, 6));
        System.out.println(factorial(4));
    }

    public static int multRecursive(int a, int b) {
        if (b == 1) {
            return a;
        }
        return a + multRecursive(a, b-1);
    }

    public static int factorial(int num) {
        if (num == 1) {
            return num;
        }
        return num * factorial(num-1);
    }
}
