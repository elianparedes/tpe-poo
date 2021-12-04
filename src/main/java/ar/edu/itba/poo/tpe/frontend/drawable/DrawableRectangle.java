package ar.edu.itba.poo.tpe.frontend.drawable;

import ar.edu.itba.poo.tpe.backend.model.Figure;
import ar.edu.itba.poo.tpe.backend.model.Point;
import ar.edu.itba.poo.tpe.backend.model.Rectangle;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Objects;

public class DrawableRectangle extends DrawableFigure{
    private Rectangle rectangle;
    public DrawableRectangle(Rectangle rectangle, Color stroke, Color fill, double lineWidth) {
        super(stroke, fill, lineWidth);
        this.rectangle=rectangle;
    }

    public DrawableRectangle(Rectangle rectangle){
        this(rectangle, Color.ORANGE, Color.LIGHTBLUE, 5);
    }

    @Override
    public Figure getFigure() {
        return rectangle;
    }

    @Override
    public boolean pointBelongs(Point point) {
        return rectangle.pointBelongs(point);
    }

    @Override
    public void moveFigure(double deltaX, double deltaY) {
        rectangle.moveFigure(deltaX, deltaY);
    }

    @Override
    public void fillFigure(GraphicsContext gc) {
        Point topLeft= rectangle.getTopLeft();
        Point bottomRight=rectangle.getBottomRight();
        gc.fillRect(topLeft.getX(), topLeft.getY(),
                Math.abs(topLeft.getX() - bottomRight.getX()), Math.abs(topLeft.getY() - bottomRight.getY()));
    }

    @Override
    public void strokeFigure(GraphicsContext gc) {
        Point topLeft= rectangle.getTopLeft();
        Point bottomRight=rectangle.getBottomRight();
        gc.strokeRect(topLeft.getX(), topLeft.getY(),
                Math.abs(topLeft.getX() - bottomRight.getX()), Math.abs(topLeft.getY() - bottomRight.getY()));
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(!(obj instanceof DrawableRectangle that))
            return false;
        return this.getFigure().equals(that.getFigure());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getFigure());
    }


}
