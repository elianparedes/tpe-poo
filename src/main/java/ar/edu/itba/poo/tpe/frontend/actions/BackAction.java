package ar.edu.itba.poo.tpe.frontend.actions;

import ar.edu.itba.poo.tpe.frontend.pane.CanvasPane;
import ar.edu.itba.poo.tpe.frontend.pane.StatusPane;

/**
 * BackAction modela el comportamiento al presionar el botón de enviar atrás
 */
public class BackAction extends Action{
    @Override
    public void execute(CanvasPane canvasPane, StatusPane statusPane) {
        canvasPane.getCanvasState().sendToBack(canvasPane.getCanvasState().getSelectedFigures());
        statusPane.updateStatus("Selección enviada hacia atrás");
    }
}
