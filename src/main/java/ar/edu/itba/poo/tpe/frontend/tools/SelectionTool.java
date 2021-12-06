package ar.edu.itba.poo.tpe.frontend.tools;

import ar.edu.itba.poo.tpe.backend.CanvasState;
import ar.edu.itba.poo.tpe.backend.model.Point;
import ar.edu.itba.poo.tpe.backend.model.Rectangle;
import ar.edu.itba.poo.tpe.frontend.pane.CanvasPane;
import ar.edu.itba.poo.tpe.frontend.pane.StatusPane;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class SelectionTool extends Tool {

    private boolean inMultipleSelection = false;
    private Point startPoint = null, endPoint = null;
    private Rectangle selectionRectangle;

    private final CanvasState canvasState;

    public SelectionTool(CanvasPane canvasPane, StatusPane statusPane) {
        super(canvasPane, statusPane);
        this.canvasState = canvasPane.getCanvasState();
    }

    private void resetValues() {
        inMultipleSelection = false;
        canvasState.unselectAllFigures();
    }

    private void updateStatus(){
        statusPane.updateStatus(
                canvasState.hasSelectedFigures() ?
                        "Se seleccionó: " + canvasState.getSelectedFigures() :
                        "Ninguna figura encontrada"
        );
    }

    @Override
    public EventHandler<MouseEvent> onMousePressed() {
        return (e -> {
            startPoint = new Point(e.getX(), e.getY());
            if (inMultipleSelection)
                return;
            if (canvasState.selectedFiguresCount() > 0) {
                canvasState.unselectAllFigures();
            }
            canvasState.selectFigure(startPoint);
            if (canvasState.selectedFiguresCount() != 1) {
                inMultipleSelection = true;
            } else {
                updateStatus();
            }
        });
    }

    @Override
    public EventHandler<MouseEvent> onMouseDragged() {
        return (e -> {
            if (canvasState.hasSelectedFigures()) {
                Point eventPoint = new Point(e.getX(), e.getY());
                double diffX = (eventPoint.getX() - startPoint.getX());
                double diffY = (eventPoint.getY() - startPoint.getY());
                canvasState.moveSelectedFigures(diffX, diffY);
                startPoint = eventPoint;
            }
        });
    }

    @Override
    public EventHandler<MouseEvent> onMouseReleased() {
        return (e -> {
            if (inMultipleSelection) {
                if (canvasState.hasSelectedFigures()) {
                    canvasState.unselectAllFigures();
                    canvasPane.render();
                    resetValues();
                } else {
                    endPoint = new Point(e.getX(), e.getY());
                    selectionRectangle = new Rectangle(startPoint, endPoint);
                    canvasState.selectFiguresWithin(selectionRectangle);
                    updateStatus();
                    if (!canvasState.hasSelectedFigures()) {
                        resetValues();
                    }
                }
            }
        });
    }
}
