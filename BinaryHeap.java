package com.company;

import java.util.ArrayList;
import java.util.Comparator;
public class BinaryHeap<K> extends Heap<K> {
    private Comparator<K> comp;
    public BinaryHeap(){
        this(new DefaultComparator<K>());
    }
    public BinaryHeap(Comparator<K> comp){
        array = new ArrayList<>();
        this.comp = comp;
    }
    private void swap(int i, int j){
        K temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }

    /*The stuff that was originally commented out were helper methods I used myself when implementing this.
    I was trying to implement the same thing using both a 0-indexed vs. 1-indexed array, so the root() method just returned 0 and 1, respectively.
    This is important in, e.g., the swim() method, where you don't want to be swimming up past the root.
    Similarly, having something like hasLeft() and hasRight() is for the reverse situation,
    where you don't want the sink() method to go down past any of the actual nodes. */

    //this private root method is technically optional
    private K root() {
        if (array.isEmpty()) return null;
        return array.get(0);
    }

    private int left(int i){
        return i = (2 * i) + 1;
    }
    private int right(int i){
        return i = (2 * i) + 2;
    }

    protected boolean hasLeft(int i) {
        return left(i) < array.size();
    }

    protected boolean hasRight(int i) {
        return right(i) < array.size();
    }

    private int parent(int i){
        return (i - 1) / 2;
    }

    private void sink(int i){
        //downheap
        while(hasLeft(i)){
            int leftIndex = left(i);
            int smallChildIndex = leftIndex;
            if (hasRight(i)) {
                int rightIndex = right(i);
                if (comp.compare(array.get(leftIndex), array.get(rightIndex)) > 0)
                    smallChildIndex = rightIndex;
            }

            if(comp.compare(array.get(smallChildIndex), array.get(i)) >= 0)
                break;
            swap(i, smallChildIndex);
            i = smallChildIndex;
        }
    }
    private void swim(int i){
        //upheap
        while (i > 0) {
            int p = parent(i);
            if (comp.compare(array.get(i), array.get(p)) >= 0) break;
            swap(i, p);
            i = p;
        }
    }

    public void insert(K k){
        array.add(k);
        swim(array.size() - 1);
    }

    public K removeMin(){
        if (array.isEmpty()) return null;
        K answer = root();
        swap(0, array.size()- 1);
        array.remove(array.size() - 1);
        sink(0);
        return answer;
    }

    public K min(){
        if (array.isEmpty()) return null;
        return array.get(0);
    }

}
