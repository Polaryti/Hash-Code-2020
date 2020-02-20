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

    static int[] punt;
    static boolean[] isVisitado;
    static String[] parametros, puntuacionLibros;
    static LinkedList<Libreria> librerias;
    static int diasRest = 0;

    public static void main(String[] args) throws FileNotFoundException {
        librerias = new LinkedList<>();

        Scanner sc = null;
        try {
            sc = new Scanner(new File(inputA));
            parametros = sc.nextLine().split(" ");
            //creamos un array con el numero de libros y sus puntuaciones
            punt = new int[Integer.parseInt(parametros[0])];
            diasRest = Integer.parseInt(parametros[2]);
            puntuacionLibros = sc.nextLine().split(" ");
            //isVisitado = new boolean[puntuacionLibros.length];
            //insercion de las respectivas puntuaciones de los libros
            for (int i = 0; i < puntuacionLibros.length; i++) {
                punt[i] = Integer.parseInt(puntuacionLibros[i]);
            }
            int cont = 0;
            //lectura de las diferentes librerias
            while (sc.hasNextLine()) {
                String[] pro = sc.nextLine().split(" ");
                String[] libros = sc.nextLine().split(" ");
                TreeSet<Libro> librosI = new TreeSet<>();

                for (int i = 0; i < libros.length; i++) {
                    Libro book = new Libro(i, Integer.parseInt(libros[i]));
                    librosI.add(book);
                }
                //Creacion de la libreria a partir de los parametros leidos;
                Libreria lb = new Libreria(cont, Integer.parseInt(pro[0]), Integer.parseInt(pro[1]),
                        Integer.parseInt(pro[2]), librosI);
                librerias.add(lb);
                cont++;
            }
            
            //Termina la lectura del archivo
            while(diasRest > 0){
                siguienteMejor();
            }

        } finally {
            sc.close();
        }
    }

    public static void siguienteMejor(){
        //Calcular puntuacion "más alta"
        Libreria aux = null;
        int max = 0;
        int maxInd = -1;
        for(int i = 0; i < librerias.size(); i++){
            aux = librerias.get(i);
            int act = aux.puntuacion(diasRest);
            if( act > max){
                max = act;
                maxInd = i;
            }
        }
        if (maxInd != -1){
            aux = librerias.get(maxInd);
            diasRest -= aux.dias;
        }
        //Añadir el mejor al resultado(Ni idea del formato)
        
        //Actualizar puntuacion de los libros escogidos
        /*if (aux != null){
            int tam = aux.seleccionados.size();
            TreeSet<Libro> lista = new TreeSet<Libro>();
            for(int i = 0; i < tam; i++){
                Libro aux2 = aux.seleccionados.last();
                punt[aux2.id] = 0;
                lista.add(aux2);
                aux.seleccionados.remove(aux2);
            }
            aux.seleccionados = lista;
        }*/
        //Actualizar los libros de las librerias que tienen coincidencias
        if (aux != null){
            int tam = aux.seleccionados.size();            
            TreeSet<Libro> lista = new TreeSet<Libro>();
            for(int i = 0; i < tam; i++){
                Libro aux2 = aux.seleccionados.last();
                for(int j = 0; j < librerias.size(); j++){
                    Libreria actual = librerias.get(j);
                    if(!actual.equals(aux)){
                        boolean saca = actual.lib.remove(aux2);
                        if(saca){actual.lib.add(new Libro(aux2.id,0));}
                    }
                }
                lista.add(aux2);
                aux.seleccionados.remove(aux2);
            }
        }
        //Elminar libreria de la lista de librerias
        if(aux != null){librerias.remove(aux);}
        if(maxInd == -1){diasRest = 0;}
        
    }
}