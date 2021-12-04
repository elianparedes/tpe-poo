package ar.edu.itba.poo.tpe.frontend.actions;

import ar.edu.itba.poo.tpe.frontend.CanvasPane;
import ar.edu.itba.poo.tpe.frontend.drawable.DrawableFigure;

import java.util.Set;

public class DeleteAction extends Action{
    @Override
    public void action(CanvasPane canvasPane) {
        Set<DrawableFigure> selectedFigures = canvasPane.getCanvasState().getSelectedFigures().keySet();
        canvasPane.getCanvasState().deleteAll(selectedFigures);
        canvasPane.render();
    }
}
