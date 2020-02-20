package Structures;

import java.util.LinkedList;
import java.util.TreeSet;

public class LibreriaO {
    public int id;
    public int tiempo;
    public int escaneados;
    public int nLibrosDia;
    public LinkedList<Libro> libEsc;
    public TreeSet<Libro> libOrig;

    public LibreriaO(int id, int tiempo, int nld, TreeSet<Libro> orig){
        this.id = id;
        this.libOrig = orig;
        this.nLibrosDia = nld;
        this.tiempo = tiempo;
        escaneados = 0;
        libEsc = new LinkedList<Libro>();
    }

}