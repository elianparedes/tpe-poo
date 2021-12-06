package ar.edu.itba.poo.tpe.frontend.actions;

import ar.edu.itba.poo.tpe.frontend.pane.CanvasPane;
import ar.edu.itba.poo.tpe.frontend.pane.StatusPane;

public class BackAction extends Action{
    @Override
    public void execute(CanvasPane canvasPane, StatusPane statusPane) {
        canvasPane.getCanvasState().sendToBack(canvasPane.getCanvasState().getSelectedFigures());
    }
}
