package com.milad.module2_5;

public class Main {
    public static void main(String[] args) {
        CaesarCipher topSecret = new CaesarCipher(1);
        String topSecretMessage = topSecret.encryptMessage("zadsz");
        System.out.println("Encrypted Message: " + topSecretMessage);
        System.out.println("Decrypted Message: " + topSecret.decryptMessage(topSecretMessage));

        CaesarCipher topTopSecret = new CaesarCipher(13);
        String topTopSecretMessage = topTopSecret.encryptMessage("This is so top secret");
        System.out.println("Encrypted Message: " + topTopSecretMessage);
        System.out.println("Decrypted Message: " + topTopSecret.decryptMessage(topTopSecretMessage));
    }
}
