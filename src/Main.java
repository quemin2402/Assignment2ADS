import datastructures.MyMinHeap;
import datastructures.MyQueue;
import datastructures.MyStack;
import implementations.MyArrayList;
import implementations.MyLinkedList;

/**
 * This main class is designed to demonstrate the usage of various custom data structures
 * including MyArrayList, MyLinkedList, MyStack, MyQueue, and MyMinHeap.
 * Each section of the class tests different operations like adding, removing, and accessing elements
 * in these data structures to showcase their functionality and behavior.
 */
public class Main {
    public static void main(String[] args) {
        // creating and populating a myArrayList with integers
        MyArrayList<Integer> myList = new MyArrayList<>();
        myList.add(43);
        myList.add(23);
        myList.add(17);
        myList.add(53);
        myList.add(2, 25);  // inserting 25 at index 2

        // demonstrating removal and accessing first and last elements
        System.out.println("removed item: " + myList.remove(1));  // removing item at index 1, expected 23
        System.out.println("first item: " + myList.getFirst());  // accessing the first item, expected 43
        System.out.println("last item: " + myList.getLast());  // accessing the last item, expected 53

        // iterating over myArrayList to display current elements
        for (Integer item : myList) {
            System.out.println(item);
        }

        // checking existence of an item in the list
        System.out.println("does list contain '30'? " + myList.exists(30));  // checking for non-existing item

        // displaying array elements before and after sorting
        System.out.println("array before sorting:");
        myList.printArr();
        myList.sort();
        System.out.println("array after sorting:");
        myList.printArr();

        // clearing the list and checking its size
        myList.clear();
        System.out.println("size after clear: " + myList.size());

        System.out.println();
        // creating and manipulating a myLinkedList

        MyLinkedList<Integer> list = new MyLinkedList<>();

        // adding elements to the linked list
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        System.out.println("initial list:");
        list.printList();

        // adding elements to the beginning and end of the list
        list.addFirst(5);
        list.addLast(35);
        System.out.println("list after adding first '5' and last '35':");
        list.printList();

        // removing elements from the beginning and end of the list
        list.removeFirst();
        list.removeLast();
        System.out.println("list after removing first and last:");
        list.printList();

        // clearing the list completely
        list.removeLast();
        list.removeLast();
        list.removeLast();
        System.out.println("list after removing all elements:");
        list.printList();

        // adding elements to an empty list to verify functionality
        list.addFirst(15);
        list.addLast(25);
        System.out.println("list after adding elements to empty list:");
        list.printList();

        System.out.println();
        // demonstrating stack operations

        MyStack<Integer> stack = new MyStack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("stack top after pushes: " + stack.peek());
        System.out.println("stack pop: " + stack.pop());
        System.out.println("stack top after pop: " + stack.peek());

        // demonstrating queue operations
        MyQueue<Integer> queue = new MyQueue<>();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println("queue front after enqueues: " + queue.peek());
        System.out.println("queue dequeue: " + queue.dequeue());
        System.out.println("queue front after dequeue: " + queue.peek());

        // demonstrating min heap operations
        MyMinHeap<Integer> minHeap = new MyMinHeap<>();
        minHeap.insert(20);
        minHeap.insert(10);
        minHeap.insert(15);
        System.out.println("min heap top after inserts: " + minHeap.peekMin());
        System.out.println("min heap extract min: " + minHeap.extractMin());
        System.out.println("min heap top after extract: " + minHeap.peekMin());

    }
}
