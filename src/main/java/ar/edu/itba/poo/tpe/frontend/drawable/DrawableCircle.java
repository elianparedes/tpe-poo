package ar.edu.itba.poo.tpe.frontend.drawable;

import ar.edu.itba.poo.tpe.backend.model.Circle;
import ar.edu.itba.poo.tpe.backend.model.Point;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class DrawableCircle extends DrawableFigure {
    private Circle circle;
    private double radius, diameter;

    public DrawableCircle(Circle circle, Color stroke, Color fill, double lineWidth) {
        super(stroke, fill, lineWidth);
        this.circle=circle;
        this.radius=circle.getRadius();
        this.diameter=radius*2;
    }

    public DrawableCircle(Circle circle){
        this(circle, Color.RED, Color.YELLOW, 1);
    }

    @Override
    public void moveFigure(double deltaX, double deltaY) {
        circle.moveFigure(deltaX, deltaY);
    }

    @Override
    public boolean pointBelongs(Point point) {
        return circle.pointBelongs(point);
    }

    @Override
    public void fillFigure(GraphicsContext gc) {
        setGraphicsContext(gc);
        Point centerPoint=circle.getCenterPoint();
        gc.fillOval(centerPoint.getX() - radius, centerPoint.getY() - radius, diameter, diameter);
    }

    @Override
    public void strokeFigure(GraphicsContext gc) {
        setGraphicsContext(gc);
        Point centerPoint=circle.getCenterPoint();
        gc.strokeOval(centerPoint.getX() - radius, centerPoint.getY() -radius, diameter, diameter);
    }


}
