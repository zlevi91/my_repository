package com.company;

/**
 * Created by hackeru on 3/21/2017.
 */

public abstract class Algorithms<T> {

    Key<T> key;

    public void setKey(Key<T> key) {
        this.key = key;
    }

    public T getKey() {
        return key.getKeyValue();
    }

    abstract int encryption(int oneByte);
    abstract int decryption(int oneByte);

    public byte[] crypt(byte[] fileData , boolean choiceEncrypt){
        int i=0;
        byte[] bytes=new byte[fileData.length];
            while (i < fileData.length){
                if(choiceEncrypt)
                    bytes[i]= (byte)encryption(fileData[i]);
                else
                    bytes[i]= (byte)decryption(fileData[i]);
                i++;
            }
        return bytes;
    }

}






