package sets.exercise;

public class BingoMain {
    public static void main(String[] args){
        Bombo bombo = new Bombo();
        bombo.initialize();
        bombo.shuffle();
        for (int i = 0; i < 5; i++) {
            System.out.println(bombo.removeBola());
        }
        System.out.println(bombo);
    }
}
