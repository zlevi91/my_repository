package com.company;


import java.nio.ByteBuffer;

public class Main {

    public static void main(String[] args) {

        /*int x = 123456;
        byte[] bytes = new byte[4];
        *//*bytes[3] = (byte)x;
        bytes[2] = (byte)(x>>8);
        bytes[1] = (byte)(x>>16);
        bytes[0] = (byte)(x>>24);*//*
        for (int i = 0; i < 4; i++) {
            bytes[4-i-1] = (byte)(x>>(8*i));
        }
        int y = 0;
        for (int i = 0; i < 4; i++) {
            y = y << 8;
            y |= y  (bytes[i] & 255);
        }
        System.out.println(y);
        int a = 56789;
        byte[] aBytes = new byte[4];
        ByteBuffer.wrap(aBytes).putInt(a);
        int b = ByteBuffer.wrap(aBytes).getInt();
        System.out.println(b);*/

        String s = "hello";
        s.hashCode();

        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("hello");
        stringBuilder.append(" world");
        stringBuilder.append(", how are ");
        stringBuilder.append("you today?");

        //מחלקה של טרד שנקראת סטרינגבאפר זה התגוננות הזו על טרדסייפ כדי שהאותיות לא יעלו אחת על השניה
        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append("hello");

        String s1="hello";
        s1+=" word";//לא שיננו את האובייקט אלא יצרנו אובייקט חדש והשרשור שלהם זה עוד אובייקט
        System.out.println(stringBuilder.toString());

    }
}
