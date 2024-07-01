import java.util.Scanner;

class Node<T> {
    private T data;
    private Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
    public T getData() {
        return data;
    }
    public void setNext(Node<T> next) {
        this.next = next;
    }
    public Node<T> getNext() {
        return next;
    }
        public Book getBook() {
        return (Book) data;
    }
}

public class MyQueue<T> {
    private Node<T> front;
    private Node<T> rear;
    public MyQueue() {
        this.front = null;
        this.rear = null;
    }
    public boolean isEmpty() {
        return front == null;
    }
    public void enqueue(T data) {
        Node<T> newNode = new Node<T>(data);
        if (isEmpty()) {
            front = rear = newNode;
            return;
        }
        rear.setNext(newNode);
        rear = newNode;
    }
    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        T data = front.getData();
        front = front.getNext();
        if (front == null) {
            rear = null;
        }
        return data;
    }
    public void display() {
        Node current = front;
        while (current != null) {
            System.out.println(current.getBook().getTitle());
            current = current.getNext();
        }
    }
    public MyQueue<Book> copyOldBooks() {
        MyQueue<Book> oldBooks = new MyQueue<>();
        Node<T> current = front;
        while (current != null) {
            Book oldBook = current.getBook();
            if (oldBook != null && oldBook.getYear() < 1990) {
                // Create a new book object with the same values as the old book
                Book newBook = new Book(oldBook.getTitle(), oldBook.getAuthor(), oldBook.getYear(), oldBook.getPrice());
                oldBooks.enqueue(newBook);
            }
            current = current.getNext();
        }
        return oldBooks;
    }
 
    public Book findHighestPrice() {
        if (isEmpty()) {
            return null;
        }
        Node current = front;
        Book highestPriceBook = current.getBook();
        while (current != null) {
            if (current.getBook().getPrice() > highestPriceBook.getPrice()) {
                highestPriceBook = current.getBook();
            }
            current = current.getNext();
        }
        return highestPriceBook;
    }
    public Book findLowestPrice() {
        if (isEmpty()) {
            return null;
        }
        Node current = front;
        Book lowestPriceBook = current.getBook();
        while (current != null) {
            if (current.getBook().getPrice() < lowestPriceBook.getPrice()) {
                lowestPriceBook = current.getBook();
            }
            current = current.getNext();
        }
        return lowestPriceBook;
    }
}
