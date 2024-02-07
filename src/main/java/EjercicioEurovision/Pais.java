package EjercicioEurovision;

import java.util.LinkedHashMap;
import java.util.Map;

public class Pais implements Comparable<Pais>{
    private String nombre;
    private String nomGrupo;
    private String nomCancion;
    private int puntuacion;
    private Map<Pais,Integer> paisesVotados;
    public Pais(String nombre,String nomGrupo,String nomCancion){
        paisesVotados = new LinkedHashMap<>();
        this.nombre = nombre;
        this.nomGrupo = nomGrupo;
        this.nomCancion = nomCancion;
    }
    public void votarPais(Pais pais,Integer puntuacion){
        paisesVotados.put(pais,puntuacion);
        pais.subirPuntuación(puntuacion);
    }
    public boolean paisInList(Pais pais){
        return paisesVotados.containsKey(pais);
    }
    public String getNombre(){
        return nombre;
    }
    public String getNomGrupo(){
        return nomGrupo;
    }
    public String getNomCancion(){
        return nomCancion;
    }
    public int getPuntuacion(){
        return puntuacion;
    }
    public void subirPuntuación(int puntuacion){
        this.puntuacion += puntuacion;
    }
    public Map<Pais,Integer> getPaisesVotados(){
        return paisesVotados;
    }
    @Override
    public int hashCode(){
        return nombre.hashCode();
    }
    @Override
    public boolean equals(Object obj){
        if (obj==null || !(obj instanceof Pais))
            return false;
        Pais pais = (Pais) obj;
        return pais.getNombre().equals(nombre);
    }
    @Override
    public int compareTo(Pais pais) {
        return nombre.compareTo(pais.getNombre());
    }
    @Override
    public String toString(){
        return "[Nombre: " + nombre + ", nombre grupo: " + nomGrupo + ", nombre cancion: " + nomCancion +", puntuación: " + puntuacion + "]";
    }
}
