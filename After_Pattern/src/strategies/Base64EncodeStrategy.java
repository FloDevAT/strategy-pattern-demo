package strategies;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Base64EncodeStrategy extends EncryptionStrategy {

    @Override
    public String encrypt(String clearText, String key) {
        return new String(Base64.getEncoder().encode(clearText.getBytes()));
    }

    @Override
    public String decrypt(String cipherText, String key) {
        return new String(Base64.getDecoder().decode(cipherText.getBytes()));
    }

}
