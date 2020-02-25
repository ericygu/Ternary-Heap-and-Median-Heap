package com.company;

public class MedianHeap<K extends Comparable>{
    BinaryHeap<K> minHeap = new BinaryHeap<K>();
    BinaryHeap<K> maxHeap = new BinaryHeap<K>(new MaxComparator<K>());

    public boolean isEmpty(){
        return (maxHeap.size() == 0);
    }

    public int size(){
        return minHeap.size() + maxHeap.size();
    }

    private void rebalance(){
        while (minHeap.size() + 1 < maxHeap.size()) {
            minHeap.insert(maxHeap.removeMin());
        }

        if (minHeap.size() == 0) return;

        if (minHeap.min().compareTo(maxHeap.min()) < 0) {
            maxHeap.insert(minHeap.removeMin());
            minHeap.insert(maxHeap.removeMin());
        }
    }

    public void insert(K k){
        maxHeap.insert(k);
        rebalance();
    }

    public K removeMedian(){
        if (isEmpty()) return null;
        K median = maxHeap.removeMin();
        rebalance();
        return median;
    }

    public K median(){
        if (isEmpty()) return null;
        return maxHeap.min();
    }

}
