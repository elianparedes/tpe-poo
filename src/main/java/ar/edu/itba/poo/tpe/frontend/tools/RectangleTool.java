package ar.edu.itba.poo.tpe.frontend.tools;;

import ar.edu.itba.poo.tpe.backend.model.Point;
import ar.edu.itba.poo.tpe.backend.model.Rectangle;
import ar.edu.itba.poo.tpe.frontend.drawable.DrawableFigure;
import ar.edu.itba.poo.tpe.frontend.drawable.DrawableRectangle;

public class RectangleTool extends DrawingTool{
    @Override
    public DrawableFigure createFigure(Point firstPoint, Point secondPoint) {
        return new DrawableRectangle(new Rectangle(firstPoint,secondPoint));
    }
}
