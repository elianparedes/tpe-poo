package ar.edu.itba.poo.tpe.frontend.pickers;

import ar.edu.itba.poo.tpe.backend.CanvasState;
import ar.edu.itba.poo.tpe.frontend.pane.CanvasPane;
import ar.edu.itba.poo.tpe.frontend.pane.StatusPane;
import javafx.scene.paint.Color;

public abstract class Picker {

    protected CanvasPane canvasPane;
    protected CanvasState canvasState;
    protected StatusPane statusPane;

    public Picker(CanvasPane canvasPane, StatusPane statusPane) {
        this.canvasPane = canvasPane;
        this.statusPane = statusPane;
    }

    abstract public void action(Color color);
}
