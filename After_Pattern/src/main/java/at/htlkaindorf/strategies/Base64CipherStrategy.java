package at.htlkaindorf.strategies;

import java.util.Base64;

public class Base64CipherStrategy extends AbstractEncryptionStrategy {
    @Override
    public String encrypt(String clearText, String key) throws Exception {
        return new String(Base64.getEncoder().encode(clearText.getBytes()));
    }

    @Override
    public String decrypt(String cipherText, String key) throws Exception {
        return new String(Base64.getDecoder().decode(cipherText.getBytes()));
    }
}
