package ar.edu.itba.poo.tpe.frontend.drawable;

import ar.edu.itba.poo.tpe.backend.model.Point;
import ar.edu.itba.poo.tpe.backend.model.Rectangle;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class DrawableRectangle extends DrawableFigure{
    private Rectangle rectangle;
    public DrawableRectangle(Rectangle rectangle, double stroke, Color fill) {
        super(stroke, fill);
        this.rectangle=rectangle;
    }

    public DrawableRectangle(Rectangle rectangle){
        this(rectangle, 1, Color.YELLOW);

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

}
