package ar.edu.itba.poo.tpe.frontend.painttools;

import ar.edu.itba.poo.tpe.backend.model.Point;
import ar.edu.itba.poo.tpe.frontend.drawable.DrawableFigure;
import ar.edu.itba.poo.tpe.frontend.drawable.DrawableRectangle;
import ar.edu.itba.poo.tpe.frontend.ToolsListener;

public class RectangleTool implements DrawTool{
    @Override
    public DrawableFigure createFigure(Point firstPoint, Point secondPoint) {
        return new DrawableRectangle(firstPoint,secondPoint);
    }

    @Override
    public void action(ToolsListener toolsListener) {
        toolsListener.onFigureDraw(this);
    }
}
