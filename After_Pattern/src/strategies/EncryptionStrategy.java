package strategies;

public abstract class EncryptionStrategy {
    public abstract String encrypt(String clearText, String key);

    public abstract String decrypt(String cipherText, String key);
}