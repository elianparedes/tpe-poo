package ar.edu.itba.poo.tpe.frontend.tools;

import ar.edu.itba.poo.tpe.backend.model.Circle;
import ar.edu.itba.poo.tpe.backend.model.Ellipse;
import ar.edu.itba.poo.tpe.backend.model.Point;
import ar.edu.itba.poo.tpe.frontend.pane.CanvasPane;
import ar.edu.itba.poo.tpe.backend.model.drawable.DrawableCircle;
import ar.edu.itba.poo.tpe.backend.model.drawable.DrawableFigure;
import ar.edu.itba.poo.tpe.frontend.pane.StatusPane;

public class CircleTool extends EllipseTool {

    public CircleTool(CanvasPane canvasPane, StatusPane statusPane) {
        super(canvasPane, statusPane);
    }

    @Override
    public DrawableFigure createFigure(Point firstPoint, Point secondPoint) {
        DrawableFigure figure = new DrawableCircle(
                new Circle(firstPoint,firstPoint.distance(secondPoint)),
                canvasPane.getSelectedStrokeColor().toString(),
                canvasPane.getSelectedFillColor().toString(),
                canvasPane.getSelectedStrokeWidth()
        );

        setDrawingFunction(figure);

        return figure;
    }
}
