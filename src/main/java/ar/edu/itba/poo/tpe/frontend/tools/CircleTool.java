package ar.edu.itba.poo.tpe.frontend.tools;

import ar.edu.itba.poo.tpe.backend.model.Circle;
import ar.edu.itba.poo.tpe.backend.model.Point;
import ar.edu.itba.poo.tpe.frontend.CanvasPane;
import ar.edu.itba.poo.tpe.frontend.drawable.DrawableCircle;
import ar.edu.itba.poo.tpe.frontend.drawable.DrawableFigure;

public class CircleTool extends DrawingTool{
    public CircleTool(CanvasPane canvasPane) {
        super(canvasPane);
    }

    @Override
    public DrawableFigure createFigure(Point firstPoint, Point secondPoint) {
        return new DrawableCircle(new Circle(firstPoint,firstPoint.distance(secondPoint)));
    }
}
