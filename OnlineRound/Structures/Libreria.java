package Structures;

import java.util.List;


public class Libreria {
    public int nLibros;
    public int dias;
    public int lpdia;
    public int[] lib;

    public Libreria(int nl, int d, int lpd, int[] lib){
        nLibros = nl;
        dias = d;
        lpdia = lpd;
        lib = new int[nl];
        System.arraycopy(lib, 0, this.lib, 0, nl);
    }


 }