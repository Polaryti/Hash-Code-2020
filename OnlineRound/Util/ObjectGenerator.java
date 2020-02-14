import java.util.LinkedList;

/**
 * Clase de utilidad que recibe el input tratado y lo transforma en una lista de HashCodeObject.
 *
 * @author Los Marcos
 * @version 1.0
 * @since 14-02-20
 */
public class ObjectGenerator {
    /**
     * Crea la lista de HashCodeObject
     * 
     * @param rawInput, lista de lista de parametros.
     * @return LinkedList<HashCodeObject>, la lista de HashCodeObject.
     */
    public static LinkedList<HashCodeObject> getHashCodeObjects(LinkedList<LinkedList<String>> rawInput) {
        LinkedList<HashCodeObject> res = new LinkedList<>();
        for (LinkedList<String> aux : rawInput) {
            res.add(new HashCodeObject()); // A modificar
        }
        return res;
    }
}