import java.util.LinkedList;
import java.util.Random;

public class Library {
    public int id;
    public int singupDays;
    public int booksPerDay;
    public int[] books;

    public int dayToStartScanning = -1;
    public int nextBookToScan = 0;

    public Library(int id, int numOfBooks, int singupDays, int booksPerDay) {
        this.id = id;
        this.singupDays = singupDays;
        this.booksPerDay = booksPerDay;
        books = new int[numOfBooks];
    }

    public void shuffleArray() {
        Random rnd = new Random();
        for (int i = books.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            int a = books[index];
            books[index] = books[i];
            books[i] = a;
        }
    }
}