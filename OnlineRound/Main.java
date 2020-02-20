import java.util.LinkedList;

import Structures.*;
import Util.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Clase principal que ejecutara el solucionador del Hash Code 2020 de forma
 * secuencial o paralela.
 *
 * @author Los Marcos
 * @version 1.0
 * @since 14-02-20
 */
public class Main {
    private final static String inputA = "C:\\Users\\mario\\Documents\\GitHub\\Hash-Code-2020\\OnlineRound\\Input\\a_example.txt";
    private final static String inputB = "";
    private final static String inputC = "";
    private final static String inputD = "";
    private final static String inputE = "";
    private final static String outputA = "Output/A";
    private final static String outputB = "";
    private final static String outputC = "";
    private final static String outputD = "";
    private final static String outputE = "";

    static HashMap<Integer, Integer> punt;
    static boolean[] isVisitado;
    static String[] parametros, puntuacionLibros;
    static LinkedList<Libreria> librerias;

    public static void main(String[] args) throws FileNotFoundException {
        librerias = new LinkedList<>();

        Scanner sc = null;
        try {
            sc = new Scanner(new File(inputA));
            parametros = sc.nextLine().split(" ");
            puntuacionLibros = sc.nextLine().split(" ");
            punt = new HashMap<>(puntuacionLibros.length * 2);
            isVisitado = new boolean[puntuacionLibros.length];
            for (int i = 0; i < puntuacionLibros.length; i++) {
                punt.put(i, Integer.parseInt(puntuacionLibros[i]));
            }
            int cont = 0;
            while (sc.hasNextLine()) {
                String[] pro = sc.nextLine().split(" ");
                String[] libros = sc.nextLine().split(" ");
                TreeSet<Libro> librosI = new TreeSet<>();

                for (int i = 0; i < libros.length; i++) {
                    Libro book = new Libro(i, Integer.parseInt(libros[i]));
                    librosI.add(book);
                }
                Libreria lb = new Libreria(cont, Integer.parseInt(pro[0]), Integer.parseInt(pro[1]),
                        Integer.parseInt(pro[2]), librosI);
                librerias.add(lb);
                cont++;
            }
        } finally {
            sc.close();
        }
    }

    public static void fuerzaBruta() throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new File(outputA));
        LinkedList<Libreria> libActivas = new LinkedList<>();
        LinkedList<LibreriaO> output = new LinkedList<>();
        pw.println()
        int cont = 1;
        for (Libreria libreia : librerias) {
            
        }

    }
}