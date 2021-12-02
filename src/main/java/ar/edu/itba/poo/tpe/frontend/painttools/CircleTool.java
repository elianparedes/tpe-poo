package ar.edu.itba.poo.tpe.frontend.painttools;

import ar.edu.itba.poo.tpe.backend.model.Point;
import ar.edu.itba.poo.tpe.frontend.Drawable.DrawableCircle;
import ar.edu.itba.poo.tpe.frontend.Drawable.DrawableFigure;
import ar.edu.itba.poo.tpe.frontend.ToolsListener;

public class CircleTool implements DrawTool{
    @Override
    public DrawableFigure createFigure(Point firstPoint, Point secondPoint) {
        return new DrawableCircle(firstPoint,firstPoint.distance(secondPoint));
    }

    @Override
    public void action(ToolsListener toolsListener) {
        toolsListener.onFigureDraw(this);
    }
}
