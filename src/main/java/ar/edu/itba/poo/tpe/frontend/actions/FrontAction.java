package ar.edu.itba.poo.tpe.frontend.actions;

import ar.edu.itba.poo.tpe.frontend.pane.CanvasPane;

/**
 * BackAction modela el comportamiento al presionar el botón de enviar adelante
 */
public class FrontAction extends Action{
    @Override
    public void action(CanvasPane canvasPane) {
        canvasPane.getCanvasState().bringToFront(canvasPane.getCanvasState().getSelectedFigures());
    }
}
