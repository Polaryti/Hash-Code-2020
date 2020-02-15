import java.io.FileNotFoundException;
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
     * @param path,   ruta del fichero.
     * @param output, estructura generada.
     * @throws FileNotFoundException, si no enceuntra el archivo o es de solo
     *                                lectura.
     */
    public static void genOutput(final String path, final Iterable output) {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(path);
        // pw.write("") Primera linea especial
        for (final Object aux : output) {
            pw.write(outputParse(aux));
        }
        } catch (FileNotFoundException e) {
            e.getMessage();
        } finally {
            pw.close();
        }
    }

    /**
     * Generador de String de output
     * 
     * @param path,   ruta del fichero.
     * @param output, estructura generada.
     * @return
     */
    private static String outputParse(final Object ele) {
        return "";
    }
}
