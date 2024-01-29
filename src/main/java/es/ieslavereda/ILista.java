package es.ieslavereda;

public interface ILista<E> {
    int INITIAL_SIZE=0; // solo puede ser public static final (se supone por defecto)
    void addHead(E elem); // solo puede ser public abstract (se supone por defecto)
    E removeHead();
    int size();
}
