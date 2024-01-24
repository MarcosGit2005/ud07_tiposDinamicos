package es.ieslavereda;

public class Lista {
    private Nodo cabeza;
    private Nodo cola;
    private int tamaño;
    public Lista(){
        cabeza=null;
        cola=null;
        tamaño=0;
    }
    public int size(){
        return tamaño;
    }
    public void addHead(int elem){
        Nodo nodo = new Nodo(elem);
        if (tamaño==0)
            cola=nodo;
        else
            nodo.setSiguiente(cabeza);

        cabeza = nodo;
        tamaño++;
    }
    public void addTail(int elem){
        Nodo nodo = new Nodo(elem);
        if (tamaño==0)
            cabeza=nodo;
        else{
            Nodo nodoAux = cabeza;
            while (nodoAux.getSiguiente()!=null){
                nodoAux = nodoAux.getSiguiente();
            }
            nodoAux.setSiguiente(nodo);
        }
        cola = nodo;
        tamaño++;
    }
    @Override
    public String toString(){
        Nodo nodoAux = cabeza;
        String cadena = "Lista con "+tamaño+" elementos: ";
        while (nodoAux!=null){
            cadena += nodoAux.toString()+" -> ";
            nodoAux = nodoAux.getSiguiente();
        }
        return cadena.substring(0,cadena.length()-4);
    }
    private class Nodo{
        private int elem;
        private Nodo siguiente;
        public Nodo(int elem){
            this.elem=elem;
        }
        public int getElem(){
            return elem;
        }
        public Nodo getSiguiente(){
            return siguiente;
        }
        public void setSiguiente(Nodo siguiente){
            this.siguiente=siguiente;
        }
        @Override
        public String toString(){
            return String.valueOf(elem);
        }
    }
}
