package com.company;

import java.io.*;
import java.nio.ByteBuffer;
import java.security.InvalidParameterException;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        File file1= new File("C:\\New folder\\file1.txt");
        File file2= new File("C:\\New folder\\file2.txt");
        File filemerge= new File("C:\\New folder\\ filemerge.txt");

        mergeFile(file1,file2,filemerge);

        File file3= new File("C:\\New folder\\MyFile1.txt");
        File file4= new File("C:\\New folder\\file4.txt");

        OutputStream outputStream= null;
        byte[] buffer= new byte[4];
        try {
            outputStream = new FileOutputStream(file4);
            Random random = new Random(System.currentTimeMillis());
            for (int i = 0; i < 30; i++) {
                int rnd = random.nextInt(50);
                System.out.print(rnd+ ",");
                ByteBuffer.wrap(buffer).putInt(rnd);
                outputStream.write(buffer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(outputStream!=null)
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        System.out.println();

        int[] arr= minK(file4,5);

        for (int i = 0; i <arr.length ; i++) {
            System.out.print(arr[i] + ",");
        }


    }



    //תרגיל1
    public static File mergeFile(File file1, File file2, File filemerge) {
        byte[] buffer1 = new byte[4];
        byte[] buffer2 = new byte[4];
        int actuallyRead1;
        int actuallyRead2;
        int b1 = 0, b2 = 0;
        byte[] aBytes = new byte[4];
        InputStream inputStream1 = null;
        InputStream inputStream2 = null;
        OutputStream outputStream = null;

        try {
            inputStream1 = new FileInputStream(file1);
            inputStream2 = new FileInputStream(file2);
            outputStream = new FileOutputStream(filemerge);
            actuallyRead1 = inputStream1.read(buffer1);
            actuallyRead2 = inputStream2.read(buffer2);
            while (actuallyRead1 != -1 && actuallyRead2 != -1) {
                if (actuallyRead1 != 4 || actuallyRead2 != 4)
                    throw new InvalidParameterException("is not numbers");
                b1 = ByteBuffer.wrap(buffer1).getInt();
                b2 = ByteBuffer.wrap(buffer2).getInt();
                if (b1 < b2) {
                    ByteBuffer.wrap(aBytes).putInt(b1);
                    for (int j = 0; j < 4; j++) {
                        outputStream.write(aBytes[j]);
                    }
                    actuallyRead1 = inputStream1.read(buffer1);
                } else {
                    ByteBuffer.wrap(aBytes).putInt(b2);
                    for (int j = 0; j < 4; j++) {
                        outputStream.write(aBytes[j]);
                    }
                    actuallyRead2 = inputStream2.read(buffer2);
                }
            }
            while (actuallyRead1!=-1){
                b1 = ByteBuffer.wrap(buffer1).getInt();
                ByteBuffer.wrap(aBytes).putInt(b1);
                for (int j = 0; j < 4; j++) {
                    outputStream.write(aBytes[j]);
                }
                actuallyRead1 = inputStream1.read(buffer1);
            }

            while (actuallyRead2!=-1){
                b2 = ByteBuffer.wrap(buffer2).getInt();
                ByteBuffer.wrap(aBytes).putInt(b2);
                for (int j = 0; j < 4; j++) {
                    outputStream.write(aBytes[j]);
                }
                actuallyRead2 = inputStream2.read(buffer2);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(inputStream1!=null)
                try {
                    inputStream1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if(inputStream2!=null)
                try {
                    inputStream2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if(outputStream!=null)
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        return filemerge;
    }



    //תרגיל2
    static int[] minK(File file, int k){
        byte[] buffer= new byte[4];
        int actuallyRead;
        InputStream inputStream = null;
        int[] arr= new int[k];
        int b=0;

        for (int i = 0; i <k ; arr[i++]= Integer.MAX_VALUE);
        try {
            inputStream = new FileInputStream(file);
            while ((actuallyRead = inputStream.read(buffer)) != -1) {
                if (actuallyRead != 4)
                    throw new InvalidParameterException("is not numbers");
                b= ByteBuffer.wrap(buffer).getInt();
                int pos = 0;
                int max=Integer.MIN_VALUE;
                for (int i = 0; i < k; i++) {
                    if(arr[i]>max){
                        max = arr[i];
                        pos = i;
                    }
                }
                if(max > b){
                    arr[pos] = b;
                }
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(inputStream!=null)
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        return arr;
    }

}