package implementations;

import interfaces.MyList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class (MyLinkedList) provides a custom implementation of a doubly linked list that supports generic data types.
 * It includes functionalities such as adding, removing, and accessing elements both at specific positions and globally (first/last).
 */
public class MyLinkedList<T> implements MyList<T> {
    private Node<T> head; // start of the linked list
    private Node<T> tail;  // end of the linked list
    private int size; // number of elements

    private class Node<T> {
        T item; // the element stored in this node
        Node<T> next; // reference to the next node in the list

        public Node(T item) {
            this.item = item;
            this.next = null;
        }
    }

    public MyLinkedList() {
        head = null; // initially, head is null because the list is empty
        size = 0; // size is 0
    }

    @Override
    public void add(T item) {
        Node<T> newNode = new Node<T>(item); // create a new node with the item
        if (head == null)
            head = tail = newNode; // new node is now both head and tail if list is empty
        else {
            Node<T> currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
        size++; // increase the size of the list
    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(); // check for valid index
        }
        if (index == 0) {
            addFirst(item); // add at the beginning
            return;
        }
        if (index == size) {
            addLast(item); // add at the end
            return;
        }
        Node<T> current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next; // navigate to the position before insertion
        }
        Node<T> newNode = new Node<>(item); // create a new node
        newNode.next = current.next; // link new node with the next node
        current.next = newNode;  // link current node to new node
        size++;
    }


    @Override
    public void set(int index, T item) {
        checkIndex(index); // ensure the index is within bounds
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.item = item; // set new item at the index
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException(); // throw if index is out of bounds
    }


    @Override
    public void addFirst(T item) { // create new node
        Node<T> newNode = new Node<>(item);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head; // new node points to the current head
            head = newNode; // new node becomes the head
        }
        size++;
    }

    @Override
    public void addLast(T item) {
        Node<T> newNode = new Node<>(item);
        if (head == null) {
            head = tail = newNode; // if list is empty, new node is both head and tail
        } else {
            tail.next = newNode; // current tail points to new node
            tail = newNode; // new node becomes the tail
        }
        size++;
    }

    @Override
    public T get(int index) {
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next; // navigate to the specified index
        }
        return current.item; // return the item at the index
    }

    @Override
    public T getFirst() {
        checkEmpty(); // check if the list is empty
        return head.item; // return the item in the head
    }

    @Override
    public T getLast() {
        checkEmpty(); // check if the list is empty
        return tail.item; // return the item in the tail
    }

    private void checkEmpty() {
        if (size == 0) // throw if the list is empty
            throw new NoSuchElementException("linked list is empty!");
    }

    @Override
    public T remove(int index) {
        checkIndex(index); // ensure the index is within bounds
        if (index == 0) {
            return removeFirst(); // remove the first item if index is 0
        }
        Node<T> current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next; // navigate to the node before the one to be removed
        }
        T removedItem = (T) current.next.item; // store the item to be removed
        if (current.next == tail) {
            tail = current; // if removing the last element, update tail
        }
        current.next = current.next.next; // unlink the node to be removed
        size--;
        return removedItem;
    }

    @Override
    public T removeFirst() {
        if (head == null)
            throw new NoSuchElementException("linked list is empty!");

        T removedElement = head.item;
        if (head == tail) {
            head = tail = null; // if only one element, reset both head and tail
        } else {
            head = head.next; // move head to the next element
        }
        size--; // decrease size
        return removedElement; // return the removed item
    }

    @Override
    public T removeLast() {
        if (head == null) {
            throw new NoSuchElementException("linked list is empty!");
        }
        if (head == tail) {
            T item = head.item; // store the item from the head (only element)
            head = tail = null; // reset both head and tail
            size--; // decrease size
            return item;
        }
        Node<T> current = head;
        while (current.next != tail) {
            current = current.next; // navigate to the node before the tail
        }
        T item = tail.item; // store the item from the tail
        tail = current; // update tail to the current node
        tail.next = null; // remove the old tail
        size--; // decrease size
        return item; // return the removed item
    }

    @Override
    public void sort() {
        if (size < 2) { // if size is less than 2, no need to sort
            return;
        }
        boolean wasChanged;
        // some bubble sorting mechanism :/
        do {
            Node<T> current = head;
            Node<T> prev = null;
            Node<T> next = head.next;
            wasChanged = false;

            while (next != null) {
                if (((Comparable<T>) current.item).compareTo(next.item) > 0) {
                    wasChanged = true;

                    if (prev != null) {
                        Node<T> tmp = next.next;
                        prev.next = next;
                        next.next = current;
                        current.next = tmp;
                    } else {
                        Node<T> tmp = next.next;
                        head = next;
                        next.next = current;
                        current.next = tmp;
                    }

                    prev = next;
                    next = current.next;
                } else {
                    prev = current;
                    current = next;
                    next = next.next;
                }
            }
            if (wasChanged) {
                tail = current;
            }
        } while (wasChanged);
    }

    @Override
    public int indexOf(Object object) {
        int index = 0;
        Node<T> current = head;
        // iterate through the list to find the index of the first occurrence of the object
        if (object == null) {
            while (current != null) {
                if (current.item == null) {
                    return index; // found a null item that matches the searched null object
                }
                current = current.next;
                index++;
            }
        } else {
            while (current != null) {
                if (object.equals(current.item)) {
                    return index; // found the object, return its value
                }
                current = current.next;
                index++;
            }
        }
        return -1; // if not found, -1
    }

    @Override
    public int lastIndexOf(Object object) {
        int index = -1;
        int currentIndex = 0;
        Node<T> current = head;
        // iterate from the start to find the last occurrence of the object
        if (object == null) {
            while (current != null) {
                if (current.item == null) {
                    index = currentIndex; // update index if current item is null, matching the searched object
                }
                current = current.next;
                currentIndex++;
            }
        } else {
            while (current != null) {
                if (object.equals(current.item)) {
                    index = currentIndex; // update index if current item matches the object
                }
                current = current.next;
                currentIndex++;
            }
        }
        return index; // return the last index found or -1 if not found
    }

    @Override
    public boolean exists(Object object) {
        Node<T> current = head;
        // check each node to see if it contains the object
        if (object == null) {
            while (current != null) {
                if (current.item == null) {
                    return true; // return true if a null item is found
                }
                current = current.next;
            }
        } else {
            while (current != null) {
                if (object.equals(current.item)) {
                    return true; // return true if the current item matches the object
                }
                current = current.next;
            }
        }
        return false;  // return false if the object is not found in the list
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        Node<T> current = head;
        // populate an array with the elements from the linked list
        for (int i = 0; i < size; i++) {
            array[i] = current.item;
            current = current.next;
        }
        return array;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0; // clear the list by setting head, tail to null and size to zero
    }

    @Override
    public int size() {
        return size; // return the number of elements in the list
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = head;

            @Override
            // return true if there are more elements to iterate over
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    // throw an exception if there is no element to return
                    throw new NoSuchElementException();
                }
                T item = current.item; // store the current item
                current = current.next; // move to the next node
                return item; // return the current item
            }
        };
    }

    public void printList() {
        Node<T> current = head;
        // print all elements in the linked list
        while (current != null) {
            System.out.print(current.item + " ");
            current = current.next;
        }
        System.out.println();  // new line after printing all elements
    }
}
