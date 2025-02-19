package com.milad.module2_4;

import java.io.IOException;
import java.util.HashSet;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        String textFilePath = "src/com/milad/module2_4/illiad.txt";
        Word word = new Word(textFilePath);

        HashSet unorderedSet = word.findUniqueWordCount();
        System.out.println("UNORDERED SET");
        System.out.println(unorderedSet);

        TreeSet orderedSet = new TreeSet<>(word.findUniqueWordCount());
        System.out.println("ORDERED SET");
        System.out.println(orderedSet);
    }
}
