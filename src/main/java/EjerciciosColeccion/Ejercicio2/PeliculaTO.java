package EjerciciosColeccion.Ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class PeliculaTO {

    String titulo;

    List<String> actores;

    List<String> directores;

    public PeliculaTO() {

        actores = new ArrayList<>();

        directores = new ArrayList<>();

    }

    public List<String> getActores() {

        return actores;

    }

    public void addActor(String actor) {

        actores.add(actor);

    }

}