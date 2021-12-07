package ar.edu.itba.poo.tpe.frontend.pickers;

import ar.edu.itba.poo.tpe.frontend.pane.CanvasPane;
import ar.edu.itba.poo.tpe.frontend.pane.StatusPane;
import javafx.scene.paint.Color;

/**
 * Picker modela el comportamiento de los pickers (borde y relleno) mediante el método action
 */
public abstract class Picker {

    protected CanvasPane canvasPane;
    protected StatusPane statusPane;

    public Picker(CanvasPane canvasPane, StatusPane statusPane) {
        this.canvasPane = canvasPane;
        this.statusPane = statusPane;
    }

    abstract public void execute(Color color);
}
