package com.company;

/**
 * Created by hackeru on 3/16/2017.
 */
public class CaesarAlgorithm extends Algorithms<Integer> {

    public CaesarAlgorithm(Key<Integer> key) {
        this.key=key;
    }

    @Override
    public int encryption(int oneByte) {
        return oneByte + (int)key.getKeyValue();
    }
    @Override
    public int decryption(int oneByte) {
        return oneByte - (int)key.getKeyValue();
    }

}
