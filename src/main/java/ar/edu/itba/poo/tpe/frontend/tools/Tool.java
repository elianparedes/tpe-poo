package ar.edu.itba.poo.tpe.frontend.tools;

import ar.edu.itba.poo.tpe.frontend.pane.CanvasPane;
import ar.edu.itba.poo.tpe.frontend.pane.StatusPane;
import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

/**
 * Tool administra el comportamiento que debe tener el mouse en relación a la funcionalidad
 * de la herramienta
 */
public abstract class Tool {

    protected final CanvasPane canvasPane;
    protected final GraphicsContext graphicsContext;
    protected final StatusPane statusPane;

    public Tool(CanvasPane canvasPane, StatusPane statusPane) {
        this.canvasPane = canvasPane;
        this.graphicsContext = canvasPane.getGraphicsContext();
        this.statusPane = statusPane;
    }

    /**
     * Asígna al canvasPane el comportamiento que debe tener el mouse
     */
    public void execute(){
        canvasPane.setOnMouseDragged(onMouseDragged());
        canvasPane.setOnMousePressed(onMousePressed());
        canvasPane.setOnMouseReleased(onMouseReleased());
    }

    /**
     * Setean el comportamiento que debe tener el mouse al utilizar la herramienta.
     * @return manejador de eventos que describe el funcionamiento del mouse.
     */
    abstract EventHandler<MouseEvent> onMousePressed();
    abstract EventHandler<MouseEvent> onMouseDragged();
    abstract EventHandler<MouseEvent> onMouseReleased();
}
