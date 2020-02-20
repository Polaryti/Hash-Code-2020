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
    private final static String inputB = "C:\\Users\\mario\\Documents\\GitHub\\Hash-Code-2020\\OnlineRound\\Input\\b_read_on.txt";
    private final static String inputC = "";
    private final static String inputD = "";
    private final static String inputE = "";
    private final static String outputA = "C:\\Users\\mario\\Documents\\GitHub\\Hash-Code-2020\\OnlineRound\\Output\\A.txt";
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
            sc = new Scanner(new File(inputB));
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
        fuerzaBruta();
    }

    public static void fuerzaBruta() throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new File(outputA));
        boolean libSiendoCertificadas = true;
        int siendoCertificada = -1;
        LinkedList<LibreriaO> output = new LinkedList<>();

        output.add(new LibreriaO(librerias.getFirst().idLib, librerias.getFirst().dias, librerias.getFirst().lpdia, librerias.getFirst().lib));
        siendoCertificada = librerias.getFirst().idLib;
        librerias.removeFirst();
        for (int i = 0; i < Integer.parseInt(parametros[2]); i++) {
            LibreriaO toAdd = null;
            // Se recorren todas las librerias que hay en la solución
            for (LibreriaO libO : output) {
                if (siendoCertificada == libO.id) {
                    // Si esta siendo certificada se le resta uno al tiempo de certificación
                    libO.tiempo--;
                    if (libO.tiempo <= 0) {
                        libSiendoCertificadas = false;
                        siendoCertificada = -1;
                    }
                } else if (!libSiendoCertificadas && !librerias.isEmpty()) {
                    // Si no se esta ninguna certificada se añade otra
                    Libreria lib = librerias.getFirst();
                    librerias.removeFirst();
                    LibreriaO libOO = new LibreriaO(lib.idLib, lib.dias, lib.lpdia, lib.lib);
                    toAdd = libOO;

                    libOO.tiempo--;
                    libSiendoCertificadas = true;
                    siendoCertificada = libOO.id;
                } else if (libO.tiempo <= 0 && !libO.libOrig.isEmpty()) {
                    // Recorro todos los libros de la libreria que quedan y se añade a la lista resultado
                    for (i = 0; i < libO.nLibrosDia && !libO.libOrig.isEmpty(); i++) {
                        Libro l = libO.libOrig.first();
                        libO.libOrig.remove(l);
    
                        if (!isVisitado[l.id]) {
                            isVisitado[l.id] = true;
                            libO.libEsc.add(l);
                            libO.escaneados += 1;
                        }
                    }
                }
                
            }
            if (toAdd != null) {

                output.add(toAdd);
            }
        }
        String res = "";
        int nLibreriasEscaneadas = output.size();
        res += nLibreriasEscaneadas + "\n";
        for (LibreriaO libORes : output) {
            if (libORes.tiempo <= 0) {
                int escaneados = libORes.escaneados;
                res += libORes.id + " " + escaneados + "\n";
                for (Libro lRes : libORes.libEsc) {
                    res += lRes.id + " ";
                }
                res += "\n";
            }
        }

        pw.println(res);
        pw.close();
    }
}