package sets.exercise;

public class Bola implements Comparable<Bola>{
    private int num;
    public Bola(int num){
        this.num=num;
    }
    public int getNum(){
        return num;
    }
    @Override
    public String toString(){
        return String.valueOf(num);
    }
    @Override
    public int hashCode(){
        return num;
    } // como no se repiten vale num
    @Override
    public boolean equals(Object object){
        if (object==null)
            return false;
        if(!(object instanceof Bola))
            return false;
        Bola bola = (Bola) object;
        return getNum()==bola.getNum();
    }
    @Override
    public int compareTo(Bola bola){
        return getNum() - bola.getNum(); // Solo mira si es positivo, negativo o cero
    }
}
