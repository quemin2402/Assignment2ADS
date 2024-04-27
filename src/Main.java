import datastructures.MyMinHeap;
import datastructures.MyQueue;
import datastructures.MyStack;
import implementations.MyArrayList;
import implementations.MyLinkedList;

public class Main {
    public static void main(String[] args) {
        // array examples
        MyArrayList<Integer> myList = new MyArrayList<>();
        myList.add(43);
        myList.add(23);
        myList.add(17);
        myList.add(53);
        myList.add(2, 25);

        System.out.println("removed item: " + myList.remove(1));
        System.out.println("first item: " + myList.getFirst());
        System.out.println("last item: " + myList.getLast());

        for (Integer item : myList) {
            System.out.println(item);
        }

        System.out.println("does list contain '30'? " + myList.exists(30));

        System.out.println("array before sorting:");
        myList.printArr();
        myList.sort();
        System.out.println("array after sorting:");
        myList.printArr();

        myList.clear();
        System.out.println("size after clear: " + myList.size());

        System.out.println();
        // linked list examples

        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        System.out.println("initial list:");
        list.printList();
        list.addFirst(5);
        list.addLast(35);
        System.out.println("list after adding first (5) and last (35):");
        list.printList();
        list.removeFirst();
        list.removeLast();
        System.out.println("list after removing first and last:");
        list.printList();
        list.removeLast();
        list.removeLast();
        list.removeLast();
        System.out.println("list after removing all elements:");
        list.printList();
        list.addFirst(15);
        list.addLast(25);
        System.out.println("list after adding elements to empty list:");
        list.printList();


        System.out.println();
        // stack examples

        MyStack<Integer> stack = new MyStack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("stack top after pushes: " + stack.peek());
        System.out.println("stack pop: " + stack.pop());
        System.out.println("stack top after pop: " + stack.peek());

        // queue examples
        MyQueue<Integer> queue = new MyQueue<>();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println("queue front after enqueues: " + queue.peek());
        System.out.println("queue dequeue: " + queue.dequeue());
        System.out.println("queue front after dequeue: " + queue.peek());

        // minheap examples
        MyMinHeap<Integer> minHeap = new MyMinHeap<>();
        minHeap.insert(20);
        minHeap.insert(10);
        minHeap.insert(15);
        System.out.println("min heap top after inserts: " + minHeap.peekMin());
        System.out.println("min heap extract min: " + minHeap.extractMin());
        System.out.println("min heap top after extract: " + minHeap.peekMin());

    }
}
