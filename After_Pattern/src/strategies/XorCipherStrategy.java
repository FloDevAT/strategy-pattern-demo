package strategies;

public class XorCipherStrategy extends EncryptionStrategy {
    @Override
    public String encrypt(String clearText, String key) {
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < clearText.length(); i++) {
            output.append((char) (clearText.charAt(i) ^ key.charAt(0)));
        }
        
        return output.toString();
    }

    @Override
    public String decrypt(String cipherText, String key) {
        return encrypt(cipherText, key);
    }
}
