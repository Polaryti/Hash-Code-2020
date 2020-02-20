package Structures;

import java.util.LinkedList;

public class LibreriaO {
    public int id;
    public int escaneados;
    public LinkedList<Libro> libEsc;

    public LibreriaO(int id){
        this.id = id;
        escaneados = 0;
        libEsc = new LinkedList<Libro>();
    }

}