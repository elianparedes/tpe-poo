package ar.edu.itba.poo.tpe.frontend.tools;

import ar.edu.itba.poo.tpe.backend.model.Ellipse;
import ar.edu.itba.poo.tpe.backend.model.Point;
import ar.edu.itba.poo.tpe.backend.utils.ColorRGB;
import ar.edu.itba.poo.tpe.frontend.pane.CanvasPane;
import ar.edu.itba.poo.tpe.backend.model.drawable.DrawableEllipse;
import ar.edu.itba.poo.tpe.backend.model.drawable.DrawableFigure;
import ar.edu.itba.poo.tpe.frontend.pane.StatusPane;
import javafx.scene.paint.Color;

public class EllipseTool extends DrawingTool {

    public EllipseTool(CanvasPane canvasPane, StatusPane statusPane) {
        super(canvasPane, statusPane);
    }

    @Override
    public DrawableFigure createFigure(Point firstPoint, Point secondPoint) {

        Color strokeColor = canvasPane.getSelectedStrokeColor();
        Color fillColor = canvasPane.getSelectedFillColor();

        double hAxis = (secondPoint.getX() - firstPoint.getX()) / 2;
        double vAxis = (secondPoint.getY() - firstPoint.getY()) / 2;

        Point centerPoint = new Point(firstPoint.getX() + hAxis, firstPoint.getY() + vAxis);

        DrawableEllipse figure = new DrawableEllipse(
                new Ellipse(centerPoint,hAxis, vAxis),
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
        Ellipse ellipse = (Ellipse) drawableFigure.getFigure();
        drawableFigure.setDrawingFunction(() -> {
            graphicsContext.fillOval(
                    ellipse.getCenterPoint().getX() - ellipse.getsHorizontalAxis(),
                    ellipse.getCenterPoint().getY() - ellipse.getsVerticalAxis(),
                    ellipse.getsHorizontalAxis() * 2,
                    ellipse.getsVerticalAxis() * 2
            );
            graphicsContext.strokeOval(
                    ellipse.getCenterPoint().getX() - ellipse.getsHorizontalAxis(),
                    ellipse.getCenterPoint().getY() - ellipse.getsVerticalAxis(),
                    ellipse.getsHorizontalAxis() * 2,
                    ellipse.getsVerticalAxis() * 2)
            ;
        });
    }
}
