package ar.edu.itba.poo.tpe.frontend.tools;

import ar.edu.itba.poo.tpe.backend.model.Point;
import ar.edu.itba.poo.tpe.backend.model.Rectangle;
import ar.edu.itba.poo.tpe.backend.model.Square;
import ar.edu.itba.poo.tpe.backend.utils.ColorRGB;
import ar.edu.itba.poo.tpe.frontend.pane.CanvasPane;
import ar.edu.itba.poo.tpe.backend.model.drawable.DrawableFigure;
import ar.edu.itba.poo.tpe.backend.model.drawable.DrawableSquare;
import ar.edu.itba.poo.tpe.frontend.pane.StatusPane;
import javafx.scene.paint.Color;

public class SquareTool extends RectangleTool {
    public SquareTool(CanvasPane canvasPane, StatusPane statusPane) {
        super(canvasPane, statusPane);
    }

    @Override
    public DrawableFigure createFigure(Point firstPoint, Point secondPoint) {

        Color strokeColor = canvasPane.getSelectedStrokeColor();
        Color fillColor = canvasPane.getSelectedFillColor();

        DrawableFigure figure = new DrawableSquare(
                new Square(firstPoint, secondPoint.getX() - firstPoint.getX()),
                new ColorRGB(strokeColor.getRed(), strokeColor.getGreen(), strokeColor.getBlue()),
                new ColorRGB(fillColor.getRed(), fillColor.getGreen(), fillColor.getBlue()),
                canvasPane.getSelectedStrokeWidth()
        );

        setDrawingFunction(figure);

        return figure;
    }
}
