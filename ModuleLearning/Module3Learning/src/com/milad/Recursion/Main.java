package com.milad.Recursion;

public class Main {
    public static void main(String[] args) {
        //System.out.println(multRecursive(5, 6));
        //System.out.println(factorial(4));
        hanoi(3, 1, 3, 2);
        System.out.println(count);
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


    static int count = 0;
    public static void printMove(int from, int to) {
        count++;
        System.out.println("Move: " + from + " to " + to);
    }

    public static void hanoi(int n, int from, int to, int spare) {
        if (n == 1) {
            printMove(from, to);
        } else {
            hanoi(n-1, from, spare, to);
            printMove(from, to);
            hanoi(n-1, spare, to, from);
        }
    }
}
