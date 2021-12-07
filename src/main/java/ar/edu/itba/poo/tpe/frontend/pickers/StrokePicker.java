package ar.edu.itba.poo.tpe.frontend.pickers;

import ar.edu.itba.poo.tpe.frontend.pane.CanvasPane;
import ar.edu.itba.poo.tpe.frontend.pane.StatusPane;
import javafx.scene.paint.Color;

/**
 *  StrokePicker modela el comportamiento del picker de color de relleno
 */
public class StrokePicker extends Picker{

    public StrokePicker(CanvasPane canvasPane, StatusPane statusPane){
        super(canvasPane, statusPane);
    }

    @Override
    public void excecute(Color color) {
        canvasPane.startPreview(color);
        canvasPane.setSelectedStrokeColor(color);
        canvasPane.getCanvasState().setSelectedFiguresStrokeColor(color.toString());
        statusPane.updateStatusColor("Color de trazo", color);
    }
}
