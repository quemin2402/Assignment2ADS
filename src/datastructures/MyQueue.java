package datastructures;

import implementations.MyLinkedList;
import java.util.NoSuchElementException;

/**
 * MyQueue implements a queue using a LinkedList to efficiently manage elements.
 * The LinkedList is ideal for queues as it allows fast and efficient adding and
 * removing of elements from both ends, ensuring constant time performance for
 * enqueue and dequeue operations.
 */
public class MyQueue<T> {
    private MyLinkedList<T> list = new MyLinkedList<>();

    /**
     * adds an item to the end of the queue.
     * @param item to be added to the queue.
     */
    public void enqueue(T item) {
        // appends the item to the end of the linked list
        list.addLast(item);
    }

    /**
     * removes and returns the item at the front of the queue.
     * @return the item at the front of the queue.
     * @throws NoSuchElementException if the queue is empty.
     */
    public T dequeue() {
        if (list.size() == 0) throw new NoSuchElementException("queue is empty!");
        return list.removeFirst(); // removes the first item of the list
    }

    /**
     * returns the item at the front of the queue without removing it.
     * @return the item at the front of the queue.
     * @throws NoSuchElementException if the queue is empty.
     */
    public T peek() {
        if (list.size() == 0) throw new NoSuchElementException("queue is empty!");
        return list.getFirst(); // retrieves the first item of the list
    }

    /**
     * checks if the queue is empty.
     * @return true - the queue is empty, otherwise - false.
     */
    public boolean isEmpty() {
        return list.size() == 0;
    }

    /**
     * returns the number of items in the queue.
     * @return the size of the queue.
     */
    public int size() {
        return list.size();
    }
}
