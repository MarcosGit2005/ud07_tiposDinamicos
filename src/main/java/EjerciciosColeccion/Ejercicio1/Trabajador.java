package EjerciciosColeccion.Ejercicio1;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;

public class Trabajador implements Comparable<Trabajador>{
    private String DNI;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    public Trabajador(String DNI,String nombre,String apellido,LocalDate fechaNacimiento){
        this.DNI=DNI;
        this.nombre=nombre;
        this.apellido=apellido;
        this.fechaNacimiento=fechaNacimiento;
    }
    public String getNombre(){
        return nombre;
    }
    public String getApellido(){
        return apellido;
    }
    public String getDNI(){
        return DNI;
    }
    public long getEdad(){
        return ChronoUnit.YEARS.between(fechaNacimiento,LocalDate.now());
    }
    @Override
    public String toString(){
        return "[DNI:" + DNI + ", nombre: " + nombre + ", apellido: "
                + apellido + ", edad: " + getEdad() + "]";
    }
    @Override
    public int compareTo(Trabajador trabajador){
        if (apellido.equals(trabajador.getApellido()))
            return nombre.compareTo(trabajador.getNombre());
        return apellido.compareTo(trabajador.getApellido());
    }
    @Override
    public boolean equals(Object object){
        if (object==null)
            return false;
        if (!(object instanceof Trabajador))
            return false;
        Trabajador trabajador = (Trabajador) object;
        return DNI.equals(trabajador.getDNI());
    }
    @Override
    public int hashCode(){
        return DNI.hashCode();
    }
}
