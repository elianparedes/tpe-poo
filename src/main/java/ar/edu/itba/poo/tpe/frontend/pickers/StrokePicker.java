package ar.edu.itba.poo.tpe.frontend.pickers;

import ar.edu.itba.poo.tpe.frontend.pane.CanvasPane;
import javafx.scene.paint.Color;

public class StrokePicker extends Picker{

    public StrokePicker(CanvasPane canvasPane){
        super(canvasPane);
    }

    @Override
    public void action(Color color) {
        canvasPane.strokeColorPreview(color.toString());
        canvasPane.setSelectedStrokeColor(color);
    }
}
