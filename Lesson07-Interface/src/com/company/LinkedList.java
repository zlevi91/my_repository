package com.company;

/**
 * Created by hackeru on 2/14/2017.
 */
public class LinkedList implements List {
    private Node anchor;//עוגן
    private int size;

    public LinkedList(){
        anchor=new Node(0);// אנקו הוא נאד פקטיבי, לא מחזירים בשום שלב את הערך הזה עושים את זה כדי שזה יפשט את הקוד שבהמשך
        size=0;
    }

    @Override
    public void add(int x) {
        Node i ;
        for ( i = anchor; i.next!=null; i=i.next);
        i.next=new Node(x);
        size++;
    }

    @Override
    public void add(int x, int index) {
        if(index>size)
            throw new IndexOutOfBoundsException("");
        Node i;
        int j=0;
        for(i=anchor;j<index ;j++, i=i.next );
        Node ezer=i.next;
        i.next=new Node(x);
        i.next.next=ezer;
        size++;
    }

    @Override
    public void remove(int index) {
        if(index>size)
            throw new IndexOutOfBoundsException("");
        Node i=anchor;
        int j=0;
        while (j<index) {
            i = i.next;
            j++;
        }
        i.next=i.next.next;
        size--;
    }

    @Override
    public void set(int index, int x) {
        if(index>size)
            throw new IndexOutOfBoundsException("");
        Node i=anchor;
        int j=0;
        while (j<=index){
            i=i.next;
            j++;
        }
        i.value=x;

    }

    @Override
    public int get(int index) {
        if(index>size)
            throw new IndexOutOfBoundsException("");
        Node i=anchor;
        int j=0;
        while (j<=index){
            i=i.next;
            j++;
        }
        return i.value;

    }

    @Override
    public int indexOf(int x) {
        int j=0;
        for(Node i=anchor;i.next!=null;i=i.next,j++){
            if(i.value==x)
                return j;
        }
      return -1;
    }

    @Override
    public int[] toArray() {
        int[] arrList=new int[size];
        Node node=anchor;
        for (int i = 0; i <size ; i++, node=node.next) {
            arrList[i]=node.value;
        }
        return arrList;
    }

    private static class Node{
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            next=null;
        }
    }
}
