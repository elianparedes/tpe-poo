package ar.edu.itba.poo.tpe.frontend.drawable;

import ar.edu.itba.poo.tpe.backend.model.Ellipse;
import ar.edu.itba.poo.tpe.backend.model.Figure;
import ar.edu.itba.poo.tpe.backend.model.Point;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Objects;


public class DrawableEllipse extends DrawableFigure2D{


    public DrawableEllipse(Ellipse ellipse, Color stroke, Color fill, double lineWidth) {
        super(ellipse, stroke, fill, lineWidth);
    }

    public DrawableEllipse(Ellipse ellipse){
        this(ellipse, Color.ORANGE, Color.LIGHTBLUE, 5);
    }

    @Override
    public void moveFigure(double deltaX, double deltaY) {
        getFigure().moveFigure(deltaX, deltaY);
    }

    @Override
    public boolean pointBelongs(Point point) {
        return getFigure().pointBelongs(point);
    }

    @Override
    public void fillFigure(GraphicsContext gc) {
        Ellipse ellipse= (Ellipse) getFigure();
        double sHa=ellipse.getsHorizontalAxis();
        double sVa=ellipse.getsVerticalAxis();
        Point centerPoint=ellipse.getCenterPoint();
        gc.fillOval(centerPoint.getX() -sHa, centerPoint.getY() - sVa, sHa*2, sVa*2);
    }

    @Override
    public void strokeFigure(GraphicsContext gc) {
        Ellipse ellipse= (Ellipse) getFigure();
        double sHa=ellipse.getsHorizontalAxis();
        double sVa=ellipse.getsVerticalAxis();
        Point centerPoint=ellipse.getCenterPoint();
        gc.strokeOval(centerPoint.getX() -sHa, centerPoint.getY() - sVa, sHa*2, sVa*2);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(!(obj instanceof DrawableEllipse that))
            return false;
        return this.getFigure().equals(that.getFigure());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getFigure());
    }


}
