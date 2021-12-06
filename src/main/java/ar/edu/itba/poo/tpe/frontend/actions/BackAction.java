package ar.edu.itba.poo.tpe.frontend.actions;

import ar.edu.itba.poo.tpe.frontend.pane.CanvasPane;

public class BackAction extends Action{
    @Override
    public void action(CanvasPane canvasPane) {
        canvasPane.getCanvasState().sendToBack(canvasPane.getCanvasState().getSelectedFigures());
        canvasPane.render();
    }
}
