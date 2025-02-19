package com.milad.module2_4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class Word {
    private final String textFilePath;

    public Word(String textFilePath) {
        this.textFilePath = textFilePath;
    }

    /**
     * Finds all the unique words in the Word class text file, prints the number of unique words and returns the hashset
     * @return the hashset containing all the unique words
     * @throws IOException not using try/except because was told to stick with throws IOException until later
     */
    public HashSet<String> findUniqueWordCount () throws IOException {
        FileReader fr = new FileReader(textFilePath);
        BufferedReader br = new BufferedReader(fr);

        // Any duplicate words added will not be seen more than once because hashsets do not allow duplicates!
        HashSet<String> uniqueWords = new HashSet<>();

        String currentWord = "";
        int currentCharacter;

        while ((currentCharacter = br.read()) != -1) {
            // adds the character in lowercase to the currentWord if they are a letter
            // I also added another argument to not make a new word if currentCharacter is being used as an apostrophe
            if (Character.isLetter(currentCharacter) || (currentCharacter == '\'' && !currentWord.isEmpty())) {
                currentWord += Character.toLowerCase((char) currentCharacter);
            } else if (!currentWord.isEmpty()) {
                uniqueWords.add(currentWord);
                currentWord = "";
            }
        }

        // making sure if the last word does not end with punctuation it is still added
        if (!currentWord.isEmpty()) {
            uniqueWords.add(currentWord);
        }

        System.out.println("Number of unique words: " + uniqueWords.size());

        return uniqueWords;
    }
}
