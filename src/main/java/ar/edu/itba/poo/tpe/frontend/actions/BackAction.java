package ar.edu.itba.poo.tpe.frontend.actions;

import ar.edu.itba.poo.tpe.frontend.CanvasPane;

public class BackAction extends Action{
    @Override
    public void action(CanvasPane canvasPane) {
        canvasPane.getCanvasState().sendToBack(canvasPane.getSelectedFigures());
        canvasPane.render();
    }
}
