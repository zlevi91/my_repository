package com.company;

/**
 * Created by hackeru on 3/20/2017.
 */

public class ReverseAlgorithm<T> extends Algorithms<T> {

    Algorithms makingAlgorithm;

    public ReverseAlgorithm(Algorithms decOrEnc) {
        this.makingAlgorithm = decOrEnc;
    }

    @Override
    public int decryption(int oneByte) {
        return makingAlgorithm.encryption(oneByte);
    }

    @Override
    public int encryption(int oneByte) {
        return makingAlgorithm.decryption(oneByte);
    }
}
