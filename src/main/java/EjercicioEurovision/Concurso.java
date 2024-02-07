package EjercicioEurovision;

import java.util.*;

public class Concurso {
    private List<Pais> paisesParticipantes;
    public Concurso(){
        paisesParticipantes = new LinkedList<>();
        paisesParticipantes.add(new Pais("Suecia","A","Dancing Queen"));
        paisesParticipantes.add(new Pais("Israel","B","Toy"));
        paisesParticipantes.add(new Pais("Italia","C","Volare"));
        paisesParticipantes.add(new Pais("Finlandia","D","Hard Rock Hallelujah" ));
        paisesParticipantes.add(new Pais("Estonia","E","Everybody"));
        paisesParticipantes.add(new Pais("Australia","F","Sound of Silence"));
        paisesParticipantes.add(new Pais("Bélgica","G","City Lights"));
        paisesParticipantes.add(new Pais("Austria","H","Rise Like a Phoenix"));
        paisesParticipantes.add(new Pais("España","I","Vivo Cantando"));
        paisesParticipantes.add(new Pais("Republica Checa","J","Friend of a Friend"));
        paisesParticipantes.add(new Pais("Lituania","K","Love is Blind"));
        paisesParticipantes.add(new Pais("Armenia","L","Not Alone"));
        paisesParticipantes.add(new Pais("Chipre","M","Fuego"));
        paisesParticipantes.add(new Pais("Suiza","N","She Got Me"));
        paisesParticipantes.add(new Pais("Ucrania","O","1944"));
        paisesParticipantes.add(new Pais("Francia","P","Mercy"));
        paisesParticipantes.add(new Pais("Noruega","Q","Fairytale"));
        paisesParticipantes.add(new Pais("Portugal","R","Amar pelos dois"));
        paisesParticipantes.add(new Pais("Eslovenia","S","Here for You"));
        paisesParticipantes.add(new Pais("Moldavia","T","Hey Mamma!"));
        paisesParticipantes.add(new Pais("Albania","U","Suus"));
        paisesParticipantes.add(new Pais("Reino Unido","V","Puppet on a String"));
        paisesParticipantes.add(new Pais("Serbia","W","Molitva"));
        paisesParticipantes.add(new Pais("Polonia","X","Color of Your Life"));
        paisesParticipantes.add(new Pais("Croacia","Y","My Friend"));
        paisesParticipantes.add(new Pais("Alemania","Z","Satellite"));


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
