package ar.edu.itba.poo.tpe.frontend.tools;

import ar.edu.itba.poo.tpe.backend.model.Point;
import ar.edu.itba.poo.tpe.backend.model.Rectangle;
import ar.edu.itba.poo.tpe.frontend.pane.CanvasPane;
import ar.edu.itba.poo.tpe.backend.model.drawable.DrawableFigure;
import ar.edu.itba.poo.tpe.backend.model.drawable.DrawableRectangle;
import ar.edu.itba.poo.tpe.frontend.pane.StatusPane;

public class RectangleTool extends DrawingTool {

    public RectangleTool(CanvasPane canvasPane, StatusPane statusPane) {
        super(canvasPane, statusPane);
    }

    @Override
    public DrawableFigure createFigure(Point firstPoint, Point secondPoint) {
        DrawableRectangle figure = new DrawableRectangle(
                new Rectangle(firstPoint, secondPoint),
                canvasPane.getSelectedStrokeColor().toString(),
                canvasPane.getSelectedFillColor().toString(),
                canvasPane.getSelectedStrokeWidth()
        );

        setDrawingFunction(figure);

        return figure;
    }

    @Override
    public void setDrawingFunction(DrawableFigure drawableFigure) {
        Rectangle rectangle = (Rectangle) drawableFigure.getFigure();
        drawableFigure.setDrawingFunction(() -> {
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
    }

}
