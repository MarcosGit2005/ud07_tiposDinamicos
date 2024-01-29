package es.ieslavereda;

import java.lang.reflect.Array;

public class ListGeneric<E> implements ILista<E>{
    private Node<E> head;
    private Node<E> tail;
    private int size;
    public ListGeneric(){
        head=null;
        tail=null;
        size=INITIAL_SIZE;
    }
    public ListGeneric(E[] elements){
        this();
        addAll(elements);
    }
    public E[] getAsArray(Class clazz){
        E[] array = (E[]) Array.newInstance(clazz,size());
        Node<E> aux=head;
        for (int i = 0; i < size(); i++) {
            array[i] = aux.getElem();
            aux=aux.getNext();
        }
        return array;
    }
    @Override
    public int size(){
        return size;
    }
    @Override
    public void addHead(E element){
        Node<E> node = new Node<>(element);
        if (size()==0)
            tail=node;
        else
            node.setNext(head);

        head = node;
        size++;
    }
    public void addTail(E element){
        Node<E> node = new Node<>(element);
        if (size()==0)
            head=node;
        else
            tail.setNext(node);

        tail = node;
        size++;
    }
    @Override
    public E removeHead(){
        if (size()==0)
            return null;
        E elem = head.getElem();
        head=head.getNext();
        size--;

        if (head==null)
            tail=null;
        return elem;
    }
    public E removeTail(){
        if(size()==0)
            return null;
        if (size()==1)
            return removeHead();
        E elem = tail.getElem();
        Node<E> nodeAux = head;
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
    public E get(int position){
        if (position<0 || position>=size())
            return null;
        Node<E> nodeAux = head;
        for (int i = 0; i < position; i++) {
            nodeAux = nodeAux.getNext();
        }
        return nodeAux.getElem();
    }
    public E remove(int position){
        if (position<0 || position>=size())
            return null;
        if (position==0)
            return removeHead();
        if (position==size()-1)
            return removeTail();

        Node<E> nodeAux = head;
        for (int i = 0; i < position-1; i++) {
            nodeAux = nodeAux.getNext();
        }
        E elemRemoved = nodeAux.getNext().getElem();
        nodeAux.setNext(nodeAux.getNext().getNext());
        size--;
        return elemRemoved;
    }
    public void addAll(E[] elements){
        for (E element:elements)
            addTail(element);
    }
    @Override
    public String toString(){
        Node<E> nodeAux = head;
        String chain = "List with "+size+" elements: ";
        for (int i=0;i<size();i++){
            chain += nodeAux.toString()+" -> ";
            nodeAux = nodeAux.getNext();
        }
        return chain.substring(0,size()>0?chain.length()-4:chain.length()-2); // if size>1 the chain has " -> " at the end
    }
    private class Node<E>{
        private E elem;
        private Node next;
        public Node(E elem){
            this.elem=elem;
        }
        public E getElem(){
            return elem;
        }
        public Node<E> getNext(){
            return next;
        }
        public void setNext(Node next){
            this.next=next;
        }
        @Override
        public String toString(){
            return elem.toString();
        }
    }
}
