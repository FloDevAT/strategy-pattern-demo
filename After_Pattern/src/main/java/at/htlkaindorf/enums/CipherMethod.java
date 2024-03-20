package at.htlkaindorf.enums;

import at.htlkaindorf.strategies.AbstractEncryptionStrategy;
import at.htlkaindorf.strategies.Base64CipherStrategy;
import at.htlkaindorf.strategies.ReversingCipherStrategy;
import at.htlkaindorf.strategies.XorCipherStrategy;

public enum CipherMethod {
    BASE64(new Base64CipherStrategy()),
    XOR(new XorCipherStrategy()),
    REVERSE(new ReversingCipherStrategy());

    private AbstractEncryptionStrategy strategy;

    private CipherMethod(AbstractEncryptionStrategy strategy) {
        this.strategy = strategy;
    }

    public AbstractEncryptionStrategy getStrategy() {
        return strategy;
    }
}
