package ar.edu.itba.poo.tpe.frontend.pickers;

import ar.edu.itba.poo.tpe.frontend.CanvasPane;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public abstract class Picker {

    protected CanvasPane canvasPane;

    public Picker (CanvasPane canvasPane){
        this.canvasPane=canvasPane;
    }

    abstract public void action(Color color);
}
