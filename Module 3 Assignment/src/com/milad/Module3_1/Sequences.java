package com.milad.Module3_1;

public class Sequences {
    public static int seq1(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return seq1(n-1) + seq1(n-2);
    }
}
