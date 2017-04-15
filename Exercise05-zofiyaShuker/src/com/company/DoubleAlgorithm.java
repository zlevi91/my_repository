package com.company;

/**
 * Created by hackeru on 3/22/2017.
 */
public class DoubleAlgorithm<T,S> extends Algorithms<DoubleKey<T,S>> {

    Algorithms algorithm1;
    Algorithms algorithm2;

    public DoubleAlgorithm(Algorithms a1, Algorithms a2) {
        algorithm1=a1;
        algorithm2=a2;
    }

    @Override
    int encryption(int oneByte) {
        return algorithm2.encryption(algorithm1.encryption(oneByte));
    }
    @Override
    int decryption(int oneByte) {
        return algorithm1.decryption(algorithm2.decryption(oneByte));
    }
}


