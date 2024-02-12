package EjerciciosColeccion.Ejercicio2;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class MemoryPeliculaDAO {
    private List<PeliculaTO> listaPeliculas;
    public MemoryPeliculaDAO(){
        listaPeliculas = new LinkedList<>();
    }
    public void addPelicula(PeliculaTO pelicula){
        if (!listaPeliculas.contains(pelicula))
            listaPeliculas.add(pelicula);
    }
    public void addAllPeliculas(List<PeliculaTO> peliculas){
        for (PeliculaTO pelicula:peliculas){
            addPelicula(pelicula);
        }
    }
    public List<PeliculaTO> getListaPeliculas(){
        return listaPeliculas;
    }
    public PeliculaTO removePelicula(PeliculaTO pelicula){
        for (PeliculaTO peliculaBorrar:listaPeliculas){
            if (peliculaBorrar.getId()== pelicula.getId())
                return listaPeliculas.remove(listaPeliculas.indexOf(pelicula));
        }
        return null;
    }
    @Override
    public String toString(){
        return listaPeliculas.stream().map(PeliculaTO::toString)
                .collect(Collectors.joining(",\n","Lista películas:\n","."));
    }
}
