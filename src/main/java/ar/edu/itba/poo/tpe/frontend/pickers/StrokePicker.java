package ar.edu.itba.poo.tpe.frontend.pickers;

import ar.edu.itba.poo.tpe.frontend.pane.CanvasPane;
import ar.edu.itba.poo.tpe.frontend.pane.StatusPane;
import javafx.scene.paint.Color;

public class StrokePicker extends Picker{

    public StrokePicker(CanvasPane canvasPane, StatusPane statusPane){
        super(canvasPane, statusPane);
    }

    @Override
    public void action(Color color) {
        canvasPane.strokeColorPreview(color.toString());
        canvasPane.setSelectedStrokeColor(color);
        statusPane.updateStatusColor("Color de trazo", color);
    }
}
