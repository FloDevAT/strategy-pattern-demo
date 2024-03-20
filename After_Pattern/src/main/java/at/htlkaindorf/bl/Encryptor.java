package at.htlkaindorf.bl;

import at.htlkaindorf.strategies.AbstractEncryptionStrategy;

public class Encryptor {

    private AbstractEncryptionStrategy strategy;

    public String encrypt(String clearText, String key) throws Exception {
        return this.strategy.encrypt(clearText, key);
    }
    public String decrypt(String cipherText, String key) throws Exception {
        return this.strategy.decrypt(cipherText, key);
    }

    public AbstractEncryptionStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(AbstractEncryptionStrategy strategy) {
        this.strategy = strategy;
    }
}
