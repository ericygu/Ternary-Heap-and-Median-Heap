package com.company;

public class MedianHeap<K extends Comparable>{
    BinaryHeap<K> minHeap = new BinaryHeap<K>();
    BinaryHeap<K> maxHeap = new BinaryHeap<K>(new MaxComparator<K>());

    public boolean isEmpty(){
        return (maxHeap.size() == 0 && minHeap.size() == 0);
    }

    public int size(){
        return minHeap.size() + maxHeap.size();
    }

    private void rebalance(){
        while (minHeap.size() + 1 < maxHeap.size()) {
            minHeap.insert(maxHeap.removeMin());
        }

        if (minHeap.size() == 0) return;

        if (minHeap.size() > maxHeap.size()) {
            maxHeap.insert(minHeap.removeMin());
        }

        if (maxHeap.size() == 0) return;

        if (minHeap.min().compareTo(maxHeap.min()) < 0) {
            maxHeap.insert(minHeap.removeMin());
            minHeap.insert(maxHeap.removeMin());
        }

        if (maxHeap.size() == 0) return;

        /*if (minHeap.size() > maxHeap.size()) {
            maxHeap.insert(minHeap.removeMin());
        }*/

    }

    public void insert(K k){
        maxHeap.insert(k);
        rebalance();
    }

    /*public K removeSmallMedian() {
        rebalance();

        K median = maxHeap.removeMin();

        rebalance();

        return median;
    }*/

    public K removeMedian(){
        K median = maxHeap.removeMin();
        while (maxHeap.size() < minHeap.size()) {
            maxHeap.insert(minHeap.removeMin());
        }
        return median;

    }

    public K median(){
        if (isEmpty()) return null;
        return maxHeap.min();
    }

    public static void main(String []args) {
        MedianHeap<Integer> a = new MedianHeap<Integer>();

        a.insert(1);
        a.insert(2);
        System.out.println(a.median());

        System.out.println(a.removeMedian());
        System.out.println(a.removeMedian());


        a.insert(4);
        System.out.print("MEDIAN: ");
        System.out.println(a.median());

        a.insert(-1);
        System.out.print("MEDIAN: ");
        System.out.println(a.median());

        a.insert(-2);
        System.out.print("MEDIAN: ");
        System.out.println(a.median());

        a.insert(3);
        a.insert(30);
        System.out.print("MEDIAN: ");
        System.out.println(a.median());

        a.insert(22);
        System.out.print("MEDIAN: ");
        System.out.println(a.median());

        a.insert(25);
        a.insert(33);
        a.insert(10);
        System.out.print("MEDIAN: ");
        System.out.println(a.median());


        a.removeMedian();
        System.out.println("Test 0:");
        System.out.println("minHeap size:");
        System.out.println(a.minHeap.size());
        System.out.println("maxHeap size:");
        System.out.println(a.maxHeap.size());

        System.out.print("MEDIAN: ");
        System.out.println(a.median());

        a.removeMedian();
        System.out.println("Test 1: ");
        System.out.println("minHeap size:");
        System.out.println(a.minHeap.size());
        System.out.println("maxHeap size:");
        System.out.println(a.maxHeap.size());

        System.out.print("MEDIAN: ");
        System.out.println(a.median());

        a.removeMedian();
        System.out.println("Test 2: ");
        System.out.println("minHeap size:");
        System.out.println(a.minHeap.size());
        System.out.println("maxHeap size:");
        System.out.println(a.maxHeap.size());

        System.out.print("MEDIAN: ");
        System.out.println(a.median());

        a.removeMedian();
        System.out.println("Test 3: ");
        System.out.println("minHeap size:");
        System.out.println(a.minHeap.size());
        System.out.println("maxHeap size:");
        System.out.println(a.maxHeap.size());

        System.out.print("MEDIAN: ");
        System.out.println(a.median());

        a.removeMedian();
        System.out.println("Test 4: ");
        System.out.println("minHeap size:");
        System.out.println(a.minHeap.size());
        System.out.println("maxHeap size:");
        System.out.println(a.maxHeap.size());

        System.out.print("MEDIAN: ");
        System.out.println(a.median());

        a.removeMedian();
        System.out.println("Test 5: ");
        System.out.println("minHeap size:");
        System.out.println(a.minHeap.size());
        System.out.println("maxHeap size:");
        System.out.println(a.maxHeap.size());

        System.out.print("MEDIAN: ");
        System.out.println(a.median());

        a.removeMedian();
        System.out.println("Test 6: ");
        System.out.println("minHeap size:");
        System.out.println(a.minHeap.size());
        System.out.println("maxHeap size:");
        System.out.println(a.maxHeap.size());

        System.out.print("MEDIAN: ");
        System.out.println(a.median());

        a.removeMedian();

        System.out.println("Test 7: ");
        System.out.println("minHeap size:");
        System.out.println(a.minHeap.size());
        System.out.println("maxHeap size:");
        System.out.println(a.maxHeap.size());

        System.out.print("MEDIAN: ");
        System.out.println(a.median());

        a.removeMedian();
        System.out.println("Test 8: ");
        System.out.println("minHeap size:");
        System.out.println(a.minHeap.size());
        System.out.println("maxHeap size:");
        System.out.println(a.maxHeap.size());
        System.out.print("MEDIAN: ");
        System.out.println(a.median());



    }

}
