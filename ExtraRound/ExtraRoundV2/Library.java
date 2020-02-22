import java.util.LinkedList;

public class Library {
    public int id;
    public int singupDays;
    public int booksPerDay;
    public int[] books;
    public LinkedList<Integer> processedBooks;

    public int dayToStartScanning = -1;
    public int nextBookToScan = 0;

    public Library(int id, int numOfBooks, int singupDays, int booksPerDay) {
        this.id = id;
        this.singupDays = singupDays;
        this.booksPerDay = booksPerDay;
        books = new int[numOfBooks];
        processedBooks = new LinkedList<>();
    }
}