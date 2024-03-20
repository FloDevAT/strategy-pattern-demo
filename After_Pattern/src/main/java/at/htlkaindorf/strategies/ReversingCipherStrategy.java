package at.htlkaindorf.strategies;

public class ReversingCipherStrategy extends AbstractEncryptionStrategy {
    @Override
    public String encrypt(String clearText, String key) throws Exception {
        return new StringBuilder(clearText).reverse().toString();
    }

    @Override
    public String decrypt(String cipherText, String key) throws Exception {
        return encrypt(cipherText, key);
    }
}
