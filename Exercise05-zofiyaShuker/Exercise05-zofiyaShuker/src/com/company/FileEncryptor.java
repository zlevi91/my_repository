package com.company;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Rubin on 26/03/2017.
 */
public class FileEncryptor {

    public void encryptFile(File sourceFile, Algorithms cipher){
        decryptEncryptFile(sourceFile, cipher, true);
    }

    public void decryptFile(File sourceFile, Algorithms cipher){
        decryptEncryptFile(sourceFile, cipher, false);
    }


    public void decryptEncryptFile(File sourceFile, Algorithms cipher, boolean isEncrypt){
        File destFile= FileOperations.createFile(sourceFile,isEncrypt);
        byte[] fileDataEncryptor;
        try {
            byte[] fileData = Files.readAllBytes(Paths.get(sourceFile.getPath()));
            fileDataEncryptor=cipher.crypt(fileData,isEncrypt);
            Files.write(Paths.get(destFile.getPath()), fileDataEncryptor);
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }

}
