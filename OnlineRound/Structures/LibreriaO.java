package Structures;

import java.util.LinkedList;

public class LibreriaO {
    public int id;
    public int tiempo;
    public int escaneados;
    public LinkedList<Libro> libEsc;

    public LibreriaO(int id, int tiempo){
        this.id = id;
        this.tiempo = tiempo;
        escaneados = 0;
        libEsc = new LinkedList<Libro>();
    }

    
}