package ar.edu.itba.poo.tpe.frontend.tools;

import ar.edu.itba.poo.tpe.backend.model.Line;
import ar.edu.itba.poo.tpe.backend.model.Point;
import ar.edu.itba.poo.tpe.frontend.drawable.DrawableFigure;
import ar.edu.itba.poo.tpe.frontend.drawable.DrawableLine;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class LineTool extends DrawingTool{
    @Override
    public DrawableFigure createFigure(Point firstPoint, Point secondPoint) {
        return new DrawableLine(new Line(firstPoint, secondPoint));
    }
    @Override
    public EventHandler<MouseEvent> onMouseReleased() {
        return (e->{
            if(startPoint == null || endPoint == null || Double.compare(endPoint.distance(startPoint) , DRAWINGTOLERANCE) < 0 )
                return;
            canvasPane.addFigure(createFigure(startPoint, endPoint));
        });
    }

}
