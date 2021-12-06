package ar.edu.itba.poo.tpe.frontend.pickers;

import ar.edu.itba.poo.tpe.frontend.pane.CanvasPane;
import javafx.scene.paint.Color;

public class FillPicker extends Picker{

    public FillPicker(CanvasPane canvasPane){
        super(canvasPane);
    }

    @Override
    public void action(Color color) {
        canvasPane.setSelectedFillColor(color);
        canvasPane.getCanvasState().setSelectedFiguresFillColor(color.toString());
    }
}
