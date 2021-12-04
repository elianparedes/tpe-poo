package ar.edu.itba.poo.tpe.backend.model;

public class Square extends Rectangle{
    private double side;

    public Square(Point bottomLeft, double side){
        super(new Point (bottomLeft.getX(), bottomLeft.getY()), new Point(bottomLeft.getX()+side,bottomLeft.getY()+side));
        this.side=side;
    }

    @Override
    public String toString() {
        return String.format("Cuadrado: [ %s , %s ]", getTopLeft(), getBottomRight());
    }
}
