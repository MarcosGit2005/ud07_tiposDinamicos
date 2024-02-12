package EjerciciosColeccion.Ejercicio2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PeliculaTO {

    private String titulo;

    private Map<String,String> actores;

    private List<String> directores;
    private int id;
    private static int index=0;

    public PeliculaTO(String titulo) {

        this.id=index++;

        this.titulo = titulo;

        actores = new HashMap<>();

        directores = new ArrayList<>();

    }
    public String getTitulo(){
        return titulo;
    }
    public int getId(){
        return id;
    }
    public Map<String,String> getActores() {
        return actores;
    }

    public void addActor(String actor,String personaje) {
        actores.put(actor,personaje);
    }
    public void addDirector(String director){
        directores.add(director);
    }
    @Override
    public String toString(){
        return "[" + titulo + ", actores: " + actores.toString() + ", directores: " + directores.toString() + "]";
    }
    @Override
    public boolean equals(Object obj){
        if (obj==null || !(obj instanceof PeliculaTO))
            return false;
        PeliculaTO pelicula = (PeliculaTO) obj;
        return getId()==pelicula.getId();
    }
}