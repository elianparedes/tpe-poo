package ar.edu.itba.poo.tpe.backend.model;

import java.util.Objects;

/**
 * Clase que modela un punto en el eje cartesiano
 */
public class Point {

    private double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    //***********************
    //  Getters
    //***********************
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void movePoint(double deltaX, double deltaY){
        this.x += deltaX;
        this.y += deltaY;
    }

    public double distance(Point point){
        return Math.abs(Math.sqrt((x - point.x)*(x-point.x) + (y - point.y)*(y - point.y)));
    }

    public boolean isLower(Point point){
        return x < point.getX() && y < point.getY();
    }

    @Override
    public String toString() {
        return String.format("{%.2f , %.2f}", x, y);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return false;
        if(!(obj instanceof Point that))
            return false;
        return (this.x ==that.x) &&
                (this.y == that.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x,y);
    }

}
