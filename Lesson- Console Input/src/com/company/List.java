package com.company;

//יורש מאיטרטור כדי שנוכל לעשות לולאת פוראיץ
//נותן לרשת מ2 אינטרפייסים


import java.util.Iterator;

/**
 * Created by eladlavi on 14/02/2017.
 */

public interface List<T> extends Iterator<T>, Iterable<T> {

    void add(T x);
    void add(T x, int index);
    void remove(int index);
    void set(int index, T x);
    T get(int index);

    /**
     * finds an element in the list
     * @param x the element we're looking
     * @return the first position in the list, zero based. returns -1 if not found.
     */
    int indexOf(T x);
    T[] toArray();

    int size();
}