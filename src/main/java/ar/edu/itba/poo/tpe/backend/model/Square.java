package ar.edu.itba.poo.tpe.backend.model;

public class Square extends Rectangle{
    private double side;

    public Square(Point topLeft, double side){
        super(topLeft, new Point(topLeft.getX()+side,topLeft.getY()+side));
        this.side=side;
    }

    @Override
    public String toString() {
        return String.format("Cuadrado: [ %s , %s ]", getTopLeft(), getBottomRight());
    }
}
