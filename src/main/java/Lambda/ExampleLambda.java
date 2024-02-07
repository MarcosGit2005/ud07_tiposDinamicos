package Lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ExampleLambda {
    public static void main(String[] args) {
        List<String> listaEjemplo = List.of("Paco","Carlos","Elena","Ana");

        String nombresSinPrimeraVocal = listaEjemplo.stream()
                .filter((s) -> s.charAt(0)!='A' && s.charAt(0)!='E' && s.charAt(0)!='I' && s.charAt(0)!='O' && s.charAt(0)!='U')
                .sorted()
                .collect(Collectors.joining(",","Names: ","."));
    }
}
