package at.htlkaindorf.ciphers;

import java.util.Base64;

public class XorCipher {
    public static String encrypt(String clearText, String key) throws Exception {
        StringBuilder cipher = new StringBuilder();

        if (key.isBlank()) {
            throw new Exception("Key required!");
        }

        for (int i = 0; i < clearText.length(); i++) {
            cipher.append((char) (clearText.charAt(i) ^ key.charAt(i % key.length())));
        }

        return cipher.toString();
    }

    public static String decrypt(String cipherText, String key) throws Exception {
        return encrypt(cipherText, key);
    }
}
