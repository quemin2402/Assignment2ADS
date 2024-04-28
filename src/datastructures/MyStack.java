package datastructures;

import implementations.MyLinkedList;
import java.util.NoSuchElementException;

/**
 * A generic Stack implementation using a LinkedList.
 * The LinkedList is the most suitable as it can add and remove elements
 * at both ends of the list, which corresponds to the push and pop operations of a stack
 * using a LinkedList simplifies the implementation of a stack and provides flexibility
 * in adjusting its size dynamically.
 */
public class MyStack<T> {
    private MyLinkedList<T> list = new MyLinkedList<>();

    /**
     * adds an item to the top of the stack.
     * @param item to be pushed onto the stack.
     */
    public void push(T item) {
        list.addFirst(item);
    }

    /**
     * removes and returns the item at the top of the stack.
     * @return the item at the top of the stack.
     * @throws NoSuchElementException if the stack is empty.
     */
    public T pop() {
        if (list.size() == 0) throw new NoSuchElementException("stack is empty!");
        return list.removeFirst();
    }

    /**
     * returns the item at the top of the stack without removing it.
     * @return the item at the top of the stack.
     * @throws NoSuchElementException if the stack is empty.
     */
    public T peek() {
        if (list.size() == 0) throw new NoSuchElementException("stack is empty!");
        return list.getFirst();
    }

    /**
     * checks if the stack is empty.
     * @return true if the stack is empty, false otherwise.
     */
    public boolean isEmpty() {
        return list.size() == 0;
    }

    /**
     * returns the number of elements in the stack.
     * @return the size of the stack.
     */
    public int size() {
        return list.size();
    }
}
