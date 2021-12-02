package ar.edu.itba.poo.tpe.frontend.drawable;

import ar.edu.itba.poo.tpe.backend.model.Point;
import ar.edu.itba.poo.tpe.backend.model.Rectangle;
import javafx.scene.canvas.GraphicsContext;

public class DrawableRectangle extends Rectangle implements DrawableFigure{

    public DrawableRectangle(Point topLeft, Point bottomRight) {
        super(topLeft, bottomRight);
    }

    @Override
    public boolean pointBelongs(Point point) {
        return super.pointBelongs(point);
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        DrawableFigure.super.draw(graphicsContext);
    }

    @Override
    public void setFill(GraphicsContext graphicsContext) {
        graphicsContext.fillRect(getTopLeft().getX(), getTopLeft().getY(),
                Math.abs(getTopLeft().getX() - getBottomRight().getX()), Math.abs(getTopLeft().getY() - getBottomRight().getY()));
    }

    @Override
    public void setStroke(GraphicsContext graphicsContext) {
        graphicsContext.strokeRect(getTopLeft().getX(), getTopLeft().getY(),
                Math.abs(getTopLeft().getX() - getBottomRight().getX()), Math.abs(getTopLeft().getY() - getBottomRight().getY()));
    }

}
