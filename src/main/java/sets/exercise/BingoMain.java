package sets.exercise;

public class BingoMain {
    public static void main(String[] args){
        Bombo bombo = new Bombo();
        bombo.initialize();
        bombo.shuffle();
        for (int i = 0; i < 5; i++) {
            System.out.println(bombo.getBola());
        }
        System.out.println(bombo);

        Tablero tablero = new Tablero();
        for (int i = 99; i > 0 ; i--) { // Da igual el orden de inserción porque se ordena según el compareTo
            tablero.addBola(new Bola(i));
        }
        System.out.println(tablero);
    }
}
