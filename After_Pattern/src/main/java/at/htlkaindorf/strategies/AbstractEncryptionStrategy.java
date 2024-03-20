package at.htlkaindorf.strategies;

public abstract class AbstractEncryptionStrategy {
    public abstract String encrypt(String clearText, String key) throws Exception;
    public abstract String decrypt(String cipherText, String key) throws Exception;
}
