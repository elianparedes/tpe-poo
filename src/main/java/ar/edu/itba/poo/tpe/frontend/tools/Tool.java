package ar.edu.itba.poo.tpe.frontend.tools;

import ar.edu.itba.poo.tpe.frontend.pane.CanvasPane;
import ar.edu.itba.poo.tpe.frontend.pane.StatusPane;
import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

public abstract class Tool {

    protected final CanvasPane canvasPane;
    protected final GraphicsContext graphicsContext;
    protected final StatusPane statusPane;

    public Tool(CanvasPane canvasPane, StatusPane statusPane) {
        this.canvasPane = canvasPane;
        this.graphicsContext = canvasPane.getGraphicsContext();
        this.statusPane = statusPane;
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
