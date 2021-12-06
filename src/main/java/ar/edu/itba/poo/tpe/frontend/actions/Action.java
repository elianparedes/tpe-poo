package ar.edu.itba.poo.tpe.frontend.actions;

import ar.edu.itba.poo.tpe.frontend.pane.CanvasPane;
import ar.edu.itba.poo.tpe.frontend.pane.StatusPane;

public abstract class Action {
    public abstract void execute(CanvasPane canvasPane, StatusPane statusPane);
}
