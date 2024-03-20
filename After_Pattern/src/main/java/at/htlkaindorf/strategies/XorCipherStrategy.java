package at.htlkaindorf.strategies;

public class XorCipherStrategy extends AbstractEncryptionStrategy {
    @Override
    public String encrypt(String clearText, String key) throws Exception {
        StringBuilder cipher = new StringBuilder();

        if (key.isBlank()) {
            throw new Exception("Key required!");
        }

        for (int i = 0; i < clearText.length(); i++) {
            cipher.append((char) (clearText.charAt(i) ^ key.charAt(i % key.length())));
        }

        return cipher.toString();
    }

    @Override
    public String decrypt(String cipherText, String key) throws Exception {
        return encrypt(cipherText, key);
    }
}
