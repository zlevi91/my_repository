package com.company;



public class Main {

    public static void main(String[] args) {

        Merge.Node n1= new Merge.Node(2,new Merge.Node(4,new Merge.Node(5,new Merge.Node(7))));
        Merge.Node n2= new Merge.Node(3,new Merge.Node(6,new Merge.Node(8,new Merge.Node(9))));
        Merge.Node n3= new Merge.Node(9,new Merge.Node(11,new Merge.Node(14)));

        Merge.NodeWithHead m1=new Merge.NodeWithHead(n1,new Merge.NodeWithHead(n2,new Merge.NodeWithHead(n3)));
        Merge.Node bdika=Merge.sortKlists1(m1);
        Merge.sortKlists2(m1);

        while (bdika!=null){
            System.out.print(bdika.value+ " ");
            bdika=bdika.next;
        }
        System.out.println();

        Merge.Node n4= new Merge.Node(1,new Merge.Node(3,new Merge.Node(6,new Merge.Node(5))));
        Sorting.bubbleSortLinkedList(n4);
        while (n4!=null){
            System.out.print(n4.value+ " ");
            n4=n4.next;
        }
        
        



    }
}
