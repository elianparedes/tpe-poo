package ar.edu.itba.poo.tpe.frontend.tools;

import ar.edu.itba.poo.tpe.backend.model.Point;
import ar.edu.itba.poo.tpe.backend.model.Rectangle;
import ar.edu.itba.poo.tpe.backend.utils.ColorRGB;
import ar.edu.itba.poo.tpe.frontend.pane.CanvasPane;
import ar.edu.itba.poo.tpe.backend.model.drawable.DrawableFigure;
import ar.edu.itba.poo.tpe.backend.model.drawable.DrawableRectangle;
import ar.edu.itba.poo.tpe.frontend.pane.StatusPane;
import javafx.scene.paint.Color;

public class RectangleTool extends DrawingTool {

    public RectangleTool(CanvasPane canvasPane, StatusPane statusPane) {
        super(canvasPane, statusPane);
    }

    @Override
    public DrawableFigure createFigure(Point firstPoint, Point secondPoint) {

        Color strokeColor = canvasPane.getSelectedStrokeColor();
        Color fillColor = canvasPane.getSelectedFillColor();

        DrawableRectangle figure = new DrawableRectangle(
                new Rectangle(firstPoint, secondPoint),
                new ColorRGB(strokeColor.getRed(), strokeColor.getGreen(), strokeColor.getBlue()),
                new ColorRGB(fillColor.getRed(), fillColor.getGreen(), fillColor.getBlue()),
                canvasPane.getSelectedStrokeWidth()
        );

        setDrawingFunction(figure);

        return figure;
    }

    @Override
    protected void setDrawingFunction(DrawableFigure drawableFigure) {
        /**
         * El casteo es seguro pues el llamado a la funcion se realiza desde el metodo CreateFigure, donde se
         * asegura que la figura creada se corresponde con la herramienta. Al ser protected, no se podra llamar al
         * metodo con una figura que cause un error de ejecucion por el casteo.
         */
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
