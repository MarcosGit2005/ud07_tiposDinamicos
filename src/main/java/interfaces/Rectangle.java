package interfaces;

public class Rectangle implements IFigura,Relatable{
    private double height;
    private double width;
    public Rectangle(double height,double width){
        this.height=height;
        this.width=width;
    }
    @Override
    public Double area(){
        return height*width;
    }
    @Override
    public Double perimetro(){
        return height*2 + width*2;
    }
    @Override
    public boolean isLargerThan(Relatable relatable){
        if (!(relatable instanceof Rectangle)) // tambien mira si es null
            return false;
        Rectangle rectangle = (Rectangle) relatable;
        return area()>=rectangle.area();
    }
}
