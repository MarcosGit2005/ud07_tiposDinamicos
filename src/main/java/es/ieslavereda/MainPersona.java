package es.ieslavereda;

import java.time.LocalDate;
import java.util.Arrays;

public class MainPersona {
    public static void main(String[] args) {
        ListDE<Persona> listaPersonas = new ListDE<>();
        listaPersonas.addHead(new Persona("29374620E","Pepe","Pantanos", LocalDate.now()));
        System.out.println(listaPersonas);

        ListGeneric<String> listString = new ListGeneric<>();
        listString.addTail("djsddsjads");
        System.out.println(listString);
        System.out.println(Arrays.toString(listString.getAsArray(String.class)));
    }
}
