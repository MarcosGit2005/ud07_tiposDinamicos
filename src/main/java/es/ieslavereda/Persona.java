package es.ieslavereda;

import java.time.LocalDate;
import java.util.Comparator;

public class Persona implements Comparable<Persona>{
    public static final Comparator<Persona> SORT_BY_AGE = new Comparator<Persona>() {
        @Override
        public int compare(Persona persona, Persona persona2) {
            return persona.getFechaNacimiento().compareTo(persona2.getFechaNacimiento());
        }
    };
    private String DNI;
    private String nombre;
    private String apellidos;
    private LocalDate fechaNacimiento;
    public Persona(String DNI, String nombre, String apellidos, LocalDate edad){
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = edad;
    }
    public String getDNI(){
        return DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(LocalDate edad){
        this.fechaNacimiento = edad;
    }
    public void printDNI(){
        System.out.println("Desde Persona imprimo el DNI: " + DNI);
    }
    @Override
    public String toString(){
        return "[DNI: " + DNI + ", nombre: " + nombre + ", apellidos: " + apellidos + ", edad: " + fechaNacimiento + "]";
    }
    @Override
    public boolean equals(Object obj){
        if (obj==null)
            return false;
        if (!(obj instanceof Persona))
            return false;
        Persona persona = (Persona)obj;
        return DNI.equals(persona.DNI) && nombre.equals(persona.nombre) && apellidos.equals(persona.apellidos);
    }
    @Override
    public int compareTo(Persona persona){
        if (persona==null)
            return 0;

        if (!getApellidos().equals(persona.getApellidos()))
            return getApellidos().compareTo(persona.getApellidos());
        if (!getNombre().equals(persona.getNombre()))
            return getNombre().compareTo(persona.getNombre());
        return 0;
    }
    @Override
    public int hashCode(){
        return nombre.hashCode() + apellidos.hashCode();
    }
}
