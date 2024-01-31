package listas;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListaComoInterfaz {
    public static void main(String[] args) {
        // declaro el objeto como clase, pero no esta ok del to do...
        ArrayList<String> listaArray = new ArrayList<>();
        listaArray.add("Chayanne");
        listaArray.add("Juno");
        listaArray.add("BeachHouse");
        listaArray.add("Juna");
        imprimir(listaArray);
    }
    private static void imprimir(List<String> list){ // Mejor hacer el metodo con List que con cada tipo de listas
        for (String s:list)
            System.out.print(" - " + s);
        System.out.println();
    }
}
