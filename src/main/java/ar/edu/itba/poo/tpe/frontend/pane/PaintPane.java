package ar.edu.itba.poo.tpe.frontend.pane;

import ar.edu.itba.poo.tpe.backend.CanvasState;
import javafx.scene.layout.BorderPane;

public class PaintPane extends BorderPane {

    CanvasState canvasState;

    CanvasPane canvasPane;
    ToolsPane toolsPane;
    StatusPane statusPane;

    public PaintPane(CanvasState canvasState) {
        this.canvasState = canvasState;

        statusPane = new StatusPane();
        canvasPane = new CanvasPane(canvasState);

        toolsPane = new ToolsPane(canvasPane);

        setRight(canvasPane);
        setLeft(toolsPane);
        setBottom(statusPane);
    }

}
