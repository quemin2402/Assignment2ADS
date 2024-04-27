package datastructures;

import implementations.MyLinkedList;

import java.util.NoSuchElementException;

public class MyQueue<T> {
    private MyLinkedList<T> list = new MyLinkedList<>();

    public void enqueue(T item) {
        list.addLast(item);
    }

    public T dequeue() {
        if (list.size() == 0) throw new NoSuchElementException("queue is empty!");
        return list.removeFirst();
    }

    public T peek() {
        if (list.size() == 0) throw new NoSuchElementException("queue is empty!");
        return list.getFirst();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public int size() {
        return list.size();
    }
}
