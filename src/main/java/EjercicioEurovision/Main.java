package EjercicioEurovision;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args){

        String lineaSeparatoriaEjercicios = "-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------";

        Concurso eurovisión = new Concurso();

        System.out.println(eurovisión.getPaisesParticipantes()
                .stream().map( p -> p.toString())
                .collect(Collectors.joining(",\n\t","Paises de eurovisión:\n\t","\n" + lineaSeparatoriaEjercicios)));

//        List<Pais> listadoOrdenadoPaises = new LinkedList<>(eurovisión.getPaisesParticipantes());
//        Collections.sort(listadoOrdenadoPaises);
//        String paisesAlfabeticosConVotacionesOrdenadas = "Paises ordenados por nombre con votos ordenados por valor:\n";
//        for (Pais pais:listadoOrdenadoPaises){
//            paisesAlfabeticosConVotacionesOrdenadas += pais.toString() + "\nVotos del pais: " + pais.getPaisesVotados().toString() + "\n";
//        }
//        System.out.println(paisesAlfabeticosConVotacionesOrdenadas);
//
//        System.out.println();

        System.out.println(eurovisión.getPaisesParticipantes()// el mismo que el anterior pero con stream()
                .stream().sorted((p1,p2) -> p1.getNombre().compareTo(p2.getNombre()))
                .map( p -> p.toString() + "\n\t\tVotos de " + p.getNombre() + ": " + p.getPaisesVotados().toString()) // si solo pongo toString me saca clave=valor al ser un map
                .collect(Collectors.joining(",\n\t","Paises de eurovisión:\n\t","\n" + lineaSeparatoriaEjercicios)));

        System.out.println(eurovisión.getPaisesParticipantes()
                .stream().sorted( (p1,p2) -> p2.getPuntuacion()-p1.getPuntuacion() ).map( p -> p.toString())
                .collect(Collectors.joining(",\n\t","Paises de eurovisión ordenados por puntuación:\n\t","\n" + lineaSeparatoriaEjercicios)));

        Pais paisMaxPuntuación = eurovisión.getPaisesParticipantes() // pais con mas votos y paises que le han votado
                .stream().max( (p1,p2) -> p1.getPuntuacion()-p2.getPuntuacion() ).get();
        String paisesQueLeHanVotado = eurovisión.getPaisesParticipantes().stream().filter(p -> p.getPaisesVotados().containsKey(paisMaxPuntuación))
                .map( p -> p.getNombre() + " -> Puntuación dada: " +  p.getPaisesVotados().get(paisMaxPuntuación))
                .collect(Collectors.joining(",\n\t\t","Paises que han votado al ganador:\n\t\t","\n" + lineaSeparatoriaEjercicios));
        System.out.println("Pais con la máxima puntuación:\n\t" + paisMaxPuntuación.toString() + "\n\t" + paisesQueLeHanVotado);

        System.out.println(eurovisión.getPaisesParticipantes()
                .stream().sorted((p1,p2) -> p1.getNomCancion().compareTo(p2.getNomCancion())).map( p -> p.getNomCancion())
                .collect(Collectors.joining(",\n\t","Canciones ordenadas por nombre:\n\t","\n" + lineaSeparatoriaEjercicios)));

        System.out.println(eurovisión.getPaisesParticipantes()
                .stream().sorted((p1,p2) -> p2.getPuntuacion()-p1.getPuntuacion()).map( p -> p.getNomCancion() + " -> puntuación: " + p.getPuntuacion())
                .limit(3).collect(Collectors.joining(",\n\t","Tres canciones mejor puntuadas:\n\t","\n" + lineaSeparatoriaEjercicios)));

        System.out.println(eurovisión.getPaisesParticipantes().stream().sorted((p1,p2) -> p1.getNomGrupo().compareTo(p2.getNomGrupo()))
                .map( p -> p.getNomGrupo()).collect(Collectors.joining(",\n\t","Nombres de grupos ordenados alfabéticamente:\n\t","\n" + lineaSeparatoriaEjercicios)));
    }
}
