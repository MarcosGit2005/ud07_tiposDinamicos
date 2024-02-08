package EjercicioEurovision;

import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args){

        String lineaSeparatoriaEjercicios = "-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------";

        Concurso eurovision = new Concurso();

        System.out.println(eurovision.getPaisesParticipantes()
                .stream().map(Pais::toString)
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

        System.out.println(eurovision.getPaisesParticipantes()// el mismo que el anterior pero con stream()
                .stream().sorted((p1,p2) -> p1.getNombre().compareTo(p2.getNombre()))
                .map( p -> p + "\n\t\tVotos de " + p.getNombre() + ": " + p.getPaisesVotados().toString()) // si solo pongo toString me saca clave=valor al ser un map
                .collect(Collectors.joining(",\n\t","Paises de eurovisión:\n\t","\n" + lineaSeparatoriaEjercicios)));

        System.out.println(eurovision.getPaisesParticipantes()
                .stream().sorted( (p1,p2) -> p2.getPuntuacion()-p1.getPuntuacion() ).map(Pais::toString)
                .collect(Collectors.joining(",\n\t","Paises de eurovisión ordenados por puntuación:\n\t","\n" + lineaSeparatoriaEjercicios)));

        Pais paisMaxPuntuacion = eurovision.getPaisesParticipantes() // pais con mas votos y paises que le han votado
                .stream().max( (p1,p2) -> p1.getPuntuacion()-p2.getPuntuacion() ).get();
        String paisesQueLeHanVotado = eurovision.getPaisesParticipantes().stream().filter(p -> p.getPaisesVotados().containsKey(paisMaxPuntuacion))
                .map( p -> p.getNombre() + " -> Puntuación dada: " +  p.getPaisesVotados().get(paisMaxPuntuacion))
                .collect(Collectors.joining(",\n\t\t","Paises que han votado al ganador:\n\t\t","\n" + lineaSeparatoriaEjercicios));
        System.out.println("Pais con la máxima puntuación:\n\t" + paisMaxPuntuacion + "\n\t" + paisesQueLeHanVotado);

        System.out.println(eurovision.getPaisesParticipantes()
                .stream().sorted((p1,p2) -> p1.getNomCancion().compareTo(p2.getNomCancion())).map(Pais::getNomCancion)
                .collect(Collectors.joining(",\n\t","Canciones ordenadas por nombre:\n\t","\n" + lineaSeparatoriaEjercicios)));

        System.out.println(eurovision.getPaisesParticipantes()
                .stream().sorted((p1,p2) -> p2.getPuntuacion()-p1.getPuntuacion()).map( p -> p.getNomCancion() + " -> puntuación: " + p.getPuntuacion())
                .limit(3).collect(Collectors.joining(",\n\t","Tres canciones mejor puntuadas:\n\t","\n" + lineaSeparatoriaEjercicios)));

        System.out.println(eurovision.getPaisesParticipantes().stream().sorted((p1,p2) -> p1.getNomGrupo().compareTo(p2.getNomGrupo()))
                .map(Pais::getNomGrupo).collect(Collectors.joining(",\n\t","Nombres de grupos ordenados alfabéticamente:\n\t","\n" + lineaSeparatoriaEjercicios)));
    }
}
