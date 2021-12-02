package ar.edu.itba.poo.tpe.frontend.drawable;

import ar.edu.itba.poo.tpe.backend.model.Point;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class DrawableFigure {
    private double stroke;
    private Color fill;

    public DrawableFigure(double stroke, Color fill){
        this.stroke=stroke;
        this.fill=fill;
    }

    public void drawFigure(GraphicsContext gc){
        fillFigure(gc);
        strokeFigure(gc);
    }

    public  void setFill(Color fill){
        this.fill=fill;
    }

    public void setStroke(double stroke){
        this.stroke=stroke;
    }

    public abstract void fillFigure(GraphicsContext gc);

    public abstract void strokeFigure(GraphicsContext gc);

    public abstract boolean pointBelongs(Point point);

    public abstract void moveFigure(double deltaX, double deltaY);

}