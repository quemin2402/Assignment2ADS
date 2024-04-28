package implementations;

import interfaces.MyList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class (MyArrayList) provides a custom implementation of an array list without using Java's built-in collections' framework.
 * It supports dynamic resizing and allows for adding, removing, and accessing elements at any position efficiently.
 */
public class MyArrayList<T> implements MyList<T> {
    private Object[] arr;
    private int size;

    public MyArrayList() {
        arr = new Object[10]; // initial capacity of the array is set to 10
        size = 0; // array is empty
    }

    @Override
    public void add(T item) {
        if (size >= arr.length)
            increasedBuffer(); // increase the array size if it is full
        arr[size++] = item; // add item at the end and increment size
    }

    @Override
    public void add(int index, T item) {
        if (size >= arr.length)
            increasedBuffer();
        checkIndex(index);
        System.arraycopy(arr, index, arr, index + 1, size - index); // move existing elements one position to the right to open space for the new element
        arr[index] = item;
        size++;
    }

    private void increasedBuffer() {
        Object[] newArr = new Object[arr.length * 2]; // double the size of the array
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    @Override
    public void set(int index, T item) {
        checkIndex(index);
        arr[index] = item; // set the item at the specified index
    }

    @Override
    public void addFirst(T item) {
        add(0, item); // add item at the start of the array
    }

    @Override
    public void addLast(T item) {
        add(item); // add item at the end of the array
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return (T) arr[index]; // return the item at the specified index
    }

    @Override
    public T getFirst() {
        return get(0); // return the first item in the array
    }

    @Override
    public T getLast() {
        return get(size - 1); // return the last item in the array
    }

    @Override
    public T remove(int index) {
        checkIndex(index);
        T removedItem = (T) arr[index]; // store the item to be removed
        for (int i = index + 1; i < size; i++) { // shift elements to remove the gap
            arr[i - 1] = arr[i];
        }
        arr[size - 1] = null; // decrement size and null out the last element
        size--;
        return removedItem;
    }

    @Override
    public T removeFirst() {
        return remove(0); // remove the first item
    }

    @Override
    public T removeLast() {
        return remove(size - 1); // remove the last item
    }

    @Override
    public void sort() { // sort the array without using java's utility method (bubble sorting)
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (((Comparable<T>) arr[j]).compareTo((T) arr[j + 1]) > 0) {
                    T temp = (T) arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    @Override
    public int indexOf(Object object) {
        if (object == null) {
            for (int i = 0; i < size; i++)
                if (arr[i] == null)
                    return i;
        } else {
            for (int i = 0; i < size; i++)
                if (object.equals(arr[i]))
                    return i; // return the index of the object if found
        }
        return -1; // return -1 if the object is not found
    }

    @Override
    public int lastIndexOf(Object object) {
        if (object == null) {
            for (int i = size - 1; i >= 0; i--)
                if (arr[i] == null)
                    return i;
        } else {
            for (int i = size - 1; i >= 0; i--)
                if (object.equals(arr[i]))
                    return i; // return the last index of the object if found
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) >= 0; // check if the object exists in the array
    }

    @Override
    public Object[] toArray() {
        // create a new array that contains all elements in the array list up to the current size
        return java.util.Arrays.copyOf(arr, size);
    }

    @Override
    public void clear() {
        // reset the array to an initial capacity of 10 and set the size to 0
        Object[] arr = new Object[10];
        size = 0;
    }

    @Override
    public int size() {
        // return the number of elements currently held in the array list
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        // return an instance of the myIterator class which allows for iterating over the arraylist
        return new MyIterator();
    }
    private class MyIterator implements Iterator<T> {
        private int cursor = 0;  // cursor for iteration over the array

        @Override
        public boolean hasNext() {
            // check if there is another element beyond the current cursor position
            return cursor < size; // return true if there is another element
        }

        @Override
        public T next() {
            // check if the cursor is beyond the last element, throw exception if no more elements are available
            if (cursor >= size) {
                throw new NoSuchElementException();
            }
            return get(cursor++); // return the next element and increment the cursor
        }
    };

    private void checkIndex(int index) {
        // check if the index is within the valid range of 0 to size-1;
        // if not, throw an index out of bounds exception
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("index is not correct: " + index +
                    ", allowed range: 0 to " + (size - 1));
    }

    public void printArr() {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(); // print all elements in the array
    }
}
