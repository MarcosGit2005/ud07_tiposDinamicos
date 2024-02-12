package EjercicioEurovision;

import java.util.*;

public class Concurso {
    private List<Pais> paisesParticipantes;
    public Concurso(){
        paisesParticipantes = new LinkedList<>();
    }
    public void hacerVotaciones(){
        if (!(paisesParticipantes.isEmpty())){
            for (Pais pais:paisesParticipantes){ // Votos
                List<Pais> paisesParaVotar = new LinkedList<>(paisesParticipantes);
                Collections.shuffle(paisesParaVotar);
                paisesParaVotar.remove(pais);
                for (int puntuación = 10; puntuación >= 1; puntuación--) {
                    // si 9->10, 10->12
                    if (puntuación<=8){
                        pais.votarPais(paisesParaVotar.remove(0),puntuación);
                    } else if (puntuación==9){
                        pais.votarPais(paisesParaVotar.remove(0),10);
                    } else {
                        pais.votarPais(paisesParaVotar.remove(0),12);
                    }
                }
            }
        }
    }
    public void addPaisesParticipantes(Pais pais){
        paisesParticipantes.add(pais);
    }
    public List<Pais> getPaisesParticipantes(){
        return paisesParticipantes;
    }
    @Override
    public String toString(){
        String cadena="";
        for (Pais pais:paisesParticipantes)
            cadena += pais.toString() + "\n";
        return cadena;
    }
}
