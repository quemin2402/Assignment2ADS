# Assignment 2 - Algorithms and Data Structures

This project includes custom implementations of fundamental data structures in Java: `MyStack`, `MyQueue`, and `MyMinHeap`. Each class is built using either `MyArrayList` or `MyLinkedList` as the underlying data structure.

## Data Structures Included

### MyStack
- **Description**: Implements a Last In First Out (LIFO) stack using `MyLinkedList`.
- **Methods**:
  - `push(T item)`: Adds an item to the top of the stack.
  - `pop()`: Removes and returns the top item of the stack.
  - `peek()`: Returns the top item without removing it from the stack

### MyQueue
- **Description**: Implements a First In First Out (FIFO) queue using `MyLinkedList`.
- **Methods**:
  - `enqueue(T item)`: Adds an item at the end of the queue.
  - `dequeue()`: Removes and returns the front item of the queue.
  - `peek()`: Retrieves the front item without removing it.

### MyMinHeap
- **Description**: Represents a complete binary tree where each parent node is less than or equal to its children, implemented using `MyArrayList`.
- **Methods**:
  - `insert(T item)`: Adds a new item while maintaining the heap property.
  - `extractMin()`: Removes and returns the smallest element in the heap.
  - `peekMin()`: Returns the smallest item without removing it.
 
### Underlying Structures
- **MyArrayList**: A dynamic array that adjusts its size as elements are added or removed. Implements all methods from the `MyList` interface, ensuring consistent functionality such as add, remove, and access at any position.
- **MyLinkedList**: A doubly linked list allowing element insertion and removal from both ends efficiently. It also fully implements the `MyList` interface, providing methods for efficient manipulation of elements according to list-based operations.

## Running the Project
Follow these steps to see the data structures in action and explore various list operations:
1. Clone the repository to your local machine.
2. Open the project in your preferred Java IDE.
3. Build the project to resolve dependencies.
4. Run the `Main.java` class. This class is designed to not only demonstrate basic operations like pushing, popping, enqueueing, and dequeueing but also various methods from the `MyList` interface. You can test different operations with `MyArrayList` and `MyLinkedList`, such as adding, removing, accessing elements, and sorting the list, to see how these data structures manage elements efficiently.


Чтобы дополнить эту часть README файла, можно добавить более конкретные примеры использования методов MyList на разных структурах данных. Это позволит читателям лучше понять, как они могут использовать предоставленные вами реализации в своих проектах. Вот предложение:

markdown
Copy code
## Usage Examples

The `Main` class includes practical examples for each data structure, demonstrating how to handle common operations and edge cases. Below are detailed examples showcasing the use of various `MyList` methods with `MyArrayList` and `MyLinkedList`:

### Example - Using MyArrayList
```java
MyArrayList<Integer> arrayList = new MyArrayList<>();
arrayList.add(1); // Add element to the list
arrayList.add(2);
arrayList.addFirst(0); // Add element at the start
System.out.println("First element: " + arrayList.getFirst()); // Should display 0
arrayList.remove(1); // Remove element at index 1
System.out.println("After removal: " + arrayList);
```

## Student

Merey Ibraim, SE-2308
