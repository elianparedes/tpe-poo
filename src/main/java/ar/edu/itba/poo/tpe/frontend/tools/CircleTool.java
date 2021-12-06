package ar.edu.itba.poo.tpe.frontend.tools;

import ar.edu.itba.poo.tpe.backend.model.Circle;
import ar.edu.itba.poo.tpe.backend.model.Point;
import ar.edu.itba.poo.tpe.frontend.pane.CanvasPane;
import ar.edu.itba.poo.tpe.backend.model.drawable.DrawableCircle;
import ar.edu.itba.poo.tpe.backend.model.drawable.DrawableFigure;

public class CircleTool extends DrawingTool{

    public CircleTool(CanvasPane canvasPane) {
        super(canvasPane);
    }

    @Override
    public DrawableFigure createFigure(Point firstPoint, Point secondPoint) {
        DrawableFigure figure = new DrawableCircle(
                new Circle(firstPoint,firstPoint.distance(secondPoint)),
                canvasPane.getSelectedStrokeColor().toString(),
                canvasPane.getSelectedFillColor().toString(),
                canvasPane.getSelectedStrokeWidth()
        );

        Circle circle = (Circle) figure.getFigure();
        figure.setDrawingFunction(() -> {
            graphicsContext.fillOval(circle.getCenterPoint().getX() - circle.getsHorizontalAxis(),
                    circle.getCenterPoint().getY() - circle.getsVerticalAxis(),
                    circle.getsHorizontalAxis() * 2,
                    circle.getsVerticalAxis() * 2
            );
            graphicsContext.strokeOval(circle.getCenterPoint().getX() - circle.getsHorizontalAxis(),
                    circle.getCenterPoint().getY() - circle.getsVerticalAxis(),
                    circle.getsHorizontalAxis() * 2,
                    circle.getsVerticalAxis() * 2
            );
        });

        return figure;
    }
}
