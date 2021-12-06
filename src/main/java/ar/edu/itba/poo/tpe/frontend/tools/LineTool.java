package ar.edu.itba.poo.tpe.frontend.tools;

import ar.edu.itba.poo.tpe.backend.model.Line;
import ar.edu.itba.poo.tpe.backend.model.Point;
import ar.edu.itba.poo.tpe.frontend.pane.CanvasPane;
import ar.edu.itba.poo.tpe.backend.model.drawable.DrawableFigure;
import ar.edu.itba.poo.tpe.backend.model.drawable.DrawableLine;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class LineTool extends DrawingTool{
    public LineTool(CanvasPane canvasPane) {
        super(canvasPane);
    }

    @Override
    public DrawableFigure createFigure(Point firstPoint, Point secondPoint) {
        DrawableLine figure = new DrawableLine(
                new Line(firstPoint, secondPoint),
                canvasPane.getSelectedStrokeColor().toString(),
                canvasPane.getSelectedStrokeWidth()
        );

        figure.setDrawingFunction(() -> {
            Line line = (Line) figure.getFigure();
            graphicsContext.strokeLine(
                    line.getStartPoint().getX(),
                    line.getStartPoint().getY(),
                    line.getEndPoint().getX(),
                    line.getEndPoint().getY()
            );
        });

        return figure;
    }

    @Override
    public EventHandler<MouseEvent> onMouseReleased() {
        return (e->{
            if(startPoint == null || endPoint == null || Double.compare(endPoint.distance(startPoint) , DRAWING_TOLERANCE) < 0 )
                return;
            canvasPane.getCanvasState().addFigure(createFigure(startPoint, endPoint));
        });
    }

}
