package com.company;

import java.io.*;

/**
 * Created by hackeru on 3/6/2017.
 */
public class arrString {
    private char[] chars;
    private int mone;
    public int size;

    public arrString(char[] chars, int mone, int size) {
        this.chars = chars;
        this.mone = mone;
        this.size = size;
    }

    public char[] getChars() {
        return chars;
    }

    public void setChars(char[] chars) {
        this.chars = chars;
    }

    public int getMone() {
        return mone;
    }

    public void setMone(int mone) {
        this.mone = mone;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }



    //תרגיל3
    arrString[] peamim(File file) {
        arrString[] arrStrings = new arrString[50];
        size = 0;
        InputStream inputStream=null;
        try {
            inputStream=new FileInputStream(file);
            char[] ezer = new char[50];
            int wordLength = 0;
            int oneByte;
            while((oneByte = inputStream.read()) != -1) {
                byte b = (byte) oneByte;
                char c = (char) b;
                if (c == ' ') {
                    for (int i = 0; i <=size ; i++) {
                        if(arrStrings[i].chars.equals(ezer)){
                            arrStrings[i].mone++;
                        }
                        else{
                            arrStrings[size].chars=ezer;
                            size++;
                        }
                    }
                }else{
                    ezer[wordLength] = c;
                    wordLength++;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(inputStream!=null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return arrStrings;
    }
}





