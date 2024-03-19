package enums;

import strategies.Base64EncodeStrategy;
import strategies.EncryptionStrategy;
import strategies.XorCipherStrategy;

public enum CipherMethod {
    BASE_64("Base64", new Base64EncodeStrategy()),
    BASE_32("Base32", new Base64EncodeStrategy()),
    XOR("XOR", new XorCipherStrategy());

    private String name;
    private EncryptionStrategy strategy;

    private CipherMethod(String name, EncryptionStrategy strategy) {
        this.name = name;
        this.strategy = strategy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EncryptionStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(EncryptionStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
