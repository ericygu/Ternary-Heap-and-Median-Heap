package com.company;

public class Main {

    public static void main(String[] args) {
        //Am confused w/ Binary Heap

        /*for (int i = 0; i <= 7; i++){
            BinaryHeap.insert(i);
            System.out.println(i);
        }
        BinaryHeap.insert(2.5);
        System.out.print("Inserted");

        for (int i = 0; i < array.size(); i++) {
            System.out.println(array[i]);
        }*/

/*
        BinaryHeap<String> a = new BinaryHeap<String>();
        for (String cur : args) {
            a.insert(cur);
        }
        System.out.println(a.toString());

        int size = a.size();
        for (int i = 0; i < size; i++) {
            System.out.println(a.removeMin());
        }
  */


/*
        int size = a.size();
        for (int i = 0; i < size; i++) {
            System.out.println(a.removeMin());
        }
*/

        TernaryHeap<Integer> a = new TernaryHeap<Integer>();
        a.insert(777);
        a.insert(666);
        a.insert(555);
        a.insert(444);
        a.insert(333);
        a.insert(222);
        a.insert(111);
        a.insert(112);
        a.insert(110);

        System.out.println(a.toString());

        //Test Remove Min
        /*
        int newSize = a.newSize();
        for (int i = 0; i < size; i++) {
            System.out.println(a.removeMin());
        }
        System.out.println(a.toString());
        */

    }
}
