package ar.edu.itba.poo.tpe.backend.model.drawable;

import ar.edu.itba.poo.tpe.backend.model.Point;
import ar.edu.itba.poo.tpe.backend.model.Rectangle;

import java.util.Objects;


public class DrawableRectangle extends DrawableFigure2D{

    public DrawableRectangle(Rectangle rectangle, String strokeColor, String fillColor, double lineWidth) {
        super(rectangle, strokeColor, fillColor, lineWidth);
    }

    @Override
    public boolean pointBelongs(Point point) {
        return getFigure().pointBelongs(point);
    }

    @Override
    public void moveFigure(double deltaX, double deltaY) {
        getFigure().moveFigure(deltaX, deltaY);
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
