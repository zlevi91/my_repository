package com.company;

import java.io.File;
import java.io.IOException;


/**
 * Created by Rubin on 25/03/2017.
 */
public class Menu {

    public static final int ENCRYPTION = 1;
    public static final int DECRYPTION = 2;
    private Input input;
    private Output output;
    private RandomKeyMaker randomKey;
    private ListenerRealization encryptionListener ;

    public Menu(Input input, Output output) {
        this.input = input;
        this.output = output;
        this.encryptionListener = new ListenerRealization(output);
        this.randomKey=new RandomKeyMaker();
    }


    public String printMenu(){
        return "please choose:\n 1 for encryption \n 2 for  decryption \n 0 for Exit";
    }

    public void start(){
        String userInput=null;
        if(input != null && output !=null){
            output.getOutput(printMenu());
            while (!((userInput=input.getInput()).equals("0"))){
                myChoice(userInput);
            }
        }
    }

    public void myChoice(String inputFromUser){

        int choose = Integer.valueOf(inputFromUser);
        Algorithms doubleAlgorithm=null;
        Algorithms reverseAlgorithm=null;
        FileEncryptor encryptor = new FileEncryptor();

        MakerKeysFile makerKeysFile =new MakerKeysFile();
        try{
            if(choose ==ENCRYPTION){
                encryptionListener.StartDetect();
                File keysFile = getPathFromUser(true);
                DoubleKey<Key<Integer>, DoubleKey<Key<Integer>, Key<Integer>>> keys = makerKeysFile.createKey();
                makerKeysFile.writeKey(keys, keysFile);

                Key<Integer> key1 = keys.getKey1();
                Key<Integer> key2 = keys.getKey2().getKey1();
                Key<Integer> key3 = keys.getKey2().getKey2();

                printKeys(key1,key2,key3);

                reverseAlgorithm=new ReverseAlgorithm(new DoubleAlgorithm( new CaesarAlgorithm( key1),  new MultiplicationAlgorithm( key3 )));
                doubleAlgorithm=new DoubleAlgorithm(new XORAlgorithm(key2),  reverseAlgorithm);
                File fileFromUser= getPathFromUser(false);
                encryptor.encryptFile(fileFromUser, doubleAlgorithm);
                encryptionListener.EndDetect();

            }else if(choose==DECRYPTION){

                encryptionListener.StartDetect();
                File keysFile = getPathFromUser(true);
                DoubleKey<Key<Integer>, DoubleKey<Key<Integer>, Key<Integer>>> keys = makerKeysFile.getKey(keysFile);
                Key<Integer> key1 = keys.getKey1();
                Key<Integer> key2 = keys.getKey2().getKey1();
                Key<Integer> key3 = keys.getKey2().getKey2();

                printKeys(key1,key2,key3);

                reverseAlgorithm=new ReverseAlgorithm(new DoubleAlgorithm( new CaesarAlgorithm(key1 ), new MultiplicationAlgorithm( key3  )));
                doubleAlgorithm = new DoubleAlgorithm( new XORAlgorithm(key2  ), reverseAlgorithm);
                File fileFromUser= getPathFromUser(false);
                encryptor.decryptFile(fileFromUser, doubleAlgorithm);
                encryptionListener.EndDetect();
            }

            start();
        } catch (InvalidKeyException e){
            output.getOutput(e.getMessage());
        }catch (IOException e){
            output.getOutput(e.getMessage());
        }
        catch (ClassNotFoundException e){
            output.getOutput(e.getMessage());
        }
        catch (Exception e){
            output.getOutput("error!");
        }
    }

    public File getPathFromUser(boolean isKeyFile){
        if (isKeyFile)
            output.getOutput("enter path of Key File");
        else
            output.getOutput("enter path of encrypt \\ decrypt File");
        String path=input.getInput();
        FileOperations file = new FileOperations(path);
        boolean isValidPath = file.checkpath();
        if (!isValidPath) {
            output.getOutput("is not file or file not exists. please enter path again.");
            getPathFromUser(isKeyFile);
        }
        return file;
    }

    public void printKeys(Key<Integer> key1,Key<Integer> key2,Key<Integer> key3){
        output.getOutput("key1: "+ key1.getKeyValue());
        output.getOutput("key2: "+ key2.getKeyValue());
        output.getOutput("key3: "+ key3.getKeyValue());
    }

}
