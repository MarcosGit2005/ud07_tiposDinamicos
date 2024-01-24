package es.ieslavereda;

public class List {
    private Node head;
    private Node tail;
    private int size;
    public List(){
        head=null;
        tail=null;
        size=0;
    }
    public List(int[] elements){
        this();
        addAll(elements);
    }
    public int[] getAsArray(){
        int[] array = new int[size()];
        Node aux=head;
        for (int i = 0; i < size(); i++) {
            array[i] = aux.getElem();
            aux=aux.getNext();
        }
        return array;
    }
    public int size(){
        return size;
    }
    public void addHead(int element){
        Node node = new Node(element);
        if (size()==0)
            tail=node;
        else
            node.setNext(head);

        head = node;
        size++;
    }
    public void addTail(int element){
        Node node = new Node(element);
        if (size()==0)
            head=node;
        else
            tail.setNext(node);

        tail = node;
        size++;
    }
    public Integer removeHead(){
        if (size()==0)
            return null;
        int elem = head.getElem();
        head=head.getNext();
        size--;
        
        if (head==null)
            tail=null;
        return elem;
    }
    public Integer removeTail(){
        if(size()==0)
            return null;
        if (size()==1)
            return removeHead();
        int elem = tail.getElem();
        Node nodeAux = head;
        for (int i=0;i<size()-1;i++){
            nodeAux = nodeAux.getNext();
        }
        tail=nodeAux;
        tail.setNext(null);
        size--;
        
        return elem;
    }
    public void clear(){
        size=0;
        head=null;
        tail=null;
    }
    public boolean contains(int element){
        Node nodeParam = new Node(element);
        Node nodeAux = head;

        for (int i = 0; i < size(); i++) {
            if (nodeParam.equals(nodeAux))
                return true;
            nodeAux = nodeAux.getNext();
        }
        return false;
    }
    public Integer get(int position){
        if (position<0 || position>=size())
            return null;
        Node nodeAux = head;
        for (int i = 0; i < position; i++) {
            nodeAux = nodeAux.getNext();
        }
        return nodeAux.getElem();
    }
    public Integer remove(int position){
        if (position<0 || position>=size())
            return null;
        if (position==0)
            return removeHead();
        if (position==size()-1)
            return removeTail();

        Node nodeAux = head;
        for (int i = 0; i < position-1; i++) {
            nodeAux = nodeAux.getNext();
        }
        int elemRemoved = nodeAux.getNext().getElem();
        nodeAux.setNext(nodeAux.getNext().getNext());
        size--;
        return elemRemoved;
    }
    public void addAll(int[] elements){
        for (int element:elements)
            addTail(element);
    }
    @Override
    public String toString(){
        Node nodeAux = head;
        String chain = "List with "+size+" elements: ";
        for (int i=0;i<size();i++){
            chain += nodeAux.toString()+" -> ";
            nodeAux = nodeAux.getNext();
        }
        return chain.substring(0,size()>0?chain.length()-4:chain.length()-2); // if size>1 the chain has " -> " at the end
    }
    private class Node{
        private int elem;
        private Node next;
        public Node(int elem){
            this.elem=elem;
        }
        public int getElem(){
            return elem;
        }
        public Node getNext(){
            return next;
        }
        public void setNext(Node next){
            this.next=next;
        }
        @Override
        public String toString(){
            return String.valueOf(elem);
        }
        @Override
        public boolean equals(Object object){
            if(object==null)
                return false;
            if(!(object instanceof Node))
                return false;
            Node node = (Node) object;
            return getElem()==node.getElem();
        }
    }
}
