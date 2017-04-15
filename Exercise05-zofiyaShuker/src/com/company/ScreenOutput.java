package com.company;

/**
 * Created by hackeru on 3/15/2017.
 */
public class ScreenOutput implements Output {
    @Override
    public void getOutput(String s) {
        System.out.println(s);
    }
}
