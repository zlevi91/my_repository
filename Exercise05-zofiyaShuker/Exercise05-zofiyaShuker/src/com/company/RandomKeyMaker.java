package com.company;

import java.util.Random;

/**
 * Created by Rubin on 19/03/2017.
 */
public class RandomKeyMaker implements KeyMaker<Integer> {
    protected Random random;
    protected Integer key;

    public RandomKeyMaker() {
        this.random =new Random(System.nanoTime());
    }

    @Override
    public Key<Integer> makeKey() {
        return new Key<>(random.nextInt(256));
        //return new Key<>(1);
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }
}
