package ar.edu.itba.poo.tpe.frontend.tools;

import ar.edu.itba.poo.tpe.backend.model.Point;
import ar.edu.itba.poo.tpe.frontend.pane.CanvasPane;
import ar.edu.itba.poo.tpe.backend.model.drawable.DrawableFigure;
import ar.edu.itba.poo.tpe.frontend.pane.StatusPane;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public abstract class DrawingTool extends Tool {

    protected static final int DRAWING_TOLERANCE =10;
    protected Point startPoint , endPoint;

    public DrawingTool(CanvasPane canvasPane, StatusPane statusPane) {
        super(canvasPane, statusPane);
    }

    public abstract DrawableFigure createFigure(Point firstPoint, Point secondPoint);

    public abstract void setDrawingFunction(DrawableFigure drawableFigure);

    @Override
    public EventHandler<MouseEvent> onMousePressed() {
        return (e -> {
            endPoint = null;
            startPoint = new Point(e.getX(),e.getY());
            statusPane.updateStatusPoint(e.getX(), e.getY());
        });
    }

    @Override
    public EventHandler<MouseEvent> onMouseDragged() {
        return (e -> {
            endPoint = new Point(e.getX(),e.getY());
            statusPane.updateStatusPoint(e.getX(), e.getY());
        });
    }

    @Override
    public EventHandler<MouseEvent> onMouseReleased() {
        return (e->{
            if(startPoint == null || endPoint == null || !startPoint.isLower(endPoint) ||
                    Double.compare(endPoint.distance(startPoint) , DRAWING_TOLERANCE) < 0 )
                return;
            canvasPane.getCanvasState().addFigure(createFigure(startPoint, endPoint));
        });
    }

}
