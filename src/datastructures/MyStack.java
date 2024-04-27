package datastructures;

import implementations.MyLinkedList;

import java.util.NoSuchElementException;

public class MyStack<T> {
    private MyLinkedList<T> list = new MyLinkedList<>();

    public void push(T item) {
        list.addFirst(item);
    }

    public T pop() {
        if (list.size() == 0) throw new NoSuchElementException("stack is empty!");
        return list.removeFirst();
    }

    public T peek() {
        if (list.size() == 0) throw new NoSuchElementException("stack is empty!");
        return list.getFirst();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public int size() {
        return list.size();
    }
}
