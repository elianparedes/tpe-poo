package ar.edu.itba.poo.tpe.frontend.tools;

import ar.edu.itba.poo.tpe.backend.model.Point;
import ar.edu.itba.poo.tpe.backend.model.Rectangle;
import ar.edu.itba.poo.tpe.backend.model.Square;
import ar.edu.itba.poo.tpe.frontend.pane.CanvasPane;
import ar.edu.itba.poo.tpe.backend.model.drawable.DrawableFigure;
import ar.edu.itba.poo.tpe.backend.model.drawable.DrawableSquare;

public class SquareTool extends DrawingTool {
    public SquareTool(CanvasPane canvasPane) {
        super(canvasPane);
    }

    @Override
    public DrawableFigure createFigure(Point firstPoint, Point secondPoint) {
        DrawableFigure figure = new DrawableSquare(
                new Square(firstPoint, secondPoint.getX() - firstPoint.getX()),
                canvasPane.getSelectedStrokeColor().toString(),
                canvasPane.getSelectedFillColor().toString(),
                canvasPane.getSelectedStrokeWidth()
        );

        figure.setDrawingFunction(() -> {
            Rectangle rectangle = (Rectangle) figure.getFigure();
            graphicsContext.fillRect(
                    rectangle.getTopLeft().getX(),
                    rectangle.getTopLeft().getY(),
                    Math.abs(rectangle.getTopLeft().getX() - rectangle.getBottomRight().getX()),
                    Math.abs(rectangle.getTopLeft().getY() - rectangle.getBottomRight().getY())
            );
            graphicsContext.strokeRect(
                    rectangle.getTopLeft().getX(),
                    rectangle.getTopLeft().getY(),
                    Math.abs(rectangle.getTopLeft().getX() - rectangle.getBottomRight().getX()),
                    Math.abs(rectangle.getTopLeft().getY() - rectangle.getBottomRight().getY())
            );
        });

        return figure;
    }
}
