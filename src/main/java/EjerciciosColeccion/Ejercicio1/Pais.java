package EjerciciosColeccion.Ejercicio1;

public class Pais implements Comparable<Pais>{
    private String nombre;
    private int numHabitantes;
    public Pais(String nombre,int numHabitantes){
        this.nombre=nombre;
        this.numHabitantes=numHabitantes;
    }
    public String getNombre(){
        return nombre;
    }
    public int getNumHabitantes(){
        return numHabitantes;
    }
    @Override
    public String toString(){
        return "[nombre: " + nombre + ", numHabitantes: " + numHabitantes + "]";
    }
    @Override
    public int compareTo(Pais pais){
        return nombre.compareTo(pais.getNombre());
    }
    @Override
    public boolean equals(Object object){
        if (object==null)
            return false;
        if (!(object instanceof Pais))
            return false;
        Pais pais = (Pais) object;
        return nombre.equals(pais.getNombre());
    }
    @Override
    public int hashCode(){
        return nombre.hashCode();
    }
}
