package ar.edu.itba.poo.tpe.frontend.tools;

import ar.edu.itba.poo.tpe.backend.model.Ellipse;
import ar.edu.itba.poo.tpe.backend.model.Point;
import ar.edu.itba.poo.tpe.frontend.CanvasPane;
import ar.edu.itba.poo.tpe.frontend.drawable.DrawableEllipse;
import ar.edu.itba.poo.tpe.frontend.drawable.DrawableFigure;

public class EllipseTool extends DrawingTool {
    public EllipseTool(CanvasPane canvasPane) {
        super(canvasPane);
    }

    @Override
    public DrawableFigure createFigure(Point firstPoint, Point secondPoint) {
        double Haxis = (secondPoint.getX() - firstPoint.getX()) / 2;
        double Vaxis = (secondPoint.getY() - firstPoint.getY()) / 2;
        Point centerPoint = new Point(firstPoint.getX() + Haxis, firstPoint.getY() + Vaxis);
        return new DrawableEllipse(new Ellipse(centerPoint, Haxis, Vaxis));
    }
}
