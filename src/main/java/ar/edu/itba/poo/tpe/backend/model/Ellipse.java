package ar.edu.itba.poo.tpe.backend.model;

import java.util.HashSet;
import java.util.Set;

public class Ellipse extends Figure{
    private Point centerPoint;
    private final double sHorizontalAxis;
    private final double sVerticalAxis;

    public Ellipse(Point centerPoint, double sHorizontalAxis, double sVerticalAxis){
        this.centerPoint=centerPoint;
        this.sHorizontalAxis=sHorizontalAxis;
        this.sVerticalAxis=sVerticalAxis;
    }

    public Point getCenterPoint() {
        return centerPoint;
    }

    public double getsHorizontalAxis() {
        return sHorizontalAxis;
    }

    public double getsVerticalAxis() {
        return sVerticalAxis;
    }

    private double evaluate(Point point){
        if (sHorizontalAxis > sVerticalAxis){
            return Math.pow((point.getX()-centerPoint.getX())/sHorizontalAxis,2) + Math.pow((point.getY()-centerPoint.getY())/sVerticalAxis,2);
        }
        else{
            return Math.pow((point.getX()-centerPoint.getX())/sVerticalAxis,2) + Math.pow((point.getY()-centerPoint.getY())/sHorizontalAxis,2);
        }
    }

    @Override
    public boolean pointBelongs(Point point) {
        return evaluate(point) <= 1;
    }

    @Override
    public void moveFigure(double deltaX, double deltaY) {
        centerPoint.movePoint(deltaX, deltaY);
    }

    @Override
    public Set<Point> getOutsidePoints() {
        Set<Point> outsidePoints = new HashSet<>();
        Point topPoint = new Point(centerPoint.getX(), centerPoint.getY() + sVerticalAxis);
        outsidePoints.add(topPoint);

        Point bottomPoint = new Point(centerPoint.getX(), centerPoint.getY() - sVerticalAxis);
        outsidePoints.add(bottomPoint);

        Point  rightPoint = new Point(centerPoint.getX() + sHorizontalAxis, centerPoint.getY());
        outsidePoints.add(rightPoint);

        Point lefPoint = new Point(centerPoint.getX() - sHorizontalAxis, centerPoint.getY());
        outsidePoints.add(lefPoint);

        return outsidePoints;
    }

    @Override
    public String toString(){
        return String.format("Elipse [Centro: %s, DHoriz: %.2f, DVertical: %.2f]", centerPoint, sHorizontalAxis, sVerticalAxis);
    }
}
