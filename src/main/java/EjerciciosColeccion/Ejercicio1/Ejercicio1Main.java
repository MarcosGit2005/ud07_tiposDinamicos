package EjerciciosColeccion.Ejercicio1;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

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

        System.out.println("\nSet de todos los paises: ");
        for (Pais pais:setPaises){
            System.out.println(pais.getNombre());
        }

        System.out.println("\nArrayList de todos los trabajadores ordenados: ");
        ArrayList<Trabajador> listaTrabajadores = new ArrayList<>(mapaTrabajadorPais.keySet());
//        Collections.sort(listaTrabajadores);
//        for (Trabajador trabajador:listaTrabajadores){
//            System.out.println(" --> " + trabajador.getNombre() + " " + trabajador.getApellido());
//        }
        listaTrabajadores.stream().sorted(Trabajador::compareTo).forEach(System.out::println);

        System.out.println("\nTreeSet de los trabajadores: ");
//        TreeSet<Trabajador> treeSetTrabajadores = new TreeSet<>(mapaTrabajadorPais.keySet());
//        for (Trabajador trabajador:treeSetTrabajadores){
//            System.out.println(" --> " + trabajador.getNombre() + " " + trabajador.getApellido());
//        }
        TreeSet<Trabajador> treeSetTrabajadores = new TreeSet<>(mapaTrabajadorPais.keySet());
        treeSetTrabajadores.forEach(System.out::println); // se ordena primero por apellido que por nombre


//        System.out.println("\nListado de los paises ordenados alfabéticamente: ");
//        TreeSet<Pais> setOrdenadoPaises = new TreeSet<>(mapaTrabajadorPais.values());
//        for (Pais pais:setOrdenadoPaises){
//            System.out.println(pais);
//        }
//        System.out.println("\nListado trabajadores ordenados por edad: ");
//        ArrayList<Trabajador> listaTrabajadoresOrdenadosEdad = new ArrayList<>(mapaTrabajadorPais.keySet());
//        listaTrabajadoresOrdenadosEdad.sort(Trabajador.SORT_BY_AGE);
//        for (Trabajador trabajador:listaTrabajadoresOrdenadosEdad){
//            System.out.println(trabajador + " Pais: " + mapaTrabajadorPais.get(trabajador));
//        }

        System.out.println("\nListado de los paises ordenados alfabéticamente: ");
        TreeSet<Pais> setOrdenadoPaisesStream = new TreeSet<>(mapaTrabajadorPais.values());
        setOrdenadoPaisesStream.stream().sorted((p1,p2)->p1.getNombre().compareTo(p2.getNombre()))
                .map(Pais::getNombre).forEach(System.out::println);
        System.out.println("\nListado trabajadores ordenados por edad: ");
        mapaTrabajadorPais.keySet().stream().sorted((t1,t2)->(int)(t2.getEdad()- t1.getEdad())).forEach(System.out::println);


//        System.out.println("\nListado de cada pais y de cada uno de sus trabajadores: ");
//        TreeMap<Pais,ArrayList<Trabajador>> mapaPaisYTrabajadores = new TreeMap<>();
//        for (Pais pais:setOrdenadoPaises){ // No se repiten
//            ArrayList<Trabajador> trabajadoresPertenecenPais = new ArrayList<>();
//            for (Trabajador trabajador:mapaTrabajadorPais.keySet()){
//                if (pais.equals(mapaTrabajadorPais.get(trabajador))){
//                    trabajadoresPertenecenPais.add(trabajador);
//                }
//            }
//            trabajadoresPertenecenPais.sort(Trabajador.SORT_BY_AGE);
//            mapaPaisYTrabajadores.put(pais,trabajadoresPertenecenPais);
//        }
//        for (Pais pais:mapaPaisYTrabajadores.keySet()){ // Sacar por consola
//            System.out.println("Trabajadores de " + pais.getNombre() + ": ");
//            for (Trabajador trabajador:mapaPaisYTrabajadores.get(pais)){
//                System.out.println(" " + trabajador);
//            }
//            System.out.println("----------------------------------------------------------------------------");
//        }

        String cad = "\nListado de cada pais y de cada uno de sus trabajadores con stream:\n";
        for (Pais pais:new TreeSet<>(mapaTrabajadorPais.values())){
            cad += pais.toString();
            cad += "\n" + mapaTrabajadorPais.keySet().stream().filter(t -> mapaTrabajadorPais.get(t).equals(pais))
                    .sorted((t1,t2)->(int)(t1.getEdad()-t2.getEdad())).map(Trabajador::getNombre)
                    .collect(Collectors.joining(", ","Trabajadores de " + pais.getNombre() + ": ",".\n"));
        }
        System.out.println(cad);

//        System.out.println("\nTrabajadores de mas de 50 años: ");
//        Iterator<Trabajador> iteradorTrabajador = mapaTrabajadorPais.keySet().iterator();
//        while (iteradorTrabajador.hasNext()){
//            Trabajador trabajador = iteradorTrabajador.next();
//            if (trabajador.getEdad()>50)
//                System.out.println(" "+trabajador);
//        }

        System.out.println("\nTrabajadores de mas de 50 años con stream: ");
        mapaTrabajadorPais.keySet().stream().filter(trabajador -> trabajador.getEdad()>50).forEach(System.out::println);
    }
}
