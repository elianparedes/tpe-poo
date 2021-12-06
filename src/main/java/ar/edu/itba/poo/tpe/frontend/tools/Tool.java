package ar.edu.itba.poo.tpe.frontend.tools;

import ar.edu.itba.poo.tpe.frontend.pane.CanvasPane;
import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

public abstract class Tool {

    protected final CanvasPane canvasPane;
    protected final GraphicsContext graphicsContext;

    public Tool(CanvasPane canvasPane) {
        this.canvasPane = canvasPane;
        this.graphicsContext = canvasPane.getGraphicsContext();
    }

    public void action(){
        canvasPane.setOnMouseDragged(onMouseDragged());
        canvasPane.setOnMousePressed(onMousePressed());
        canvasPane.setOnMouseReleased(onMouseReleased());
    }

    abstract EventHandler<MouseEvent> onMousePressed();
    abstract EventHandler<MouseEvent> onMouseDragged();
    abstract EventHandler<MouseEvent> onMouseReleased();
}
