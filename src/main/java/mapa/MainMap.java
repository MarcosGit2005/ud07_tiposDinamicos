package mapa;

import java.util.*;

public class MainMap {
    public static void main(String[] args) {
        Map<String,Double> fruta = new HashMap<>();
        fruta.put("platano",1.88);
        fruta.put("naranja",1.23);
        fruta.put("clementina",56.77);
        fruta.put("platano",16.88); // inflación

        fruta.put("patacas",66.66);
        fruta.remove("patacas");

        fruta.put("platano",null);
        System.out.println(fruta);

        System.out.println("fruta contains clave platano? " + fruta.containsKey("platano"));
        System.out.println("fruta contains valor 382984.9? " + fruta.containsValue(382984.9));

        Set<String> setClaves = fruta.keySet(); // no se repite ninguna clave
        HashSet<String> hashSetClaves = new HashSet<>(setClaves);

        Collection<Double> coleccionValores = fruta.values(); // tambien se pueden sacar los valores como colección y luego pasarlo a set o lista
        LinkedList<Double> listaValores = new LinkedList<>(coleccionValores);
        HashSet<Double> hashSetValores = new HashSet<>(coleccionValores); // elimina los repetidos al ser un set

        System.out.println("\nForma iterar 1: ");
        for (String clave:fruta.keySet()){ // forma iterar 1
            System.out.println(" --> clave : " + clave + ", valor: " + fruta.get(clave));
        }

        System.out.println("\nForma iterar 2: "); // forma iterar 2
        for (Map.Entry<String,Double> frutaIndividual : fruta.entrySet()){ // entrySet devuelve una variable Entry con el par clave-valor
            System.out.println(" --> clave : " + frutaIndividual.getKey() + ", valor: " + frutaIndividual.getValue());
        }

        System.out.println("\nImprimir solo claves: ");
        // imprimir solo claves
        for (String clave:fruta.keySet()){ // forma iterar 1
            System.out.print(" --> clave : " + clave);
        }

        System.out.println("\n\nImprimir solo valores: ");
        // imprimir solo valores
        for (Double valor:fruta.values()){
            System.out.print(" --> valor: " + valor);
        }

        System.out.println("\n\nImprimir clave-valor con iterador: ");
        // impromir clave-valor con el iterador
        Iterator<String> iterador = fruta.keySet().iterator();
        while (iterador.hasNext()){
            String clave = iterador.next();
            System.out.println(" --> clave: " + clave + ", valor: " + fruta.get(clave));
        }

        System.out.println("\n\nImprimir clave-valor con forEach(): ");
        // impromir clave-valor con el metodo forEach
        fruta.forEach((frutilla,precio) -> System.out.println(" --> clave: " + frutilla + ", valor: " + precio));
    }
}
