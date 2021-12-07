package ar.edu.itba.poo.tpe.frontend.pickers;

import ar.edu.itba.poo.tpe.frontend.pane.CanvasPane;
import ar.edu.itba.poo.tpe.frontend.pane.StatusPane;
import javafx.scene.paint.Color;

/**
 *  FillPicker modela el comportamiento del picker de color de relleno
 */
public class FillPicker extends Picker{

    public FillPicker(CanvasPane canvasPane, StatusPane statusPane){
        super(canvasPane, statusPane);
    }

    @Override
    public void action(Color color) {
        canvasPane.setSelectedFillColor(color);
        canvasPane.getCanvasState().setSelectedFiguresFillColor(color.toString());
        statusPane.updateStatusColor("Color de relleno", color);
    }
}
