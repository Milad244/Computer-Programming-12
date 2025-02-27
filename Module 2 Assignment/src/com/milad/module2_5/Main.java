package com.milad.module2_5;

public class Main {
    public static void main(String[] args) {
        CaesarCipher topSecret = new CaesarCipher(1);
        String topSecretMessage = topSecret.encryptMessage("defend the east wall of the castle");
        System.out.println("Encrypted Message: " + topSecretMessage);
        System.out.println("Decrypted Message: " + topSecret.decryptMessage(topSecretMessage));

        CaesarCipher topTopSecret = new CaesarCipher(13);
        String topTopSecretMessage = topTopSecret.encryptMessage("this is so top secret");
        System.out.println("Encrypted Message: " + topTopSecretMessage);
        System.out.println("Decrypted Message: " + topTopSecret.decryptMessage(topTopSecretMessage));

        CaesarCipher topTopTopSecret = new CaesarCipher(3);
        String topTopTopSecretMessage = topTopTopSecret.encryptMessage("helloz world");
        System.out.println("Encrypted Message: " + topTopTopSecretMessage);
        System.out.println("Decrypted Message: " + topTopTopSecret.decryptMessage(topTopTopSecretMessage));
    }
}
