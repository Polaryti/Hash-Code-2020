package Structures;

public class Libro implements Comparable<Libro> {
    public int id;
    public int puntos;

    public Libro(int id, int puntuacion) {
        this.id = id;
        puntos = puntuacion;
    }

    @Override
    public int compareTo(Libro obj) {
        Libro aux = (Libro) obj;
        if (this.equals(aux)) { return 0; }
        else if (this.puntos > aux.puntos) { return 1;} 
        else { return -1; }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Libro) {
            Libro aux = (Libro) obj;
            return (this.id == aux.id && this.puntos == aux.puntos);
        } else {
            return false;
        }
    }
    

}