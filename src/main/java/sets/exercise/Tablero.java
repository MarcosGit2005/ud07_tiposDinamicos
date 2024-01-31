package sets.exercise;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Tablero {
    private Set<Bola> bolasTablero;
    public Tablero(){
        bolasTablero = new TreeSet<>();
    }
    public boolean check(Bola bola){
        return bolasTablero.contains(bola);
    }
    public boolean checkAll(Collection<Bola> bolas){
        return bolasTablero.containsAll(bolas);
    }
    public void addBola(Bola bola){
        bolasTablero.add(bola);
    }
    @Override
    public String toString(){
        String cad = "[";
        for (Bola bola:bolasTablero)
            cad += bola.toString() + ", ";
        return "Tablero: " + cad.substring(0,cad.length()-2) + "]";
    }
}
