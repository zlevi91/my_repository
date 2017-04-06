package com.company;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

/**
 * Created by hackeru on 3/27/2017.
 */
public class MakerKeysFile {

    public DoubleKey<Key<Integer>, DoubleKey<Key<Integer>, Key<Integer>>> createKey() {
        KeyMaker<Integer> randomKeyMaker =new RandomKeyMaker();
        KeyMaker<Integer> oddRandomKeyMaker =new OddRandomKeyMaker();
        Key<Integer> key1=  randomKeyMaker.makeKey();
        Key<Integer> key2=  randomKeyMaker.makeKey();
        Key<Integer> key3=  oddRandomKeyMaker.makeKey();
        DoubleKey<Key<Integer>, DoubleKey<Key<Integer>, Key<Integer>>> key = new DoubleKey<>(key1, new DoubleKey<>(key2, key3));
        return key;
    }

    public <T extends Serializable> void writeKey(T key, File keysFile){
        FileOperations.writeObjectToFile(keysFile, key);
    }

    public <T extends  Serializable> T getKey(File keysFile) throws IOException, ClassNotFoundException {
        return FileOperations.readObjectFromFile(keysFile);
    }

}
