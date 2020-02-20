import java.util.LinkedList;

import Structures.*;
import Util.*;
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
    private final static String inputA = "";
    private final static String inputB = "";
    private final static String inputC = "";
    private final static String inputD = "";
    private final static String inputE = "";
    private final static String outputA = "";
    private final static String outputB = "";
    private final static String outputC = "";
    private final static String outputD = "";
    private final static String outputE = "";

    public static void main(String[] args) {
        String[] parametros, puntuacionLibros;
        LinkedList<Libreria> librerias = new LinkedList<>();
        Scanner sc = null;
        try {
            sc = new Scanner(inputA);
            parametros = sc.nextLine().split(" ");
            puntuacionLibros = sc.nextLine().split(" ");
            int cont = 0;
            while (sc.hasNextLine()) {
                String[] pro = sc.nextLine().split(" ");
                String[] libros = sc.nextLine().split(" ");
                int[] libInt = new int[libros.length];
                for (int i = 0; i < libros.length; i++) {
                    libInt[i] = Integer.parseInt(libros[i]);
                }
                Libreria lb = new Libreria(cont, Integer.parseInt(pro[0]), Integer.parseInt(pro[1]), Integer.parseInt(pro[2]), libInt);
                librerias.add(lb);
                cont++;
            }
        } finally {
            sc.close();
        }
    }
}