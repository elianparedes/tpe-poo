package ar.edu.itba.poo.tpe.frontend;

import ar.edu.itba.poo.tpe.backend.model.Point;
import ar.edu.itba.poo.tpe.frontend.drawable.DrawableFigure;
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

        toolsPane = new ToolsPane();

        toolsPane.setToolsListener(canvasPane);

        setRight(canvasPane);
        setLeft(toolsPane);
    }

}
