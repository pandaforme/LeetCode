package _284;

import java.util.Arrays;
import java.util.Iterator;

// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> iterator;
    private Integer peekElement = null;
    private Boolean peekHasNext = null;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (peekElement == null) {
            if (iterator.hasNext()) {
                peekElement = iterator.next();
                peekHasNext = true;
            } else {
                peekHasNext = false;
            }
        }

        return peekElement;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        int result;

        if (peekElement == null) {
            result = iterator.next();
        } else {
            result = peekElement;
            peekElement = null;
            peekHasNext = null;
        }

        return result;
    }

    @Override
    public boolean hasNext() {
        if (peekHasNext == null) {
            return iterator.hasNext();
        } else {
            return peekHasNext;
        }
    }

    public static void main(String[] args) {
        PeekingIterator peekingIterator = new PeekingIterator(Arrays.asList(708, 217, 30, 44).iterator());
        System.out.println(peekingIterator.peek());
        System.out.println(peekingIterator.peek());
        System.out.println(peekingIterator.hasNext());
    }
}
