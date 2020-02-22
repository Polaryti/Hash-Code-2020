import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;

public class LibraryManager {
    private final String path;

    private int numOfBooks;
    private int numOfLibraries;
    private int numOfDays;

    private HashMap<Integer, Integer> booksScore;
    private ArrayList<Library> libraries;

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
        //libMangB.startDeliveringSystem();
        //libMangC.startDeliveringSystem();
        //libMangD.startDeliveringSystem();
        //libMangE.startDeliveringSystem();
        libMangF.startDeliveringSystem();
    }

    public void startDeliveringSystem() throws FileNotFoundException {
        // Obtener Input - Inicio
        final Scanner sc = new Scanner(new File(path));
        String[] auxScoreBooks = sc.nextLine().split(" ");
        numOfBooks = Integer.parseInt(auxScoreBooks[0]);
        numOfLibraries = Integer.parseInt(auxScoreBooks[1]);
        numOfDays = Integer.parseInt(auxScoreBooks[2]);

        booksScore = new HashMap<>();
        auxScoreBooks = sc.nextLine().split(" ");
        for (int i = 0; i < auxScoreBooks.length; i++) {
            booksScore.put(i, Integer.parseInt(auxScoreBooks[i]));
        }

        libraries = new ArrayList<>(numOfLibraries);

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
                library.shuffleArray();
                libraries.add(library);
            }
            contOfLibraries++;
        }
        sc.close();
        // Obtener Input - Fin
        // Algoritmo - Inicio
        int maxPoints = 0;
        while (true) {
            Collections.shuffle(libraries);
            int nextDayToSingup = -1;
            int nextLibraryToSingUp = 0;
            for (int day = 0; day < numOfDays; day++) {
                // No hay ninguna libreria haciendo singup
                if (day > nextDayToSingup) {
                    libraries
                            .get(nextLibraryToSingUp).dayToStartScanning = libraries.get(nextLibraryToSingUp).singupDays
                                    + day + 1;
                    nextDayToSingup = libraries.get(nextLibraryToSingUp).dayToStartScanning;
                    nextLibraryToSingUp++;
                }
                // Recorremos las librerias que han hecho singup y su dia de escaner ya es
                // posible
                for (int numLibrarie = 0; numLibrarie < nextLibraryToSingUp; numLibrarie++) {
                    final Library lib = libraries.get(numLibrarie);
                    if (lib.nextBookToScan < lib.books.length && day >= lib.dayToStartScanning) {
                        lib.nextBookToScan += lib.booksPerDay;
                        if (lib.nextBookToScan > lib.books.length - 1) {
                            lib.nextBookToScan = lib.books.length - 1;
                        }
                    }
                }
            }
            // Algoritmo - Fin
            // Output - Inicio

            String res = "";
            int cont = 0;
            LinkedList<Integer> rdBook = new LinkedList<>();
            for (final Library library : libraries) {
                if (library.dayToStartScanning != -1) {
                    cont++;
                    res += library.id + " " + (library.nextBookToScan + 1) + "\n";
                    for (int i = 0; i < library.nextBookToScan + 1; i++) {
                        res += library.books[i] + " ";
                        if (!rdBook.contains(library.books[i])) {
                            rdBook.add(library.books[i]);
                        }
                    }
                    res += "\n";
                }
            }
            res = cont + "\n" + res;

            int auxLocalPoints = 0;
            for (Integer intg : rdBook) {
                auxLocalPoints += booksScore.get(intg);
            }


            if (auxLocalPoints > maxPoints) {
                final PrintWriter pw = new PrintWriter(new File("O" + path));
                System.out.println(auxLocalPoints);
                maxPoints = auxLocalPoints;
                pw.print(res);
                pw.close();
            }
            // Output - Fin
        }
    }
}