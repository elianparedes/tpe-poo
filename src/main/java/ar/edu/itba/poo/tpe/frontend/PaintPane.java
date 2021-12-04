package ar.edu.itba.poo.tpe.frontend;

import ar.edu.itba.poo.tpe.backend.model.Point;
import ar.edu.itba.poo.tpe.frontend.drawable.DrawableFigure;
import ar.edu.itba.poo.tpe.frontend.tools.Tool;
import javafx.scene.layout.BorderPane;

//TODO: Colocar las funcionalidades de dibujo dentro del CanvasPane.

public class PaintPane extends BorderPane {

    CanvasPane canvasPane;
    CanvasState canvasState;

    ToolsPane toolsPane;

    StatusPane statusPane;

    public PaintPane(StatusPane statusPane) {
        this.statusPane = statusPane;
        canvasPane = new CanvasPane();

        canvasState = canvasPane.getCanvasState();

        canvasPane.setOnMouseMoved(e ->{
            Point point = new Point(e.getX() , e.getY());
            StringBuilder stringBuilder = new StringBuilder();
            statusPane.updateStatus(point.toString());
            for (DrawableFigure figure: canvasState.figures()) {
                if(figure.pointBelongs(point)){
                    stringBuilder.append(figure.getFigure().toString());
                    statusPane.updateStatus(stringBuilder.toString());
                }
            }
        });

        toolsPane = new ToolsPane(canvasPane);

        setRight(canvasPane);
        setLeft(toolsPane);
    }

}
