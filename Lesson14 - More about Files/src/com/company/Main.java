package com.company;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        File file = new File("/Users/eladlavi/");
        System.out.println(file.exists());
        System.out.println(file.isDirectory());
        File[] files = file.listFiles();
        for(File f : files){
            System.out.println(f.getAbsolutePath());
        }

    }
}