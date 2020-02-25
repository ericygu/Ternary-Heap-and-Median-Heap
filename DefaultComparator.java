package com.company;

/*The way that compareTo() works is kind of strange at first glance. Ideally you'd just like to isolate three possibilies:
    a < b, a == b, a > b. A clever way that people were able to do this without coming up with a new datatype (a "triple boolean"?),
    was to encode this using an int. In particular, when comparing Integers a and b, the compareTo method just returns the int (a-b).
    Now there are three scenarios:
(a-b) < 0, which is equivalent to a < b.
(a-b) == 0, which is equivalent to a == b.
(a-b) > 0, which is equivalent to a > b.

If you need to compare two elements a and b of a class that implements Comparable, you can try putting into one of the forms above.*/

import java.util.Comparator;
public class DefaultComparator<K> implements Comparator<K> {
    public int compare(K a, K b) throws ClassCastException {
        return ((Comparable<K>)a).compareTo(b);
    }
}
