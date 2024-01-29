package es.ieslavereda;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ListDE<String> listIntegers = new ListDE<>();
        listIntegers.addHead("4");
        listIntegers.addHead("7");
        listIntegers.addHead("4");
        listIntegers.addHead("7");
        listIntegers.addHead("5");
        listIntegers.addTail("9");
        listIntegers.addHead("5");
        listIntegers.addTail("8");

        System.out.println(listIntegers);
        System.out.println("Last element in the list: " + listIntegers.get(listIntegers.size()-1));

        listIntegers.removeHead();
        listIntegers.removeTail();

        System.out.println(listIntegers);

        listIntegers.clear();

        System.out.println(listIntegers);

        ListDE<Integer> list2 = new ListDE<>();
        list2.addHead(6);
        list2.addHead(6);
        list2.addHead(6);
        list2.addHead(6);
        list2.remove(2);
        System.out.println(list2);
        System.out.println(Arrays.toString(list2.getAsArray(Integer.class)));
        }
}