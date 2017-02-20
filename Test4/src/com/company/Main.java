package com.company;


public class Main {

    public static void main(String[] args) {
        Node<Integer> n1 = new Node<>(5);
        Node<Integer> n2 = new Node<>(8);
        Node<Integer> n3 = new Node<>(9);
        Node<Integer> n4 = new Node<>(11);
        Node<Integer> n5 = new Node<>(19);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        Node<Node<Integer>> head1 = new Node<>(n1);
        Node<Integer> n6 = new Node<>(2);
        Node<Integer> n7 = new Node<>(7);
        Node<Integer> n8 = new Node<>(28);
        Node<Integer> n9 = new Node<>(39);
        Node<Integer> n10 = new Node<>(42);
        n6.next = n7;
        n7.next = n8;
        n8.next = n9;
        n9.next = n10;
        Node<Node<Integer>> head2 = new Node<>(n6);
        Node<Integer> n11 = new Node<>(14);
        Node<Integer> n12 = new Node<>(18);
        Node<Integer> n13 = new Node<>(22);
        Node<Integer> n14 = new Node<>(91);
        Node<Integer> n15 = new Node<>(105);
        n11.next = n12;
        n12.next = n13;
        n13.next = n14;
        n14.next = n15;
        Node<Node<Integer>> head3 = new Node<>(n11);
        Node<Integer> n16 = new Node<>(2);
        Node<Integer> n17 = new Node<>(15);
        Node<Integer> n18 = new Node<>(17);
        Node<Integer> n19 = new Node<>(29);
        Node<Integer> n20 = new Node<>(39);
        n16.next = n17;
        n17.next = n18;
        n18.next = n19;
        n19.next = n20;
        Node<Node<Integer>> head4 = new Node<>(n16);
        head1.next = head2;
        head2.next = head3;
        //head3.next = head4;


        Node<Integer> merged = mergeLinkedListOfLinkedList2(head1);
        printLinkedList(merged);

    }


    public static Node<Integer> mergeLinkedListOfLinkedList(Node<Node<Integer>> head){
        if(head == null)
            return null;
        while (head.next != null){
            head.value = merge(head.value, head.next.value);
            head.next = head.next.next;
        }
        return head.value;
    }

    public static Node<Integer> mergeLinkedListOfLinkedList2(Node<Node<Integer>> head){
        if(head == null)
            return null;
        if(head.next == null)
            return head.value;

        Node<Node<Integer>> temp = new Node<>(null);
        Node<Node<Integer>> headResult = temp;
        while (head != null && head.next != null){
            temp.next = new Node<>(merge(head.value, head.next.value));
            head = head.next.next;
            temp = temp.next;
        }
        if(head != null){
            temp.next = head;
        }
        return mergeLinkedListOfLinkedList2(headResult.next);
    }




    public static void printLinkedList(Node node){
        while(node != null){
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static <T extends Comparable<T>> Node<T> merge(Node<T> a, Node<T> b){

        Node<T> anchor = new Node<>(null);
        Node<T> tail = anchor;
        while(true){
            if(a == null) {
                //if either list runs out, use the other one.
                tail.next = b;
                break;
            }else if (b == null){
                tail.next = a;
                break;
            }
            if(b.value.compareTo(a.value) >= 0){
                tail.next = a;
                a = a.next;
            }else{
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }
        return anchor.next;
    }

    


}