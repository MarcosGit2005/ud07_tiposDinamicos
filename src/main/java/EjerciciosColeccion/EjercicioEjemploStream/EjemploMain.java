package EjerciciosColeccion.EjercicioEjemploStream;

import EjerciciosColeccion.Ejercicio1.Pais;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class EjemploMain {
    public static void main(String[] args) {
        List<Pais> paises = List.of(
                new Pais("España",3),
                new Pais("Francia",4),
                new Pais("Alemania",83),
                new Pais("Portugal",8),
                new Pais("Bélgica",2),
                new Pais("Rumania",9));

        String listadoPaisesOrdenadosNombre = paises.stream() // ordenado por nombre
                .sorted()
                .map( p -> p.getNombre() ) // para transformar pais en string // es como poner Pais::getNombre()
                .collect(Collectors.joining(", ","Paises ordenados por nombre: ","."));
        System.out.println(listadoPaisesOrdenadosNombre);

        String listadoPaisesOrdenadosHabitantes = paises.stream() // ordenado por habitantes
                .sorted((p1, p2) -> p1.getNumHabitantes()-p2.getNumHabitantes())
                .map( p -> p.getNombre() ) // para transformar pais en string // es como poner Pais::getNombre()
                .collect(Collectors.joining(", ","Paises ordenados por habitantes 1: ","."));
        System.out.println(listadoPaisesOrdenadosHabitantes);

        String listadoPaisesOrdenadosHabitantes2 = paises.stream() // ordenado por habitantes
                .sorted(Pais.SORT_BY_POPULATION.reversed()) // tambien se puede poner un Comparator // el reversed es una funcion de comparator
                .map( p -> p.getNombre() ) // para transformar pais en string // es como poner Pais::getNombre()
                .collect(Collectors.joining(", ","Paises ordenados por habitantes 2: ","."));
        System.out.println(listadoPaisesOrdenadosHabitantes2);

        String listadoPaisesEmpiezaConsonantePoblacionMayorQue7 = paises.stream()// inicio stream
                .filter(pais -> pais.getNombre().charAt(0)!='A' && pais.getNombre().charAt(0)!='E' &&
                        pais.getNombre().charAt(0)!='I' && pais.getNombre().charAt(0)!='O' && pais.getNombre().charAt(0)!='U')// que la primera letra no sea vocal
                .filter(pais -> pais.getNumHabitantes()>7)// que tenga mas de 7 habitantes
                .map( p -> p.getNombre()) // me saco los nombres
                .collect(Collectors.joining(", ","Paises que empiezen por consonante y con población mayor a 7: ",".")); // los junto en un string
        System.out.println(listadoPaisesEmpiezaConsonantePoblacionMayorQue7);

        Optional<Pais> opcional = paises.stream() // Con optional puede haber o no un resultado de vuelta
                .filter(p -> p.getNombre().charAt(0)=='Z')
                .findFirst();

    }
}
