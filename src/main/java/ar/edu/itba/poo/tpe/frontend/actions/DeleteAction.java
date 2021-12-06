package ar.edu.itba.poo.tpe.frontend.actions;

import ar.edu.itba.poo.tpe.frontend.pane.CanvasPane;

public class DeleteAction extends Action{
    @Override
    public void action(CanvasPane canvasPane) {
        canvasPane.getCanvasState().removeSelectedFigures();
        canvasPane.render();
    }
}
