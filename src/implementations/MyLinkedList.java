package implementations;

import interfaces.MyList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements MyList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    private class Node<T> {
        T item;
        Node<T> next;

        public Node(T item) {
            this.item = item;
            this.next = null;
        }
    }

    public MyLinkedList() {
        head = null;
        size = 0;
    }

    @Override
    public void add(T item) {
        Node<T> newNode = new Node<T>(item);
        if (head == null)
            head = newNode;
        else {
            Node<T> currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
        size++;
    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            addFirst(item);
            return;
        }
        if (index == size) {
            addLast(item);
            return;
        }
        Node<T> current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        Node<T> newNode = new Node<>(item);
        newNode.next = current.next;
        current.next = newNode;
        size++;
    }


    @Override
    public void set(int index, T item) {
        checkIndex(index);
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.item = item;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
    }


    @Override
    public void addFirst(T item) {
        Node<T> newNode = new Node<>(item);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    @Override
    public void addLast(T item) {
        Node<T> newNode = new Node<>(item);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    @Override
    public T get(int index) {
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.item;
    }

    @Override
    public T getFirst() {
        checkEmpty();
        return head.item;
    }

    @Override
    public T getLast() {
        checkEmpty();
        return tail.item;
    }

    private void checkEmpty() {
        if (size == 0)
            throw new NoSuchElementException("linked list is empty!");
    }

    @Override
    public T remove(int index) {
        checkIndex(index);
        if (index == 0) {
            return removeFirst();
        }
        Node<T> current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        T removedItem = (T) current.next.item;
        if (current.next == tail) {
            tail = current;
        }
        current.next = current.next.next;
        size--;
        return removedItem;
    }

    @Override
    public T removeFirst() {
        if (head == null)
            throw new NoSuchElementException("linked list is empty!");

        T removedElement = head.item;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
        }
        size--;
        return removedElement;
    }

    @Override
    public T removeLast() {
        if (head == null) {
            throw new NoSuchElementException("linked list is empty!");
        }
        if (head == tail) {
            T item = head.item;
            head = tail = null;
            size--;
            return item;
        }
        Node<T> current = head;
        while (current.next != tail) {
            current = current.next;
        }
        T item = tail.item;
        tail = current;
        tail.next = null;
        size--;
        return item;
    }

    @Override
    public void sort() {
        if (size < 2) {
            return;
        }
        boolean wasChanged;

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

        if (object == null) {
            while (current != null) {
                if (current.item == null) {
                    return index;
                }
                current = current.next;
                index++;
            }
        } else {
            while (current != null) {
                if (object.equals(current.item)) {
                    return index;
                }
                current = current.next;
                index++;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        int index = -1;
        int currentIndex = 0;
        Node<T> current = head;

        if (object == null) {
            while (current != null) {
                if (current.item == null) {
                    index = currentIndex;
                }
                current = current.next;
                currentIndex++;
            }
        } else {
            while (current != null) {
                if (object.equals(current.item)) {
                    index = currentIndex;
                }
                current = current.next;
                currentIndex++;
            }
        }
        return index;
    }

    @Override
    public boolean exists(Object object) {
        Node<T> current = head;
        if (object == null) {
            while (current != null) {
                if (current.item == null) {
                    return true;
                }
                current = current.next;
            }
        } else {
            while (current != null) {
                if (object.equals(current.item)) {
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        Node<T> current = head;
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
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T item = current.item;
                current = current.next;
                return item;
            }
        };
    }

    public void printList() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.item + " ");
            current = current.next;
        }
        System.out.println();
    }
}
