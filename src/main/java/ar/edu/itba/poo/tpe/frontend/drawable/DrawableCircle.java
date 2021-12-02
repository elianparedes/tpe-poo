package ar.edu.itba.poo.tpe.frontend.drawable;

import ar.edu.itba.poo.tpe.backend.model.Circle;
import ar.edu.itba.poo.tpe.backend.model.Point;
import javafx.scene.canvas.GraphicsContext;

public class DrawableCircle extends Circle implements DrawableFigure {
    double diameter = getRadius() * 2;

    public DrawableCircle(Point centerPoint, double radius) {
        super(centerPoint, radius);
    }

    @Override
    public boolean pointBelongs(Point point) {
        return super.pointBelongs(point);
    }

    @Override
    public void setFill(GraphicsContext graphicsContext) {
        graphicsContext.fillOval(getCenterPoint().getX() - getRadius(), getCenterPoint().getY() - getRadius(), diameter, diameter);
    }

    @Override
    public void setStroke(GraphicsContext graphicsContext) {
        graphicsContext.strokeOval(getCenterPoint().getX() - getRadius(), getCenterPoint().getY() - getRadius(), diameter, diameter);
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        DrawableFigure.super.draw(graphicsContext);
    }
}
