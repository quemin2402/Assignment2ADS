import implementations.MyArrayList;
import implementations.MyLinkedList;

public class Main {
    public static void main(String[] args) {
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
    }
}
