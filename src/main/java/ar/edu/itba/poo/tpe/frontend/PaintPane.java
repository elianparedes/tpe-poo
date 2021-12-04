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

    public PaintPane() {
        statusPane = new StatusPane();
        canvasPane = new CanvasPane();

        /*canvasPane.setOnMouseMoved(e ->{
        CanvasState canvasState = canvasPane.getCanvasState();
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
        });*/

        toolsPane = new ToolsPane(canvasPane);

        setRight(canvasPane);
        setLeft(toolsPane);
        setBottom(statusPane);
    }

}
