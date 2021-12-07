package ar.edu.itba.poo.tpe.frontend.actions;

import ar.edu.itba.poo.tpe.frontend.pane.CanvasPane;
import ar.edu.itba.poo.tpe.frontend.pane.StatusPane;

/**
 * BackAction modela el comportamiento al presionar el botón de enviar adelante
 */
public class FrontAction extends Action{
    @Override
    public void execute(CanvasPane canvasPane, StatusPane statusPane) {
        if (canvasPane.getCanvasState().hasSelectedFigures()) {
            canvasPane.getCanvasState().bringToFront(canvasPane.getCanvasState().getSelectedFigures());
            statusPane.updateStatus("Selección enviada al frente");
        }
    }
}
