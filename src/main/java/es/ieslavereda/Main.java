package es.ieslavereda;

public class Main {
    public static void main(String[] args) {
        Lista listaEnteros = new Lista();
        listaEnteros.addHead(4);
        listaEnteros.addHead(7);
        listaEnteros.addHead(5);
        listaEnteros.addHead(9);
        listaEnteros.addTail(9);

        System.out.println(listaEnteros);
    }
}