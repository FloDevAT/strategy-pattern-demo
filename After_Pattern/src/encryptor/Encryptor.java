package encryptor;

import strategies.EncryptionStrategy;

public class Encryptor {
    private EncryptionStrategy strategy;

    public void setStrategy(EncryptionStrategy encryptionStrategy) {
        this.strategy = encryptionStrategy;
    }

    public String encode(String clearText, String key) {
        return this.strategy.encrypt(clearText, key);
    }

    public String decode(String cipherText, String key) {
        return this.strategy.decrypt(cipherText, key);
    }

}