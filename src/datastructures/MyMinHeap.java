package datastructures;

import implementations.MyArrayList;
import java.util.NoSuchElementException;

/**
 * A generic MinHeap implementation using an ArrayList.
 * The ArrayList is chosen for its ability to dynamically resize and provide efficient access to
 * any element by index. These features are essential for effective heap operations, such as adjusting
 * elements during sift-up and sift-down processes.
 * Using an ArrayList also simplifies the management of the heap's structure.
 */

public class MyMinHeap<T extends Comparable<T>> {
    private MyArrayList<T> list = new MyArrayList<>();

    /**
     * inserts a new item into the heap.
     * @param item to be inserted.
     */
    public void insert(T item) {
        list.add(item); // add new item to the end of the list
        siftUp(); // maintain heap property by moving the new item up
    }

    // repositions a newly added element to maintain the min-heap property
    private void siftUp() {
        int index = list.size() - 1;
        while (index > 0) {
            int parentIndex = (index - 1) / 2; // calculate parent index
            T child = list.get(index);
            T parent = list.get(parentIndex);
            if (child.compareTo(parent) >= 0) {  // if child is greater or equal
                break;
            }
            list.set(index, parent);  // swap child and parent
            list.set(parentIndex, child);
            index = parentIndex; // move up to the parent index
        }
    }

    /**
     * extracts the minimum element from the heap.
     * @return the minimum element.
     */
    public T extractMin() {
        if (list.size() == 0) throw new NoSuchElementException("heap is empty!");
        T min = list.get(0);
        T last = list.get(list.size() - 1);
        list.set(0, last);
        list.remove(list.size() - 1);
        siftDown();
        return min; // return the minimum element
    }

    // repositions the new root to maintain the min-heap property
    private void siftDown() {
        int index = 0;
        int size = list.size();
        int leftChildIdx;
        while ((leftChildIdx = 2 * index + 1) < size) {
            int rightChildIdx = leftChildIdx + 1;
            int smallestChildIdx = leftChildIdx; // assume left child is the smallest
            if (rightChildIdx < size && list.get(rightChildIdx).compareTo(list.get(leftChildIdx)) < 0) {
                smallestChildIdx = rightChildIdx; // right child is smaller than left child
            }
            if (list.get(smallestChildIdx).compareTo(list.get(index)) >= 0) {
                break; // proper position found; stop sifting down
            }
            T temp = list.get(index);
            list.set(index, list.get(smallestChildIdx)); // swap positions
            list.set(smallestChildIdx, temp);
            index = smallestChildIdx; // move down to the smallest child index
        }
    }

    /**
     * retrieves the minimum element from the heap without removing it.
     * @return the minimum element.
     * @throws NoSuchElementException if the heap is empty.
     */
    public T peekMin() {
        if (list.size() == 0) throw new NoSuchElementException("heap is empty!");
        return list.get(0);
    }

    /**
     * checks if the heap is empty.
     * @return true - the heap is empty, false - otherwise.
     */
    public boolean isEmpty() {
        return list.size() == 0;
    }

    /**
     * returns the number of elements in the heap.
     * @return the size of the heap.
     */
    public int size() {
        return list.size();
    }
}
