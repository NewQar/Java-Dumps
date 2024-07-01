import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private int year;
    private double price;

    public Book(String title, String author, int year, double price) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.price = price;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public int getYear() {
        return year;
    }
    public double getPrice() {
        return price;
    }
}

public class AppQueueBook {
    public static void main(String[] args) {
        MyQueue<Book> BookQ = new MyQueue<>();

        Scanner scanner = new Scanner(System.in);
        // ask user to enter 10 Book objects into queue BookQ
        System.out.println("Enter 10 Book objects into the queue:");
        for (int i = 0; i < 10; i++) {
            System.out.println("Book #" + (i + 1));
            System.out.print("Title: ");
            String title = scanner.nextLine();
            System.out.print("Author: ");
            String author = scanner.nextLine();
            System.out.print("Publication Year: ");
            int year = scanner.nextInt();
            System.out.print("Price: ");
            double price = scanner.nextDouble();
            scanner.nextLine(); // consume the newline character

            Book book = new Book(title, author, year, price);
            BookQ.enqueue(book);
        }
        // Display all books details in BookQ
        System.out.println("All books in the queue:");
        BookQ.display();

        // Display all books which were published before the year 2020.
        System.out.println("All books published before the year 2020:");
        MyQueue<Book> BookOld = new MyQueue<>();
        while (!BookQ.isEmpty()) {
            Book book = BookQ.dequeue();
            if (book.getYear() < 2020) {
                BookOld.enqueue(book);
                System.out.println(book.getTitle());
            }
        }

        // Search and display the books with the highest and lowest prices.
        String highestPriceBook = null;
        String lowestPriceBook = null;
        double highestPrice = Double.MIN_VALUE;
        double lowestPrice = Double.MAX_VALUE;
        
        MyQueue<Book> BookOld1 = new MyQueue<>();
        while (!BookOld.isEmpty()) {
            Book book = BookOld.dequeue();
            if (book.getPrice() > highestPrice) {
                highestPriceBook = book.getTitle();
                highestPrice = book.getPrice();
            }
            if (book.getPrice() < lowestPrice) {
                lowestPriceBook = book.getTitle();
                lowestPrice = book.getPrice();
            }
            BookOld1.enqueue(book);
        }

        System.out.println("Book with the highest price: " + highestPriceBook);
        System.out.println("Book with the lowest price: " + lowestPriceBook);

        // Declare another queue of book objects named BookQOld, all books published before year 1990 should be copied into this queue.
        MyQueue<Book> BookQOld = new MyQueue<>();
        while (!BookOld1.isEmpty()) {
            Book book = BookOld1.dequeue();
            if (book.getYear() < 1990) {
                BookQOld.enqueue(book);
            }
        }
        // Display all books in BookQOld
        System.out.println("All books in Bookold:");
        BookQOld.display();
    }
}
