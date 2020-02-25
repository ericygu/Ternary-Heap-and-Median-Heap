package com.company;

import com.company.DefaultComparator;

//logn time in each of the operations
import java.util.ArrayList;
import java.util.Comparator;
public class TernaryHeap<K> extends Heap<K> {
    private Comparator<K> comp;
    public TernaryHeap(){
        this(new DefaultComparator<K>());
    }
    public TernaryHeap(Comparator<K> comp){
        array = new ArrayList<>();
        this.comp = comp;
    }

    private void swap(int i, int j){
        K temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }

    private K root(){
        if (array.isEmpty()) return null;
        else return array.get(0);
    }

    public K min() {
        if (array.isEmpty()) return null;
        else return array.get(0);
    }

    private int left(int i){
        return i = (3 * i) + 1;
    }
    private int middle(int i){
        return i = (3 * i) + 2;
    }
    private int right(int i){
        return i = (3 * i) + 3;
    }

    private int parent(int i){
        return (i - 1) / 3;
    }

    protected boolean hasLeft(int i) {
        return left(i) < array.size();
    }

    protected boolean hasMiddle(int i) {
        return middle(i) < array.size();
    }

    protected boolean hasRight(int i) {
        return right(i) < array.size();
    }

    private void sink(int i){
        while(hasLeft(i)){
            int leftIndex = left(i);
            int smallChildIndex = leftIndex;
            if(hasMiddle(i)) {
                int middleIndex = middle(i);
                if (comp.compare(array.get(leftIndex), array.get(middleIndex)) >= 0)
                    smallChildIndex = middleIndex;
            }
            if (hasRight(i)) {
                int rightIndex = right(i);
                if (comp.compare(array.get(smallChildIndex), array.get(rightIndex)) >= 0)
                    smallChildIndex = rightIndex;
            }

            if(comp.compare(array.get(smallChildIndex), array.get(i)) >= 0)
                break;
            swap(i, smallChildIndex);
            i = smallChildIndex;
        }
    }

    private void swim(int i) {
        //fix
        while (i > 0) {
            int p = parent(i);
            if (comp.compare(array.get(i), array.get(p)) >= 0) break;
            swap(i, p);
            i = p;
        }
    }

    public void insert(K k) {
        array.add(k);
        swim(array.size() - 1);
    }

    public K removeMin() {
        if (array.isEmpty()) {
            return null;
        }

        K answer = root();
        swap(0, array.size() - 1);
        array.remove(array.size() - 1);
        sink(0);

        return answer;
    }
}


