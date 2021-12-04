package ar.edu.itba.poo.tpe.backend.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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
    public Set<Point> getOutsidePoints() {
        Set<Point> outsidePoints = new HashSet<>();
        outsidePoints.add(topLeft);
        outsidePoints.add(bottomRight);
        return outsidePoints;
    }

    @Override
    public String toString() {
        return String.format("Rectángulo: [ %s , %s ]", topLeft, bottomRight);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return false;
        if(!(obj instanceof Rectangle that))
            return false;
        return (this.bottomRight.equals( that.bottomRight)) &&
                    (this.topLeft.equals(that.topLeft));
    }

    @Override
    public int hashCode() {
        return Objects.hash(bottomRight,topLeft);
    }

}
