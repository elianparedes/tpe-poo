package ar.edu.itba.poo.tpe.frontend.actions;

import ar.edu.itba.poo.tpe.frontend.CanvasPane;
import ar.edu.itba.poo.tpe.frontend.drawable.DrawableFigure;

import java.util.Set;

public class DeleteAction extends Action{
    @Override
    public void action(CanvasPane canvasPane) {
        canvasPane.getCanvasState().removeSelectedFigures();
        canvasPane.render();
    }
}
