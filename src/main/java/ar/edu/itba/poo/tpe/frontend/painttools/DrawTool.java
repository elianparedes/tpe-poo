package ar.edu.itba.poo.tpe.frontend.painttools;

import ar.edu.itba.poo.tpe.backend.model.Point;
import ar.edu.itba.poo.tpe.frontend.drawable.DrawableFigure;

public interface DrawTool extends PaintTool{
    DrawableFigure createFigure(Point firstPoint , Point secondPoint);
}
