package ar.edu.itba.poo.tpe.backend.model.drawable;

import ar.edu.itba.poo.tpe.backend.model.Figure;
import ar.edu.itba.poo.tpe.backend.model.Point;

public abstract class DrawableFigure {

    private final Figure figure;
    private double strokeWidth;
    private String strokeColor;

    protected DrawingFunction drawingFunction;

    public DrawableFigure(Figure figure, String stroke, double lineWidth) {
        this.figure = figure;
        this.strokeColor = stroke;
        this.strokeWidth = lineWidth;
    }

    public void drawFigure() {
        if (drawingFunction == null)
            throw new RuntimeException("No DrawableFunction defined");
        drawingFunction.draw();
    }

    public String getStrokeColor() {
        return strokeColor;
    }

    public double getStrokeWidth(){
        return strokeWidth;
    }

    public Figure getFigure() {
        return figure;
    }

    public void setStrokeColor(String color) {
        this.strokeColor = color;
    }

    public void setStrokeWidth(double strokeWidth) {
        this.strokeWidth = strokeWidth;
    }

    public abstract boolean hasFill();

    public abstract boolean pointBelongs(Point point);

    public abstract void moveFigure(double deltaX, double deltaY);

    public void setDrawingFunction(DrawingFunction drawingFunction){
        this.drawingFunction = drawingFunction;
    }

}