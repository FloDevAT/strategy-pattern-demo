package at.htlkaindorf.ciphers;

import java.util.Base64;

public class ReversingCipher {
    public static String encrypt(String clearText) {
        return new StringBuilder(clearText).reverse().toString();
    }

    public static String decrypt(String cipherText) {
        return encrypt(cipherText);
    }
}
