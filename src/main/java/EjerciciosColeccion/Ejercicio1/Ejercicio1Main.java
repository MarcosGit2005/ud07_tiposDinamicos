package EjerciciosColeccion.Ejercicio1;

import java.time.LocalDate;
import java.util.*;

public class Ejercicio1Main {
    public static void main(String[] args) {
        Map<Trabajador,Pais> mapaTrabajadorPais = new HashMap<>();
        mapaTrabajadorPais.put(new Trabajador("72873183A","Pepe","EE",LocalDate.of(1976,12,25)),new Pais("España",4345332));
        mapaTrabajadorPais.put(new Trabajador("72872283B","Clara","AA",LocalDate.of(2001,12,25)),new Pais("Italia",4345332));
        mapaTrabajadorPais.put(new Trabajador("72812313C","Amparo","II",LocalDate.of(1926,12,25)),new Pais("Alemania",4345332));
        mapaTrabajadorPais.put(new Trabajador("72876873D","Jorge","PP",LocalDate.of(2020,12,25)),new Pais("España",4345332));
        mapaTrabajadorPais.put(new Trabajador("72856463E","Zape","OO",LocalDate.of(1865,12,25)),new Pais("Canada",4345332));
        mapaTrabajadorPais.put(new Trabajador("71232183F","Dracula","UU",LocalDate.of(191,12,25)),new Pais("Reino Unido",4345332));

        Collection<Pais> coleccion = mapaTrabajadorPais.values();
        HashSet<Pais> setPaises = new HashSet<>(coleccion); // Lo convierto en set para que no se repitan
        System.out.println("Colección de todos los paises: ");
        for (Pais pais:coleccion){
            System.out.println(pais.getNombre());
        }
        System.out.println("Set de todos los paises: ");
        for (Pais pais:setPaises){
            System.out.println(pais.getNombre());
        }

        System.out.println("\nArrayList de todos los trabajadores ordenados: ");
        ArrayList<Trabajador> listaTrabajadores = new ArrayList<>(mapaTrabajadorPais.keySet());
        Collections.sort(listaTrabajadores);
        for (Trabajador trabajador:listaTrabajadores){
            System.out.println(" --> " + trabajador.getNombre() + " " + trabajador.getApellido());
        }
        System.out.println("TreeSet de los trabajadores: ");
        TreeSet<Trabajador> treeSetTrabajadores = new TreeSet<>(mapaTrabajadorPais.keySet());
        for (Trabajador trabajador:treeSetTrabajadores){
            System.out.println(" --> " + trabajador.getNombre() + " " + trabajador.getApellido());
        }

        System.out.println("\nListado de los paises ordenados alfabéticamente: ");
        TreeSet<Pais> setOrdenadoPaises = new TreeSet<>(mapaTrabajadorPais.values());
        for (Pais pais:setOrdenadoPaises){
            System.out.println(pais);
        }
        System.out.println("Listado trabajadores ordenados por edad: ");
        ArrayList<Trabajador> listaTrabajadoresOrdenadosEdad = new ArrayList<>(mapaTrabajadorPais.keySet());
        listaTrabajadoresOrdenadosEdad.sort(Trabajador.SORT_BY_AGE);
        for (Trabajador trabajador:listaTrabajadoresOrdenadosEdad){
            System.out.println(trabajador + " Pais: " + mapaTrabajadorPais.get(trabajador));
        }

        System.out.println("\nListado de cada pais y de cada uno de sus trabajadores: ");
        TreeMap<Pais,ArrayList<Trabajador>> mapaPaisYTrabajadores = new TreeMap<>();
        for (Pais pais:setOrdenadoPaises){ // No se repiten
            ArrayList<Trabajador> trabajadoresPertenecenPais = new ArrayList<>();
            for (Trabajador trabajador:mapaTrabajadorPais.keySet()){
                if (pais.equals(mapaTrabajadorPais.get(trabajador))){
                    trabajadoresPertenecenPais.add(trabajador);
                }
            }
            trabajadoresPertenecenPais.sort(Trabajador.SORT_BY_AGE);
            mapaPaisYTrabajadores.put(pais,trabajadoresPertenecenPais);
        }
        for (Pais pais:mapaPaisYTrabajadores.keySet()){ // Sacar por consola
            System.out.println("Trabajadores de " + pais.getNombre() + ": ");
            for (Trabajador trabajador:mapaPaisYTrabajadores.get(pais)){
                System.out.println(" " + trabajador);
            }
            System.out.println("----------------------------------------------------------------------------");
        }

        System.out.println("\nTrabajadores de mas de 50 años: ");
        Iterator<Trabajador> iteradorTrabajador = mapaTrabajadorPais.keySet().iterator();
        while (iteradorTrabajador.hasNext()){
            Trabajador trabajador = iteradorTrabajador.next();
            if (trabajador.getEdad()>50)
                System.out.println(" "+trabajador);
        }
    }
}
