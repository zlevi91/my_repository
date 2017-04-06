package com.company;

/**
 * Created by hackeru on 3/20/2017.
 */
public class MultiplicationAlgorithm extends Algorithms<Integer> {

    private int decryptionKey;
    public MultiplicationAlgorithm(Key<Integer> key)  throws InvalidKeyException {
        this.key=key;
        checkKey();
        decryptionKey=0;
    }

    @Override
    public int decryption(int oneByte) {
        if(decryptionKey == 0)
            createDecryptionKey((int)key.getKeyValue());
        return decryptionKey * oneByte;
    }

    @Override
    public int encryption(int oneByte) {
        return  ((int)key.getKeyValue() * oneByte) & 0x000000FF;
    }

    public void createDecryptionKey(int key){
        for (int i = 0; i < 256 ; i++) {
            if(((i*key) & 0x000000FF) ==1){
                decryptionKey=i;
                break;
            }
        }
        this.decryptionKey=decryptionKey;
    }

    public void checkKey() throws InvalidKeyException {
        if(key.getKeyValue()%2==0)
            throw new InvalidKeyException("even key");
    }


}

