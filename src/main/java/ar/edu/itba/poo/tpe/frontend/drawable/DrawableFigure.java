package ar.edu.itba.poo.tpe.frontend.drawable;

import ar.edu.itba.poo.tpe.backend.model.Figure;
import ar.edu.itba.poo.tpe.backend.model.Point;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class DrawableFigure {
    private Color stroke;
    private double lineWidth;
    private Figure figure;

    public DrawableFigure(Figure figure, Color stroke, double lineWidth){
        this.figure=figure;
        this.stroke=stroke;
        this.lineWidth=lineWidth;
    }

    public void drawFigure(GraphicsContext gc){
        setGraphicsContext(gc);
        strokeFigure(gc);
    }

    protected void setGraphicsContext(GraphicsContext gc){
        gc.setStroke(stroke);
        gc.setLineWidth(lineWidth);
    }

    public Color getStroke(){return this.stroke;}

    public Figure getFigure() {
        return figure;
    }

    public void setStroke(Color stroke){

        this.stroke=stroke;
    }

    public void setLineWidth(double lineWidth){
        this.lineWidth=lineWidth;
    }
    public abstract boolean hasFill();

    public abstract void strokeFigure(GraphicsContext gc);

    public abstract boolean pointBelongs(Point point);

    public abstract void moveFigure(double deltaX, double deltaY);

}