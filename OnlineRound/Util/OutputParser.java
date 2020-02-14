import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Clase de utilidad que recibe la estructura de output y la escribe en fichero
 *
 * @author Los Marcos
 * @version 1.0
 * @since 14-02-20
 */
public class OutputParser {
    /**
     * Crea la lista de listas de parametros.
     * 
     * @param path, ruta del fichero.
     * @param output, estructura generada.
     */
    public static void genOutput(String path, ArrayList<Object> output) {
        PrintWriter pw = new PrintWriter(path);
        //pw.write("") Primera linea especial
        for (Object aux : output) {
            pw.write(outputParse(output));
        }
        pw.close();
    }

    /**
     * Generador de String de output
     * 
     * @param path, ruta del fichero.
     * @param output, estructura generada.
     * @return 
     */
    private static String outputParse(Object ele) {
        return "";
    }
}
