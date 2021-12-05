package ar.edu.itba.poo.tpe.frontend.pickers;

import ar.edu.itba.poo.tpe.frontend.CanvasPane;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.util.concurrent.TimeUnit;

public class StrokePicker extends Picker{

    public StrokePicker(CanvasPane canvasPane){
        super(canvasPane);
    }

    @Override
    public void action(Color color) {
        canvasPane.strokePreview(color);
    }
}
