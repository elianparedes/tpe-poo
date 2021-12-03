package ar.edu.itba.poo.tpe.backend.model;

import java.util.Set;

public abstract class Figure {
    public abstract boolean pointBelongs(Point point);
    public abstract void moveFigure(double deltaX, double deltaY);
    public abstract Set<Point> getOutsidePoints();

    public boolean containsFigure(Figure figure){
        if(figure == null)
            return false;
        for (Point point : figure.getOutsidePoints()) {
            if(!(this.pointBelongs(point)))
                return false;
        }
        return true;
    }
}
