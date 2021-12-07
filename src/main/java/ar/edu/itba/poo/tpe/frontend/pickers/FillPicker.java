package ar.edu.itba.poo.tpe.frontend.pickers;

import ar.edu.itba.poo.tpe.backend.utils.ColorRGB;
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
    public void execute(Color color) {
        canvasPane.setSelectedFillColor(color);
        canvasPane.getCanvasState().setSelectedFiguresFillColor(new ColorRGB(color.getRed(), color.getGreen(), color.getBlue()));
        statusPane.updateStatusColor("Color de relleno", color);
    }
}
