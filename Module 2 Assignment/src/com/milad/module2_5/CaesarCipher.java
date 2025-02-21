package com.milad.module2_5;

import java.util.Iterator;
import java.util.LinkedHashMap;

public class CaesarCipher {
    private final int shiftKey;
    private final char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private final LinkedHashMap<Integer, Character> alphabetMap = new LinkedHashMap<>();
    private final LinkedHashMap<Character, Integer> encryptMap = new LinkedHashMap<>();

    /**
     * Constructs the Caesar Cipher with its shift key that controls how many letters will shift when encrypting
     * @param shiftKey shift key that controls how many letters will shift when encrypting as an int
     */
    public CaesarCipher(int shiftKey) {
        this.shiftKey = shiftKey;

        for (int i = 0; i < 26; i++) {
            alphabetMap.put(i, alphabet[i]);
        }

        for (int i = 0; i < 26; i++) {
            encryptMap.put(alphabet[i], i + shiftKey);
        }
    }

    /**
     * Encrypts a message using the Caesar Cipher based on the shift key
     * @param message any secret message as a string
     * @return the encrypted message as a string. conserves spaces but removes any special characters and lowers capital letters
     */
    public String encryptMessage(String message) {
        String encryptedMessage = "";

        for (char c : message.toLowerCase().toCharArray()) {
            if (c == ' ') { //keeping spaces
                encryptedMessage += ' ';
            }

            Iterator<Character> iterator = encryptMap.keySet().iterator();
            while (iterator.hasNext()) {
                char ch = iterator.next();
                if (c == ch) {
                    int encryptKey  = encryptMap.get(ch); //getting the shifted key

                    // anything over 25 and we need it to be 1 not 26 etc
                    if (encryptKey > 25) {
                        encryptKey = encryptKey % 26;
                    }

                    // anything under 0 and we need it to be 25 instead of -1
                    if (encryptKey < 0) {
                        encryptKey = 26 + encryptKey % 26;
                    }

                    encryptedMessage += alphabetMap.get(encryptKey);
                }
            }
        }

        return encryptedMessage;
    }

    /**
     * Decrypts an encrypted message using the Caesar Cipher based on the shift key
     * @param encryptedMessage any encrypted message as a string
     * @return the decrypted message as a string
     */
    public String decryptMessage(String encryptedMessage) {
        String decryptedMessage = "";

        for (char c : encryptedMessage.toLowerCase().toCharArray()) {
            if (c == ' ') {
                decryptedMessage += ' ';
            }

            Iterator<Character> iterator = encryptMap.keySet().iterator();
            while (iterator.hasNext()) {
                char ch = iterator.next();
                if (c == ch) {
                    // shifted key for the shifted character - 2 times the shift amount
                    int decryptKey = encryptMap.get(ch) - 2*shiftKey;

                    if (decryptKey > 25) {
                        decryptKey = decryptKey % 26;
                    }

                    if (decryptKey < 0) {
                        decryptKey = 26 + decryptKey % 26;
                    }

                    decryptedMessage += alphabetMap.get(decryptKey);
                }
            }
        }

        return decryptedMessage;
    }
}
