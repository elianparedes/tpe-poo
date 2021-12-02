package ar.edu.itba.poo.tpe.backend.model;

public abstract class Figure {
    public abstract boolean pointBelongs(Point point);
    public abstract void moveFigure(double deltaX, double deltaY);
}
