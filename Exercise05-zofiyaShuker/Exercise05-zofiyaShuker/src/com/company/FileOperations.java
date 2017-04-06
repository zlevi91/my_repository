package com.company;


/**
 * Created by hackeru on 2/28/2017.
 */
import java.io.*;

public class FileOperations extends File {

    private boolean isValid=true;

    public FileOperations(String path) {
        super(path);
    }

    public boolean checkpath(){
        if(!isFile())
            isValid=false;
        if(!exists())
            isValid=false;
        return isValid;
    }

    public static void writeObjectToFile (File file, Serializable toWrite){
        ObjectOutputStream objectOutputStream = null;
        OutputStream outputStream = null;
        try{
            outputStream = new FileOutputStream(file);
            objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(toWrite);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(objectOutputStream != null)
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if(outputStream != null)
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    static <T> T readObjectFromFile (File file) throws IOException, ClassNotFoundException {
        T toRead = null;
        try(InputStream inputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {
            toRead = (T) objectInputStream.readObject();
        }
        return toRead;
    }


    public static File createFile(File fileFromUser, boolean choiceEncrypt){
        String path = fileFromUser.getAbsolutePath();
        int pos=path.indexOf('.');
        if (pos > 0)
            path = path.substring(0, pos);
        if(choiceEncrypt)
            return new File(path + "_en.txt");
        return new File(path + "_de.txt");
    }

}
