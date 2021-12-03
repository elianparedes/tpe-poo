package ar.edu.itba.poo.tpe.frontend.drawable;

import ar.edu.itba.poo.tpe.backend.model.Ellipse;
import ar.edu.itba.poo.tpe.backend.model.Figure;
import ar.edu.itba.poo.tpe.backend.model.Point;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class DrawableEllipse extends DrawableFigure{
    private Ellipse ellipse;

    public DrawableEllipse(Ellipse ellipse, Color stroke, Color fill, double lineWidth) {
        super(stroke, fill, lineWidth);
        this.ellipse=ellipse;
    }

    public DrawableEllipse(Ellipse ellipse){
        this(ellipse, Color.RED, Color.YELLOW, 1);
    }

    @Override
    public Figure getFigure() {
        return ellipse;
    }

    @Override
    public void moveFigure(double deltaX, double deltaY) {
        ellipse.moveFigure(deltaX, deltaY);
    }

    @Override
    public boolean pointBelongs(Point point) {
        return ellipse.pointBelongs(point);
    }

    @Override
    public void fillFigure(GraphicsContext gc) {
        setGraphicsContext(gc);
        double sHa=ellipse.getsHorizontalAxis();
        double sVa=ellipse.getsVerticalAxis();
        Point centerPoint=ellipse.getCenterPoint();
        gc.fillOval(centerPoint.getX() -sHa, centerPoint.getY() - sVa, sHa*2, sVa*2);
    }

    @Override
    public void strokeFigure(GraphicsContext gc) {
        setGraphicsContext(gc);
        double sHa=ellipse.getsHorizontalAxis();
        double sVa=ellipse.getsVerticalAxis();
        Point centerPoint=ellipse.getCenterPoint();
        gc.strokeOval(centerPoint.getX() -sHa, centerPoint.getY() - sVa, sHa*2, sVa*2);
    }
}
