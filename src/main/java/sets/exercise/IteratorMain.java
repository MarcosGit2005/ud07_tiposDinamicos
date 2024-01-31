package sets.exercise;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorMain {
    public static void main(String[] args) {
        List<String> lista = new ArrayList<>(List.of("a","b","c","d","e"));
        Iterator<String> iterador = lista.iterator();

        while(iterador.hasNext()){ // Se usa iterador si se quiere modificar
            String cadena = iterador.next();
            if (cadena.equals("a"))
                iterador.remove();
            else
                System.out.println(cadena);
        }
    }
}
