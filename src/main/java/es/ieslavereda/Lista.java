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
    public Lista(int[] elements){
        this();
        addAll(elements);
    }
    public int[] getAsArray(){
        int[] array = new int[size()];
        Nodo aux=cabeza;
        for (int i = 0; i < size(); i++) {
            array[i] = aux.getElem();
            aux=aux.getSiguiente();
        }
        return array;
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
        if (size()==0)
            cabeza=nodo;
        else
            cola.setSiguiente(nodo);

        cola = nodo;
        tamaño++;
    }
    public Integer removeHead(){
        if (size()==0)
            return null;
        int elem = cabeza.getElem();
        cabeza=cabeza.getSiguiente();
        tamaño--;
        
        if (cabeza==null)
            cola=null;
        return elem;
    }
    public Integer removeTail(){
        if(size()==0)
            return null;
        if (size()==1)
            return removeHead();
        int elem = cola.getElem();
        Nodo nodoAux = cabeza;
        for (int i=0;i<size()-1;i++){
            nodoAux = nodoAux.getSiguiente();
        }
        cola=nodoAux;
        cola.setSiguiente(null);
        tamaño--;
        
        return elem;
    }
    public void clear(){
        tamaño=0;
        cabeza=null;
        cola=null;
    }
    public boolean contains(int elem){
        Nodo nodoParam = new Nodo(elem);
        Nodo nodoAux = cabeza;

        for (int i = 0; i < size(); i++) {
            if (nodoParam.equals(nodoAux))
                return true;
            nodoAux = nodoAux.getSiguiente();
        }
        return false;
    }
    public Integer get(int posición){
        if (posición<0 || posición>=size())
            return null;
        Nodo nodoAux = cabeza;
        for (int i = 0; i < posición; i++) {
            nodoAux = nodoAux.getSiguiente();
        }
        return nodoAux.getElem();
    }
    public Integer remove(int posición){
        if (posición<0 || posición>=size())
            return null;
        if (posición==0)
            return removeHead();
        if (posición==size()-1)
            return removeTail();
        int elemBorrado;
        Nodo nodoAux = cabeza;
        for (int i = 0; i < posición-1; i++) {
            nodoAux = nodoAux.getSiguiente();
        }
        elemBorrado=nodoAux.getSiguiente().getElem();
        nodoAux.setSiguiente(nodoAux.getSiguiente().getSiguiente());
        tamaño--;
        return elemBorrado;
    }
    public void addAll(int[] elements){
        for (int element:elements)
            addTail(element);
    }
    @Override
    public String toString(){
        Nodo nodoAux = cabeza;
        String cadena = "Lista con "+tamaño+" elementos: ";
        for (int i=0;i<size();i++){
            cadena += nodoAux.toString()+" -> ";
            nodoAux = nodoAux.getSiguiente();
        }
        return cadena.substring(0,size()>0?cadena.length()-4:cadena.length()-2); // Si size>1 la cadena tiene " -> " al final
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
        @Override
        public boolean equals(Object object){
            if(object==null)
                return false;
            if(!(object instanceof Nodo))
                return false;
            Nodo nodo = (Nodo) object;
            return getElem()==nodo.getElem();
        }
    }
}
