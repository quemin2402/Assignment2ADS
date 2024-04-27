package datastructures;

import implementations.MyArrayList;

import java.util.NoSuchElementException;

public class MyMinHeap<T extends Comparable<T>> {
    private MyArrayList<T> list = new MyArrayList<>();

    public void insert(T item) {
        list.add(item);
        siftUp();
    }

    private void siftUp() {
        int index = list.size() - 1;
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            T child = list.get(index);
            T parent = list.get(parentIndex);
            if (child.compareTo(parent) >= 0) {
                break;
            }
            list.set(index, parent);
            list.set(parentIndex, child);
            index = parentIndex;
        }
    }

    public T extractMin() {
        if (list.size() == 0) throw new NoSuchElementException("heap is empty!");
        T min = list.get(0);
        T last = list.get(list.size() - 1);
        list.set(0, last);
        list.remove(list.size() - 1);
        siftDown();
        return min;
    }

    private void siftDown() {
        int index = 0;
        int size = list.size();
        int leftChildIdx;
        while ((leftChildIdx = 2 * index + 1) < size) {
            int rightChildIdx = leftChildIdx + 1;
            int smallestChildIdx = leftChildIdx;
            if (rightChildIdx < size && list.get(rightChildIdx).compareTo(list.get(leftChildIdx)) < 0) {
                smallestChildIdx = rightChildIdx;
            }
            if (list.get(smallestChildIdx).compareTo(list.get(index)) >= 0) {
                break;
            }
            T temp = list.get(index);
            list.set(index, list.get(smallestChildIdx));
            list.set(smallestChildIdx, temp);
            index = smallestChildIdx;
        }
    }

    public T peekMin() {
        if (list.size() == 0) throw new NoSuchElementException("Heap is empty");
        return list.get(0);
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public int size() {
        return list.size();
    }
}
