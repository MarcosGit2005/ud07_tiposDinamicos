package es.ieslavereda;

public class Main {
    public static void main(String[] args) {
        List listIntegers = new List();
        listIntegers.addHead(4);
        listIntegers.addHead(7);
        listIntegers.addHead(4);
        listIntegers.addHead(7);
        listIntegers.addHead(5);
        listIntegers.addTail(9);
        listIntegers.addHead(5);
        listIntegers.addTail(8);

        System.out.println(listIntegers);
        System.out.println("Last element in the list: " + listIntegers.get(listIntegers.size()-1));
        System.out.println("The list of integers contains number 9?: " + listIntegers.contains(9));

        listIntegers.removeHead();
        listIntegers.removeTail();

        System.out.println(listIntegers);
        System.out.println("The list of integers contains number 9?: " + listIntegers.contains(9));

        listIntegers.clear();

        System.out.println(listIntegers);
        System.out.println("The list of integers contains number 9?: " + listIntegers.contains(9));

        List list2 = new List();
        list2.addHead(6);
        list2.addHead(6);
        list2.addHead(6);
        list2.addHead(6);
        list2.remove(2);
        System.out.println(list2);
        }
}