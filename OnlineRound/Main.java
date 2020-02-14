import java.uti.LinkedList;

/**
 * Clase principal que ejecutara el solucionador del Hash Code 2020 de forma secuencial o paralela.
 *
 * @author Los Marcos
 * @version 1.0
 * @since 14-02-20
 */
public class Main {
    private final String pathA = "";
    private final String pathB = "";
    private final String pathC = "";
    private final String pathD = "";
    private final String pathE = "";

    public static void main(String[] args) {
        LinkedList<LinkedList<String>> rawInput = InputParser.getInput(pathA);
        LinkedList<HashCodeObject> objectInput = ObjectGenerator.getHashCodeObjects(rawInput); // Si la primera linea es epecial, habrá que quitarla
        //Algorithms.algorithmA(0, 1, objectInput);
    }
}