package com.company;

/**
 * Created by hackeru on 2/27/2017.
 */
public class MyString implements Comparable {

    final private char[] value;

    public MyString(char[] value) {
        this.value = value;
    }

    public char[] getValue() {
        return value;
    }

    public int indexOf(MyString myString) {
        boolean b = false;
        int a = 0;
        for (int i = 0; i < value.length; i++) {
            if (value[i] == myString.value[0]) {
                b = true;
                a = i;
                for (int j = 1; j < myString.value.length - value.length && b == true; j++) {
                    if (value[i + j] != myString.value[j]) {
                        b = false;
                        a = -1;

                    }
                }
            }
        }
        return a;
    }

    public int indexOf1(MyString myString) {
        int a = 0;
        int j = 0;
        for (int i = 0; i < value.length; i++) {
            a = i;
            for (j = 0; j < myString.value.length && i + j < value.length; j++) {

                if (value[i + j] != myString.value[j]) {
                    break;
                }

            }
            if (j == myString.value.length)
                return a;
        }
        return -1;

    }

    /*public MyString[] split(char c) {
        int count = 0;
        int k=0;
        int index=0;
        int[] arr= new int[value.length];
        for (int i = 0; i < value.length ; i++) {
            k++;
            if (value[i] == c){
                count++;
                arr[index++]=k;

            }

        }
        count++;

    }*/

    public MyString toUpper(){
        MyString myString=new MyString(value);
        char[] chars=new char[value.length];
        for (int i = 0; i <value.length ; i++) {
            chars[i]=value[i];
            if(value[i]>=97&&value[i]<123){
               chars[i]-=32;
            }
        }
        MyString m=new MyString(chars);
        return m;
    }


    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj instanceof MyString) {
            MyString other = (MyString) obj;
            if(value.length!= other.value.length){
                return false;
            }
            for (int i = 0; i <value.length ; i++) {
                if(value[i]!=other.value[i])
                    return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}







