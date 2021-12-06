package ar.edu.itba.poo.tpe.frontend.actions;

import ar.edu.itba.poo.tpe.frontend.pane.CanvasPane;
import ar.edu.itba.poo.tpe.frontend.pane.StatusPane;

/**
 * BackAction modela el comportamiento al presionar el botón de borrado de las figuras seleccionadas
 */
public class DeleteAction extends Action{
    @Override
    public void execute(CanvasPane canvasPane, StatusPane statusPane) {
        canvasPane.getCanvasState().removeSelectedFigures();
    }
}
