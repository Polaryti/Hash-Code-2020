import java.util.LinkedList;

import Structures.HashCodeObject;
import Util.*;

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
        LinkedList<LinkedList<String>> rawInput = InputParser.getInput(inputA);
        LinkedList<HashCodeObject> objectInput = ObjectGenerator.getHashCodeObjects(rawInput); // A modificar
        Iterable res = Algorithms.AlgorithmA(0, 1, objectInput);
        System.out.println(PointsCalculator.calculatePoints(res));
        OutputParser.genOutput(outputA, res);
    }
}