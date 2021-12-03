package ar.edu.itba.poo.tpe.frontend.painttools;

import ar.edu.itba.poo.tpe.backend.model.Point;
import ar.edu.itba.poo.tpe.backend.model.Square;
import ar.edu.itba.poo.tpe.frontend.ToolsListener;
import ar.edu.itba.poo.tpe.frontend.drawable.DrawableFigure;
import ar.edu.itba.poo.tpe.frontend.drawable.DrawableSquare;

public class SquareTool implements DrawTool{
    @Override
    public DrawableFigure createFigure(Point firstPoint, Point secondPoint) {
        return new DrawableSquare(new Square(firstPoint, secondPoint.getX()- firstPoint.getX()));
    }

    @Override
    public void action(ToolsListener toolsListener) {
        toolsListener.onFigureDraw(this);
    }
}
