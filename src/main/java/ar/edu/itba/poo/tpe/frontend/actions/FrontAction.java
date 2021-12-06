package ar.edu.itba.poo.tpe.frontend.actions;

import ar.edu.itba.poo.tpe.frontend.pane.CanvasPane;

public class FrontAction extends Action{
    @Override
    public void action(CanvasPane canvasPane) {
        canvasPane.getCanvasState().bringToFront(canvasPane.getCanvasState().getSelectedFigures());
        canvasPane.render();
    }
}
