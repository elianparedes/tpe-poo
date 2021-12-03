package ar.edu.itba.poo.tpe.backend.model;

public class Line {
    private Point startPoint, endPoint;

    public Line(Point startPoint, Point endPoint){
        this.startPoint=startPoint;
        this.endPoint=endPoint;
    }

    @Override
    public String toString(){
        return String.format("Línea: [Inicio: %s, Fin: %s]", startPoint, endPoint);
    }

}
