package ar.edu.itba.poo.tpe.frontend.tools;

import ar.edu.itba.poo.tpe.backend.model.Ellipse;
import ar.edu.itba.poo.tpe.backend.model.Point;
import ar.edu.itba.poo.tpe.frontend.pane.CanvasPane;
import ar.edu.itba.poo.tpe.backend.model.drawable.DrawableEllipse;
import ar.edu.itba.poo.tpe.backend.model.drawable.DrawableFigure;

public class EllipseTool extends DrawingTool {

    public EllipseTool(CanvasPane canvasPane) {
        super(canvasPane);
    }

    @Override
    public DrawableFigure createFigure(Point firstPoint, Point secondPoint) {
        double hAxis = (secondPoint.getX() - firstPoint.getX()) / 2;
        double vAxis = (secondPoint.getY() - firstPoint.getY()) / 2;

        Point centerPoint = new Point(firstPoint.getX() + hAxis, firstPoint.getY() + vAxis);

        DrawableEllipse figure = new DrawableEllipse(
                new Ellipse(centerPoint,hAxis, vAxis),
                canvasPane.getSelectedStrokeColor().toString(),
                canvasPane.getSelectedFillColor().toString(),
                canvasPane.getSelectedStrokeWidth()
        );

        Ellipse ellipse = (Ellipse) figure.getFigure();
        figure.setDrawingFunction(() -> {
            graphicsContext.fillOval(ellipse.getCenterPoint().getX() - hAxis,
                    ellipse.getCenterPoint().getY() - vAxis,
                    hAxis * 2,
                    vAxis * 2
            );
            graphicsContext.strokeOval(ellipse.getCenterPoint().getX() - hAxis,
                    ellipse.getCenterPoint().getY() - vAxis,
                    hAxis * 2,
                    vAxis * 2)
            ;
        });

        return figure;
    }
}
