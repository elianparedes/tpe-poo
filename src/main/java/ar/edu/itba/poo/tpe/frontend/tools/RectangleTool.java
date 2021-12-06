package ar.edu.itba.poo.tpe.frontend.tools;

import ar.edu.itba.poo.tpe.backend.model.Point;
import ar.edu.itba.poo.tpe.backend.model.Rectangle;
import ar.edu.itba.poo.tpe.frontend.pane.CanvasPane;
import ar.edu.itba.poo.tpe.backend.model.drawable.DrawableFigure;
import ar.edu.itba.poo.tpe.backend.model.drawable.DrawableRectangle;

public class RectangleTool extends DrawingTool {

    public RectangleTool(CanvasPane canvasPane) {
        super(canvasPane);
    }

    @Override
    public DrawableFigure createFigure(Point firstPoint, Point secondPoint) {
        DrawableRectangle figure = new DrawableRectangle(
                new Rectangle(firstPoint, secondPoint),
                canvasPane.getSelectedStrokeColor().toString(),
                canvasPane.getSelectedFillColor().toString(),
                canvasPane.getSelectedStrokeWidth()
        );

        figure.setDrawingFunction(() -> { //TODO: Ver casteo y repetición de código
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
