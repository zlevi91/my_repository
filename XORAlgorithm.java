package com.company;

/**
 * Created by hackeru on 3/20/2017.
 */
public class XORAlgorithm extends Algorithms<Integer> {

    public XORAlgorithm( Key<Integer> key) {
        this.key=key;
    }

    @Override
    public int decryption(int oneByte) {
        return oneByte ^ (int)key.getKeyValue();
    }

    @Override
    public int encryption(int oneByte) {
        return decryption(oneByte);
    }

}
