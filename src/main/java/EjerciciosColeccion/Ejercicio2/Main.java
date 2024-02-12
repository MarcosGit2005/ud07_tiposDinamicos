package EjerciciosColeccion.Ejercicio2;

public class Main {
    public static void main(String[] args) {
        MemoryPeliculaDAO filmin = new MemoryPeliculaDAO();

        PeliculaTO p1 = new PeliculaTO("blade runner");
        p1.addDirector("nnefjwsnfjks");
        p1.addActor("The rock","caillou");

        PeliculaTO p2 = new PeliculaTO("movie 42");
        p2.addDirector("Studio 26");
        p2.addActor("Super Mario","Chris Pratt");

        PeliculaTO p3 = new PeliculaTO("family guy");
        p3.addDirector("nnefjwsnfjks");
        p3.addActor("Peter Griffin","sadewd");

        PeliculaTO p4 = new PeliculaTO("jesucristo super star");
        p4.addDirector("nnefjwsnfjks");
        p4.addActor("sdfsdfdsf","dfewgertgf");

        filmin.addPelicula(p1);
        filmin.addPelicula(p2);
        filmin.addPelicula(p3);
        filmin.addPelicula(p4);

        System.out.println(filmin + "\n\n");

        System.out.println("Peliculas ordenadas con un stream:");
        filmin.getListaPeliculas().stream().sorted((f1,f2)->f1.getTitulo().compareTo(f2.getTitulo()))
                .forEach(System.out::println);
    }
}
