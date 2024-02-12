package EjercicioEurovision;

import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args){

        String lineaSeparatoriaEjercicios = "-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------";

        Concurso eurovision = new Concurso();

        eurovision.addPaisesParticipantes(new Pais("Suecia","A","Dancing Queen"));
        eurovision.addPaisesParticipantes(new Pais("Israel","B","Toy"));
        eurovision.addPaisesParticipantes(new Pais("Italia","C","Volare"));
        eurovision.addPaisesParticipantes(new Pais("Finlandia","D","Hard Rock Hallelujah" ));
        eurovision.addPaisesParticipantes(new Pais("Estonia","E","Everybody"));
        eurovision.addPaisesParticipantes(new Pais("Australia","F","Sound of Silence"));
        eurovision.addPaisesParticipantes(new Pais("Bélgica","G","City Lights"));
        eurovision.addPaisesParticipantes(new Pais("Austria","H","Rise Like a Phoenix"));
        eurovision.addPaisesParticipantes(new Pais("España","I","Vivo Cantando"));
        eurovision.addPaisesParticipantes(new Pais("Republica Checa","J","Friend of a Friend"));
        eurovision.addPaisesParticipantes(new Pais("Lituania","K","Love is Blind"));
        eurovision.addPaisesParticipantes(new Pais("Armenia","L","Not Alone"));
        eurovision.addPaisesParticipantes(new Pais("Chipre","M","Fuego"));
        eurovision.addPaisesParticipantes(new Pais("Suiza","N","She Got Me"));
        eurovision.addPaisesParticipantes(new Pais("Ucrania","O","1944"));
        eurovision.addPaisesParticipantes(new Pais("Francia","P","Mercy"));
        eurovision.addPaisesParticipantes(new Pais("Noruega","Q","Fairytale"));
        eurovision.addPaisesParticipantes(new Pais("Portugal","R","Amar pelos dois"));
        eurovision.addPaisesParticipantes(new Pais("Eslovenia","S","Here for You"));
        eurovision.addPaisesParticipantes(new Pais("Moldavia","T","Hey Mamma!"));
        eurovision.addPaisesParticipantes(new Pais("Albania","U","Suus"));
        eurovision.addPaisesParticipantes(new Pais("Reino Unido","V","Puppet on a String"));
        eurovision.addPaisesParticipantes(new Pais("Serbia","W","Molitva"));
        eurovision.addPaisesParticipantes(new Pais("Polonia","X","Color of Your Life"));
        eurovision.addPaisesParticipantes(new Pais("Croacia","Y","My Friend"));
        eurovision.addPaisesParticipantes(new Pais("Alemania","Z","Satellite"));

        eurovision.hacerVotaciones();

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


        System.out.println(eurovision.getPaisesParticipantes() // Paises orden alfabet con sus votos orden por valor con stream().
                .stream().sorted((p1,p2) -> p1.getNombre().compareTo(p2.getNombre()))
                .map( p -> p + "\n\t\tVotos de " + p.getNombre() + ": " + p.getPaisesVotados().toString()) // si solo pongo toString me saca clave=valor al ser un map
                .collect(Collectors.joining(",\n\t","Paises de eurovisión:\n\t","\n" + lineaSeparatoriaEjercicios)));


        System.out.println(eurovision.getPaisesParticipantes() // Paises de eurovisión ordenados por puntuación.
                .stream().sorted( (p1,p2) -> p2.getPuntuacion()-p1.getPuntuacion() ).map(Pais::toString)
                .collect(Collectors.joining(",\n\t","Paises de eurovisión ordenados por puntuación:\n\t","\n" + lineaSeparatoriaEjercicios)));


        Pais paisMaxPuntuacion = eurovision.getPaisesParticipantes() // Pais con mas votos y paises que le han votado.
                .stream().max( (p1,p2) -> p1.getPuntuacion()-p2.getPuntuacion() ).get();
        String paisesQueLeHanVotado = eurovision.getPaisesParticipantes().stream().filter(p -> p.getPaisesVotados().containsKey(paisMaxPuntuacion))
                .map( p -> p.getNombre() + " -> Puntuación dada: " +  p.getPaisesVotados().get(paisMaxPuntuacion))
                .collect(Collectors.joining(",\n\t\t","Paises que han votado al ganador:\n\t\t","\n" + lineaSeparatoriaEjercicios));
        System.out.println("Pais con la máxima puntuación:\n\t" + paisMaxPuntuacion + "\n\t" + paisesQueLeHanVotado);


        System.out.println(eurovision.getPaisesParticipantes() // Canciones ordenadas por el nombre.
                .stream().sorted((p1,p2) -> p1.getNomCancion().compareTo(p2.getNomCancion())).map(Pais::getNomCancion)
                .collect(Collectors.joining(",\n\t","Canciones ordenadas por nombre:\n\t","\n" + lineaSeparatoriaEjercicios)));


        System.out.println(eurovision.getPaisesParticipantes() // Las tres canciones mejor puntuadas.
                .stream().sorted((p1,p2) -> p2.getPuntuacion()-p1.getPuntuacion()).map( p -> p.getNomCancion() + " -> puntuación: " + p.getPuntuacion())
                .limit(3).collect(Collectors.joining(",\n\t","Tres canciones mejor puntuadas:\n\t","\n" + lineaSeparatoriaEjercicios)));


        System.out.println(eurovision.getPaisesParticipantes().stream() // Nombres de todos los grupos ordenados alfabeticamente.
                .sorted((p1,p2) -> p1.getNomGrupo().compareTo(p2.getNomGrupo()))
                .map(Pais::getNomGrupo)
                .collect(Collectors.joining(",\n\t","Nombres de grupos ordenados alfabeticamente:\n\t","\n" + lineaSeparatoriaEjercicios)));
    }
}
