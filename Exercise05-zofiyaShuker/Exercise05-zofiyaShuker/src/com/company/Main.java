package com.company;

public class Main {

    public static void main(String[] args) {
        Menu menu=new Menu(new ScreenInput(), new ScreenOutput());
        menu.start();
    }
}
