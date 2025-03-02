package com.milad.Module3_2;

public class Main {
    public static void main(String[] args) {
        System.out.println("Sequence 1");
        for(int i = 0; i < 11; i++) {
            System.out.print("Input: " + i + "\tOutput: " + Sequences.seq1(i) + "\n");
        }
        System.out.println("Sequence 2");
        for(int i = 0; i < 11; i++) {
            System.out.print("Input: " + i + "\tOutput: " + Sequences.seq2(i) + "\n");
        }
        System.out.println("Sequence 3");
        for(int i = 0; i < 11; i++) {
            System.out.print("Input: " + i + "\tOutput: " + Sequences.seq3(i) + "\n");
        }
        System.out.println("Sequence 4");
        for(int i = 0; i < 11; i++) {
            System.out.print("Input: " + i + "\tOutput: " + Sequences.seq4(i) + "\n");
        }
        System.out.println("Sequence 5");
        for(int i = 0; i < 11; i++) {
            System.out.print("Input: " + i + "\tOutput: " + Sequences.seq5(i) + "\n");
        }
    }
}
