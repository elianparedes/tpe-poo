package ar.edu.itba.poo.tpe.frontend.tools;

import ar.edu.itba.poo.tpe.backend.model.Point;
import ar.edu.itba.poo.tpe.backend.model.Square;
import ar.edu.itba.poo.tpe.frontend.drawable.DrawableFigure;
import ar.edu.itba.poo.tpe.frontend.drawable.DrawableSquare;

public class SquareTool extends DrawingTool{
    @Override
    public DrawableFigure createFigure(Point firstPoint, Point secondPoint) {
        double side=secondPoint.getX()- firstPoint.getX();
        Point bottomLeft = new Point(firstPoint.getX(), firstPoint.getY()-side);
        return new DrawableSquare(new Square(firstPoint, secondPoint.getX()- firstPoint.getX()));
    }
}
