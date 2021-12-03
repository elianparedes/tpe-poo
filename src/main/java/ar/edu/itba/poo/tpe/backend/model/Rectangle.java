package ar.edu.itba.poo.tpe.backend.model;

public class Rectangle extends Figure {

    private final Point topLeft, bottomRight;

    public Rectangle(Point topLeft, Point bottomRight) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }

    public Point getTopLeft() {
        return topLeft;
    }

    public Point getBottomRight() {
        return bottomRight;
    }

    @Override
    public boolean pointBelongs(Point point){
        return point.getX() > topLeft.getX() && point.getX() < bottomRight.getX() &&
                point.getY() < bottomRight.getY() && point.getY() > topLeft.getY();
    }

    @Override
    public void moveFigure(double deltaX, double deltaY){
        topLeft.movePoint(deltaX, deltaY);
        bottomRight.movePoint(deltaX, deltaY);
    }

    @Override
    public String toString() {
        return String.format("Rectángulo: [ %s , %s ]", topLeft, bottomRight);
    }
}
