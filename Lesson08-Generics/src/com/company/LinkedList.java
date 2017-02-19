package com.company;

import java.util.Iterator;

/**
 * Created by hackeru on 2/14/2017.
 */
public class LinkedList<T> implements List<T> {

    private Node<T> anchor;
    private Node<T> last;
    private int size;


    public LinkedList() {
        anchor = new Node<T>(null);
        size = 0;
        last = anchor;
    }

    @Override
    public void add(T x) {
        /*Node last = anchor;
        while (last.next != null)
            last = last.next;*/
        last.next = new Node(x);
        last = last.next;
        size++;

    }

    @Override
    public void add(T x, int index) {
        if(index < 0 || index > size)
            throw new IndexOutOfBoundsException();
        if(index == size){
            add(x);
            return;
        }
        Node theOneBefore = anchor;
        for (int i = 0; i < index; i++)
            theOneBefore = theOneBefore.next;
        //כל פעם שיש ניו נאד צריך לכתוב איזה טיפוס זה,
        // אם לא מספקים טיפוס זה לא עושה שגיאת קומפילציה
        Node added = new Node<T>(x);
        added.next = theOneBefore.next;
        theOneBefore.next = added;
        size++;
    }

    @Override
    public void remove(int index) {
        if(index < 0 || index > size)
            throw new IndexOutOfBoundsException();

        Node theOneBefore = anchor;
        for (int i = 0; i < index; i++)
            theOneBefore = theOneBefore.next;
        if(index == size){
            last = theOneBefore;
        }
        theOneBefore.next = theOneBefore.next.next;
        size--;
    }

    @Override
    public void set(int index, T x) {
        if(index < 0 || index > size)
            throw new IndexOutOfBoundsException();
        Node<T> node = anchor;//פה לא היה חייב לשים את הטי
        for (int i = 0; i <= index; i++) {
            node = node.next;
        }
        node.value = x;

    }

    @Override
    public T get(int index) {
        if(index < 0 || index > size)
            throw new IndexOutOfBoundsException();
        Node<T> node = anchor;
        for (int i = 0; i <= index; i++) {
            node = node.next;
        }
        return node.value;
    }

    @Override
    public int indexOf(T x) {
        Node<T> node = anchor.next;//גם פה לא חובה לשים טי
        for (int i = 0; i < size; i++, node = node.next) {
            if(node.value == x)
                return i;
        }
        return -1;
    }

    @Override
    public T[] toArray() {
        T[] temp =(T[])new Object[size];//אסור אף פעם לעשות ניו טי אלא נעשה קאסטינג לטי
        Node<T> node = anchor.next;
        for (int i = 0; i < size; i++, node = node.next) {
            temp[i] = node.value;
        }
        return temp;
    }

    @Override
    public String toString() {
        if(size == 0)
            return "{}";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        Node node = anchor.next;
        for (int i = 0; i < size - 1; i++, node = node.next) {
            stringBuilder.append(node.value + ",");
        }
        stringBuilder.append(node.value);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }


    private static class Node<T>{//הטי הזה זה לא הטי שלמעלה.
        T value;
        Node<T> next;//פויינטר לנאד רק של טיאים

        public Node(T value) {
            this.value = value;
            next = null;

        }

    }

    @Override
    public int size() {
        return size;
    }




}
