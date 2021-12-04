package ar.edu.itba.poo.tpe.backend.model;

import java.util.HashSet;
import java.util.Set;

public class Line extends Figure{
    private Point startPoint, endPoint;
    private double slope, intercept;
    private static final double EPSILON=0.1;

    public Line(Point startPoint, Point endPoint){
        this.startPoint=startPoint;
        this.endPoint=endPoint;
        calculateSlope();
        calculateIntercept();
    }

    public Point getStartPoint(){
        return startPoint;
    }

    public Point getEndPoint(){
        return endPoint;
    }

    private void calculateSlope(){
        slope = (endPoint.getY()-startPoint.getY())/(endPoint.getX()-startPoint.getX());
    }

    private void calculateIntercept(){
        intercept = startPoint.getY()-slope*startPoint.getX();
    }

    @Override
    public boolean pointBelongs(Point point) {
        return Math.abs(point.getY()-slope*point.getX()- intercept) <= EPSILON
                && point.getX() > startPoint.getX() && point.getX() < endPoint.getX();
    }

    @Override
    public void moveFigure(double deltaX, double deltaY) {
        startPoint.movePoint(deltaX, deltaY);
        endPoint.movePoint(deltaX, deltaY);
        calculateSlope();
        calculateIntercept();
    }

    @Override
    public Set<Point> getOutsidePoints() {
        Set<Point> outsidePoints = new HashSet<>();
        outsidePoints.add(startPoint);
        outsidePoints.add(endPoint);
        return outsidePoints;
    }

    @Override
    public String toString(){
        return String.format("Línea: [Inicio: %s, Fin: %s]", startPoint, endPoint);
    }

}
