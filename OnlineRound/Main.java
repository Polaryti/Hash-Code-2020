import java.uti.LinkedList;

/**
 * Clase principal que ejecutara el solucionador del Hash Code 2020 de forma secuencial o paralela.
 *
 * @author Los Marcos
 * @version 1.0
 * @since 14-02-20
 */
public class Main {
    private final String inputA = "";
    private final String inputB = "";
    private final String inputC = "";
    private final String inputD = "";
    private final String inputE = "";
    private final String outputA = "";
    private final String outputB = "";
    private final String outputC = "";
    private final String outputD = "";
    private final String outputE = "";

    public static void main(String[] args) {
        LinkedList<LinkedList<String>> rawInput = InputParser.getInput(inputA);
        LinkedList<HashCodeObject> objectInput = ObjectGenerator.getHashCodeObjects(rawInput); // Si la primera linea es epecial, habrá que quitarla
        Object res = Algorithms.algorithmA(0, 1, objectInput);
        System.out.println(PointsCalculator.calculatePoints(res));
        OutputParser.getOutput(outputA, res);
    }
}