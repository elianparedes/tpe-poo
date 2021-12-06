package ar.edu.itba.poo.tpe.frontend.pickers;

import ar.edu.itba.poo.tpe.backend.CanvasState;
import ar.edu.itba.poo.tpe.frontend.pane.CanvasPane;
import javafx.scene.paint.Color;

public abstract class Picker {

    protected CanvasPane canvasPane;
    protected CanvasState canvasState;

    public Picker(CanvasPane canvasPane) {
        this.canvasPane = canvasPane;
        canvasState = new CanvasState();
    }

    abstract public void action(Color color);
}
