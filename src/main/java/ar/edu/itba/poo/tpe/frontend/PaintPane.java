package ar.edu.itba.poo.tpe.frontend;

import ar.edu.itba.poo.tpe.backend.model.Point;
import ar.edu.itba.poo.tpe.frontend.drawable.DrawableFigure;
import ar.edu.itba.poo.tpe.frontend.tools.Tool;
import javafx.scene.layout.BorderPane;

//TODO: Colocar las funcionalidades de dibujo dentro del CanvasPane.

public class PaintPane extends BorderPane {

    CanvasPane canvasPane;
    ToolsPane toolsPane;

    StatusPane statusPane;

    public PaintPane(StatusPane statusPane) {
        this.statusPane = statusPane;

        canvasPane = new CanvasPane();
        toolsPane = new ToolsPane(canvasPane);

        setRight(canvasPane);
        setLeft(toolsPane);
    }

}
