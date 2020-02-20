package Structures;

import java.util.TreeSet;

public class Libreria {
    public int idLib;
    public int nLibros;
    public int dias;
    public int lpdia;
    public TreeSet<Libro> lib;
    public TreeSet<Libro> seleccionados;
    TreeSet<Libro> aux = new TreeSet<Libro>();

    public Libreria(int id, int nl, int d, int lpd, TreeSet<Libro> lirbos) {
        idLib = id;
        nLibros = nl;
        dias = d;
        lpdia = lpd;
        lib = lirbos;
    }

    public int puntuacion(int diasRest){
        aux = new TreeSet<Libro>();
        if (diasRest >= dias){return 0;} 
        int res = 0;
        int libros = (diasRest - dias) * lpdia;
        if (libros > lib.size()){libros = lib.size();}
        for(int i = 0; i < libros; i++){
            Libro aux2 = lib.last();
            aux.add(aux2);
            lib.remove(aux2);
            res += aux2.puntos;
        }
        int tam = aux.size();
        for(int i = 0; i < tam; i++){
            Libro aux2 = aux.last();
            seleccionados.add(aux2);
            lib.add(aux2);
        }
        res /= dias;
        return res;
    }

    public String toString(){
        String res = "Libreria " + idLib + ": ";
        aux = new TreeSet<Libro>();
        int tam = lib.size();
        for(int i = 0; i < tam; i++){
            Libro aux2 = lib.last();
            aux.add(aux2);
            lib.remove(aux2);
            res += aux2.id + " ";
        }
        lib = aux;
        return res;
    }
}