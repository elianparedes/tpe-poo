package ar.edu.itba.poo.tpe.frontend.tools;

import ar.edu.itba.poo.tpe.frontend.CanvasPane;
import ar.edu.itba.poo.tpe.frontend.CanvasState;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public abstract class Tool {

    CanvasPane canvasPane;

    public void action(CanvasPane canvasPane){
        this.canvasPane = canvasPane;
        canvasPane.setOnMouseDragged(onMouseDragged());
        canvasPane.setOnMousePressed(onMousePressed());
        canvasPane.setOnMouseReleased(onMouseReleased());
    }

    abstract EventHandler<MouseEvent> onMousePressed();
    abstract EventHandler<MouseEvent> onMouseDragged();
    abstract EventHandler<MouseEvent> onMouseReleased();
}
