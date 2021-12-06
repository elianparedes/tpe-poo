package ar.edu.itba.poo.tpe.frontend.pane;

import ar.edu.itba.poo.tpe.backend.CanvasState;
import javafx.scene.layout.BorderPane;

public class PaintPane extends BorderPane {

    CanvasState canvasState;

    CanvasPane canvasPane;
    ToolsPane sidePane;
    StatusPane statusPane;

    public PaintPane(CanvasState canvasState) {
        this.canvasState = canvasState;

        statusPane = new StatusPane();
        canvasPane = new CanvasPane(canvasState, statusPane);
        sidePane = new ToolsPane(canvasPane, statusPane);

        setRight(canvasPane);
        setLeft(sidePane);
        setBottom(statusPane);
    }

}
