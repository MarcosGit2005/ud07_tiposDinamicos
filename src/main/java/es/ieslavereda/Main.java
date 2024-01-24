package es.ieslavereda;

public class Main {
    public static void main(String[] args) {
        Lista listaEnteros = new Lista();
        listaEnteros.addHead(4);
        listaEnteros.addHead(7);
        listaEnteros.addHead(4);
        listaEnteros.addHead(7);
        listaEnteros.addHead(5);
        listaEnteros.addTail(9);
        listaEnteros.addHead(5);
        listaEnteros.addTail(8);

        System.out.println(listaEnteros);
        System.out.println("Último elemento de la lista: " + listaEnteros.get(listaEnteros.size()-1));
        System.out.println("La lista de enteros contiene el número 9?: " + listaEnteros.contains(9));

        listaEnteros.removeHead();
        listaEnteros.removeTail();

        System.out.println(listaEnteros);
        System.out.println("La lista de enteros contiene el número 9?: " + listaEnteros.contains(9));

        listaEnteros.clear();

        System.out.println(listaEnteros);
        System.out.println("La lista de enteros contiene el número 9?: " + listaEnteros.contains(9));

        Lista listaUnElem = new Lista();
        listaUnElem.addHead(6);
        listaUnElem.addHead(6);
        listaUnElem.addHead(6);
        listaUnElem.addHead(6);
        listaUnElem.remove(2);
        System.out.println(listaUnElem);
        }
}