package ar.edu.itba.poo.tpe.backend.model;

public class Point {

    public double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return String.format("{%.2f , %.2f}", x, y);
    }

    public void movePoint(double deltax, double deltay){
        this.x += deltax;
        this.y += deltay;
    }

    public double distance(Point point){
        return Math.abs(Math.sqrt((x - point.x)*(x-point.x) + (y - point.y)*(y - point.y)));
    }

}
