package ar.edu.itba.poo.tpe.frontend.tools;

import ar.edu.itba.poo.tpe.backend.model.Point;
import ar.edu.itba.poo.tpe.backend.model.Rectangle;
import ar.edu.itba.poo.tpe.frontend.CanvasPane;
import ar.edu.itba.poo.tpe.frontend.drawable.DrawableFigure;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class SelectionTool extends Tool {

    private Point startPoint = null, endPoint = null;
    private Rectangle selectionRectangle;
    private final String SIMPLE_SELECTION = "Seleccion simple", MULTIPLE_SELECTION = "Seleccion multiple", DEFAULT = "default";
    private String actionCase = DEFAULT;

    public SelectionTool(CanvasPane canvasPane) {
        super(canvasPane);
    }

    private void resetValues() {
        actionCase = DEFAULT;
        canvasPane.getCanvasState().unselectAllFigures();
    }

    @Override
    public EventHandler<MouseEvent> onMousePressed() {
        return (e -> {
            startPoint = new Point(e.getX(), e.getY());
            if (actionCase.equals(MULTIPLE_SELECTION))
                return;
            if (canvasPane.getCanvasState().selectedFiguresCount() > 0) {
                canvasPane.getCanvasState().unselectAllFigures();
            }
            canvasPane.getCanvasState().selectFigure(startPoint);
            if (canvasPane.getCanvasState().selectedFiguresCount() != 1) {
                actionCase = MULTIPLE_SELECTION;
            }
            action();
            canvasPane.render();
        });
    }

    @Override
    public EventHandler<MouseEvent> onMouseDragged() {

        return (e -> {
            if (canvasPane.getCanvasState().hasSelectedFigures()) {
                Point eventPoint = new Point(e.getX(), e.getY());
                double diffX = (eventPoint.getX() - startPoint.getX());
                double diffY = (eventPoint.getY() - startPoint.getY());
                for (DrawableFigure figure : canvasPane.getSelectedFigures()) {
                    figure.moveFigure(diffX, diffY);
                }
                startPoint = eventPoint;
                canvasPane.render();
            }
        });
    }

    @Override
    public EventHandler<MouseEvent> onMouseReleased() {
        return (e -> {
            if (actionCase.equals(MULTIPLE_SELECTION)) {
                if (canvasPane.getCanvasState().hasSelectedFigures()) {
                    canvasPane.getCanvasState().unselectAllFigures();
                    canvasPane.render();
                    resetValues();
                } else {
                    endPoint = new Point(e.getX(), e.getY());
                    selectionRectangle = new Rectangle(startPoint, endPoint);
                    for (DrawableFigure drawableFigure : canvasPane.figures()) {
                        if (selectionRectangle.containsFigure(drawableFigure.getFigure())) {
                            canvasPane.getCanvasState().selectFigure(drawableFigure);
                        }
                    }
                    canvasPane.render();
                    if (!canvasPane.getCanvasState().hasSelectedFigures()) {
                        resetValues();
                    }
                }
                action();
            }
        });
    }
}
