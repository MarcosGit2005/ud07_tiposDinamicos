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
        for (int i = 0; i < 98; i++) {
            tablero.addBola(new Bola(i+1));
        }
        System.out.println(tablero);
    }
}
