package ar.edu.itba.poo.tpe.frontend;

import javafx.scene.layout.BorderPane;

//TODO: Colocar las funcionalidades de dibujo dentro del CanvasPane.

public class PaintPane extends BorderPane {

    CanvasState canvasState;

    CanvasPane canvasPane;
    ToolsPane toolsPane;

    StatusPane statusPane;

    public PaintPane(CanvasState canvasState, StatusPane statusPane) {
        this.canvasState = canvasState;
        this.statusPane = statusPane;

        canvasPane = new CanvasPane(canvasState);
        toolsPane = new ToolsPane();

        toolsPane.setToolsListener(canvasPane);

        setRight(canvasPane);
        setLeft(toolsPane);
    }

}
