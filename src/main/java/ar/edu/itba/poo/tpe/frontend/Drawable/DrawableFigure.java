package ar.edu.itba.poo.tpe.frontend.Drawable;

import javafx.scene.canvas.GraphicsContext;

public interface DrawableFigure {
    default void drawFigure(GraphicsContext gc){
        fillFigure(gc);
        strokeFigure(gc);
    }
    void fillFigure(GraphicsContext gc);
    void strokeFigure(GraphicsContext gc);
}