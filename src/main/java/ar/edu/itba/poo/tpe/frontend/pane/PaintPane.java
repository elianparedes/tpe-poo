package ar.edu.itba.poo.tpe.frontend.pane;

import ar.edu.itba.poo.tpe.backend.CanvasState;
import javafx.scene.layout.BorderPane;

/**
 * Panel del área de trabajo principal del editor de figuras
 */
public class PaintPane extends BorderPane {

    CanvasState canvasState;

    CanvasPane canvasPane;
    ToolsPane toolsPane;
    StatusPane statusPane;

    public PaintPane(CanvasState canvasState) {
        this.canvasState = canvasState;

        statusPane = new StatusPane();
        canvasPane = new CanvasPane(canvasState, statusPane);
        toolsPane = new ToolsPane(canvasPane, statusPane);

        setRight(canvasPane);
        setLeft(toolsPane);
        setBottom(statusPane);
    }

}
