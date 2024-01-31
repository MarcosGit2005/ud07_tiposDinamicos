package listas;

import es.ieslavereda.Persona;

import java.time.LocalDate;
import java.util.*;

public class PrincipalLista {
    public static void main(String[] args){
        List<Integer> integerList = new ArrayList<>();
        integerList.add(2);
        integerList.add(8);
        integerList.add(7);
        integerList.add(9);
        System.out.println(integerList.size());
        System.out.println(integerList);
        integerList.addAll(List.of(1,4,6,3,2,1));
        integerList.set(2,33); // Position,new element
        System.out.println(integerList);

        List<Persona> listaPersonas = new ArrayList<>();
        listaPersonas.add(new Persona("34837284A","Paca","Romero", LocalDate.of(2004,2,29)));
        listaPersonas.add(new Persona("93289390V","Paco","Oregano",LocalDate.now()));
        listaPersonas.add(new Persona("34837284A","Paque","Cilantro",LocalDate.of(2090,4,9)));
        listaPersonas.add(new Persona("34837284A","Paqui","KAMAmllKAAA",LocalDate.of(405,12,25)));

        Iterator<Persona> iteradorPersona = listaPersonas.iterator();

        Persona p;
        while (iteradorPersona.hasNext()){
            p = iteradorPersona.next();
            if (p.getNombre().contains("o")){
                iteradorPersona.remove();
                System.out.println("has borrado a: " + p);
            }
            System.out.println(p);
        }

        System.out.println();

        Collections.sort(listaPersonas); // Una forma de ordenar con el compareTo
        for (Object per:listaPersonas.toArray()){
            System.out.println(per);
        }
        listaPersonas.sort(Persona.SORT_BY_AGE); // Otra forma de ordenar por una constante Comparator
    }
}
