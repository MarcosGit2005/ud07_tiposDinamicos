package sets.exercise;

import java.util.*;

public class Bombo {
    private Set<Bola> bombo; // setBolas
    public Bombo(){
        bombo = new LinkedHashSet<>(); // Para que tenga en cuenta el orden de inserción y le funcione el shuffle()
    }
    public Bombo(Collection<Bola> bolas){
        bombo = new LinkedHashSet<>(bolas);
    }
    public void initialize(){
        for (int i = 0; i < 90; i++)
            bombo.add(new Bola(i+1));
    }
    public void shuffle(){
        //primero pasarlo a lista
        List<Bola> bolaList = new LinkedList<>(bombo);
        Collections.shuffle(bolaList);

        //pasarlo a bombo
        bombo.clear();
        bombo.addAll(bolaList);
    }
    public void addBola(Bola bola){
        bombo.add(bola);
    }
    public void addBolas(Collection<Bola> bolas){
        bombo.addAll(bolas);
    }
    public Bola removeBola(){
        List<Bola> bolaList = new LinkedList<>(bombo);
        Bola bolaQuitada = bolaList.remove(0); // remove que devuelve el objeto solo lo tienen las Listas

        bombo.remove(bolaQuitada);
        return bolaQuitada;
    }
    public Bola getBola(){ // removeBola pero con Iterator
        Bola bola=null;
        Iterator<Bola> iterador = bombo.iterator();
        // quitamos el elemento de la posición 0
        if (iterador.hasNext()){
            bola = iterador.next();
            iterador.remove();
        }
        return bola;
    }
    @Override
    public String toString(){
        String cad = "[";
        for (Bola bola:bombo)
            cad += bola.toString() + ", ";
        return "Bombo: " + cad.substring(0,cad.length()-2) + "]";
    }
}
