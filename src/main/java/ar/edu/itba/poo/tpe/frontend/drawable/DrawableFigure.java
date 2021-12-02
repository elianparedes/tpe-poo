package ar.edu.itba.poo.tpe.frontend.drawable;

import ar.edu.itba.poo.tpe.backend.model.Point;
import javafx.scene.canvas.GraphicsContext;

public interface DrawableFigure {

    default void draw(GraphicsContext graphicsContext){
        setFill(graphicsContext);
        setStroke(graphicsContext);
    }

    void setFill(GraphicsContext graphicsContext);

    void setStroke(GraphicsContext graphicsContext);

    boolean pointBelongs(Point point);

}