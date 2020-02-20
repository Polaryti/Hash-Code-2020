package Util;

import java.util.Scanner;
import java.util.LinkedList;

/**
 * Clase de utilidad que recibe el input y lo transforma en una lista donde cada
 * elemento es una lista con los parametros de cada linea
 *
 * @author Los Marcos
 * @version 1.0
 * @since 14-02-20
 */
public class InputParser {

    /**
     * Crea la lista de listas de parametros.
     * 
     * @param path, ruta del fichero.
     * @return LinkedList<LinkedList<String>>, la lista de listas.
     */
    public static LinkedList<LinkedList<String>> getInput(final String path) {
        LinkedList<LinkedList<String>> input = new LinkedList<>();
        Scanner sc = null;
        try {
            sc = new Scanner(path);
            while (sc.hasNextLine()) {
                LinkedList<String> aux = new LinkedList<>();
                while (sc.hasNext()) {
                    aux.add(sc.next());
                }
                input.add(aux);
            }
        } finally {
            sc.close();
        }
        return input;
    }
}