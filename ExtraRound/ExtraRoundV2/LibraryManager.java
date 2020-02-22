import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Arrays;

public class LibraryManager {
    private final String path;

    private int numOfBooks;
    private int numOfLibraries;
    private int numOfDays;

    private HashMap<Integer, Integer> booksScore;
    private Library[] libraries;

    private boolean[] booksProcessed;

    public LibraryManager(final String path) {
        this.path = path;
    }

    public static void main(final String[] args) throws FileNotFoundException {
        final LibraryManager libMangA = new LibraryManager("inputA.in");
        final LibraryManager libMangB = new LibraryManager("inputB.in");
        final LibraryManager libMangC = new LibraryManager("inputC.in");
        final LibraryManager libMangD = new LibraryManager("inputD.in");
        final LibraryManager libMangE = new LibraryManager("inputE.in");
        final LibraryManager libMangF = new LibraryManager("inputF.in");
        libMangA.startDeliveringSystem();
        libMangB.startDeliveringSystem();
        libMangC.startDeliveringSystem();
        libMangD.startDeliveringSystem();
        libMangE.startDeliveringSystem();
        libMangF.startDeliveringSystem();
    }

    public void startDeliveringSystem() throws FileNotFoundException {
        // Obtener Input - Inicio
        final Scanner sc = new Scanner(new File(path));
        String[] auxScoreBooks = sc.nextLine().split(" ");
        numOfBooks = Integer.parseInt(auxScoreBooks[0]);
        numOfLibraries = Integer.parseInt(auxScoreBooks[1]);
        numOfDays = Integer.parseInt(auxScoreBooks[2]);

        booksProcessed = new boolean[numOfBooks];
        booksScore = new HashMap<>();
        auxScoreBooks = sc.nextLine().split(" ");
        for (int i = 0; i < auxScoreBooks.length; i++) {
            booksScore.put(i, Integer.parseInt(auxScoreBooks[i]));
        }

        libraries = new Library[numOfLibraries];

        String auxLineOne;
        String auxLineTwo;
        String[] auxSplit;
        int contOfLibraries = 0;
        while (sc.hasNextLine()) {
            auxLineOne = sc.nextLine().trim();
            auxLineTwo = sc.nextLine().trim();
            if (!auxLineOne.equals("") && !auxLineTwo.equals("")) {
                auxSplit = auxLineOne.split(" ");
                final Library library = new Library(contOfLibraries, Integer.parseInt(auxSplit[0]),
                        Integer.parseInt(auxSplit[1]), Integer.parseInt(auxSplit[2]));
                auxSplit = auxLineTwo.split(" ");
                for (int i = 0; i < library.books.length; i++) {
                    library.books[i] = Integer.parseInt(auxSplit[i]);
                }
                Arrays.sort(library.books);
                libraries[contOfLibraries] = library;
            }
            contOfLibraries++;
        }
        sc.close();
        // Obtener Input - Fin
        // Algoritmo - Inicio
        int nextDayToSingup = -1;
        int nextLibraryToSingUp = 0;
        for (int day = 0; day < numOfDays; day++) {
            // No hay ninguna libreria haciendo singup
            if (day > nextDayToSingup) {
                libraries[nextLibraryToSingUp].dayToStartScanning = libraries[nextLibraryToSingUp].singupDays + day + 1;
                nextDayToSingup = libraries[nextLibraryToSingUp].dayToStartScanning;
                nextLibraryToSingUp++;
            }
            // Recorremos las librerias que han hecho singup y su dia de escaner ya es
            // posible
            for (int numLibrarie = 0; numLibrarie < nextLibraryToSingUp; numLibrarie++) {
                final Library lib = libraries[numLibrarie];
                if (lib.nextBookToScan < lib.books.length && day >= lib.dayToStartScanning) {
                    int auxCont = 0;
                    while (auxCont < lib.booksPerDay && lib.nextBookToScan < lib.books.length) {
                        if (!booksProcessed[lib.books[lib.nextBookToScan]]) {
                            booksProcessed[lib.books[lib.nextBookToScan]] = true;
                            lib.processedBooks.add(lib.books[lib.nextBookToScan]);
                            auxCont++;
                        }
                        lib.nextBookToScan++;
                    }
                    if (lib.nextBookToScan > lib.books.length - 1) {
                        lib.nextBookToScan = lib.books.length - 1;
                    }
                    // lib.nextBookToScan += lib.booksPerDay;
                    // if (lib.nextBookToScan > lib.books.length - 1) {
                    // lib.nextBookToScan = lib.books.length - 1;
                    // }
                }
            }
        }
        // Algoritmo - Fin
        // Output - Inicio
        final PrintWriter pw = new PrintWriter(new File("O" + path));
        String res = "";
        int cont = 0;
        for (final Library library : libraries) {
            if (library.dayToStartScanning != -1) {
                cont++;
                res += library.id + " " + (library.nextBookToScan + 1) + "\n";
                for (Integer inte : library.processedBooks) {
                    res += inte + " ";
                }
                res += "\n";
            }
        }
        res = cont + "\n" + res;
        pw.print(res);
        pw.close();
        // Output - Fin
    }
}