package com.company;

/**
 * Created by hackeru on 2/22/2017.
 */
public class Queue {
    int[] arr;
    int front, rear, size;

    public Queue() {
        arr = new int[10];//תור מוגבל בקיבולת אנחנו לא רוצים שיהיה יותר מ10 איברים בתור
        front = 0;
        rear = arr.length-1;// המקום האחרון במערך
        size =0;
    }
    public  int size(){
      if (rear>front)
          return rear - front + 1;
      else
          return  arr.length - front + rear + 1;
    }

    public boolean isEmpty() {return size == 0;}


    public  boolean isFull(){
        return  size == arr.length;// front == rear
    }

    public void insert(int x) {
        if (isFull())
            throw new IndexOutOfBoundsException();
        rear = (rear + 1)% arr.length;
        arr[rear] = x;
        size++;
    }

    public int pop() {
        if (isEmpty())
            throw new IndexOutOfBoundsException();
        int x = arr[front];
        front = (front+1)%arr.length;//  פרונט יותא מספר בין אפס ללנגס
        size--;
        return x;
    }

    public  int front(){
        if(isEmpty())
            throw new IndexOutOfBoundsException();
        return  arr[front];
    }

    public  int rear(){
        if(isEmpty())
            throw new IndexOutOfBoundsException();
        return  arr[rear];
    }



}
