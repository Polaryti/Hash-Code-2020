package Structures;

import java.util.TreeSet;


public class Libreria {
    public int idLib;
    public int nLibros;
    public int dias;
    public int lpdia;
    public TreeSet<Libro> lib;

    public Libreria(int id, int nl, int d, int lpd, TreeSet<Libro> lirbos){
        idLib = id;
        nLibros = nl;
        dias = d;
        lpdia = lpd;
        lib = lirbos;
    }




 }