package ar.edu.itba.poo.tpe.frontend.drawable;

import ar.edu.itba.poo.tpe.backend.model.Point;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class DrawableFigure {
    private Color stroke, fill;
    private double lineWidth;

    public DrawableFigure(Color stroke, Color fill, double lineWidth){
        this.stroke=stroke;
        this.fill=fill;
        this.lineWidth=lineWidth;
    }

    public void drawFigure(GraphicsContext gc){
        fillFigure(gc);
        strokeFigure(gc);
    }

    protected void setGraphicsContext(GraphicsContext gc){
        gc.setStroke(stroke);
        gc.setFill(fill);
        gc.setLineWidth(lineWidth);
    }

    public void setFill(Color fill){
        this.fill=fill;
    }

    public void setStroke(Color stroke){
        this.stroke=stroke;
    }

    public void setLineWidth(double lineWidth){
        this.lineWidth=lineWidth;
    }

    public abstract void fillFigure(GraphicsContext gc);

    public abstract void strokeFigure(GraphicsContext gc);

    public abstract boolean pointBelongs(Point point);

    public abstract void moveFigure(double deltaX, double deltaY);

}