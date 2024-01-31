package sets;
import es.ieslavereda.Persona;

import java.time.LocalDate;
import java.util.*;

public class MainSet {
    public static void main(String[] args){
        List<Persona> listaPersonas = new ArrayList<>();
        listaPersonas.add(new Persona("34837284A","Paca","Romero", LocalDate.of(2004,2,29)));
        listaPersonas.add(new Persona("93289390V","Paco","Oregano",LocalDate.now()));
        listaPersonas.add(new Persona("34837284A","Paque","Cilantro",LocalDate.of(2090,4,9)));
        listaPersonas.add(new Persona("34837284A","Paqui","KAMAmllKAAA",LocalDate.of(405,12,25)));
        listaPersonas.add(new Persona("93289390V","Paco","Oregano",LocalDate.now()));
        listaPersonas.add(new Persona("34837284A","Paque","Cilantro",LocalDate.of(2090,4,9)));
        listaPersonas.add(new Persona("34837284A","Paqui","KAMAmllKAAA",LocalDate.of(405,12,25)));
        listaPersonas.add(new Persona("93289390V","Paco","Oregano",LocalDate.now()));
        listaPersonas.add(new Persona("34837284A","Paque","Cilantro",LocalDate.of(2090,4,9)));
        listaPersonas.add(new Persona("34837284A","Paqui","KAMAmllKAAA",LocalDate.of(405,12,25)));
        listaPersonas.add(new Persona("93289390V","Paco","Oregano",LocalDate.now()));
        listaPersonas.add(new Persona("34837284A","Paque","Cilantro",LocalDate.of(2090,4,9)));
        listaPersonas.add(new Persona("34837284A","Paqui","KAMAmllKAAA",LocalDate.of(405,12,25)));

        Set<Persona> personaSet = new HashSet<>(listaPersonas); // No se repiten porque es un HASH (SET) y Persona tiene la funcion hash
        System.out.println(personaSet);

        Set<Persona> personaLinkedSet = new LinkedHashSet<>(listaPersonas);
    }
}
