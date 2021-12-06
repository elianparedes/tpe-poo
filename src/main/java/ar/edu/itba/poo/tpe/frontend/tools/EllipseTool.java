package ar.edu.itba.poo.tpe.frontend.tools;

import ar.edu.itba.poo.tpe.backend.model.Ellipse;
import ar.edu.itba.poo.tpe.backend.model.Point;
import ar.edu.itba.poo.tpe.frontend.pane.CanvasPane;
import ar.edu.itba.poo.tpe.backend.model.drawable.DrawableEllipse;
import ar.edu.itba.poo.tpe.backend.model.drawable.DrawableFigure;
import ar.edu.itba.poo.tpe.frontend.pane.StatusPane;

public class EllipseTool extends DrawingTool {

    public EllipseTool(CanvasPane canvasPane, StatusPane statusPane) {
        super(canvasPane, statusPane);
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

        setDrawingFunction(figure);

        return figure;
    }

    @Override
    public void setDrawingFunction(DrawableFigure drawableFigure) {
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
