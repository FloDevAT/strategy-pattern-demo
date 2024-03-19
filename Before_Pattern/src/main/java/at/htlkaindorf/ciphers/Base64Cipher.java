package at.htlkaindorf.ciphers;

import java.util.Base64;

public class Base64Cipher {
    public static String encrypt(String clearText) {
        return new String(Base64.getEncoder().encode(clearText.getBytes()));
    }

    public static String decrypt(String cipherText) {
        return new String(Base64.getDecoder().decode(cipherText.getBytes()));
    }
}
