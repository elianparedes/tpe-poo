package ar.edu.itba.poo.tpe.backend.model.drawable;

import ar.edu.itba.poo.tpe.backend.model.Rectangle;
import ar.edu.itba.poo.tpe.backend.utils.ColorRGB;

import java.util.Objects;


public class DrawableRectangle extends DrawableFigure2D{

    public DrawableRectangle(Rectangle rectangle, ColorRGB strokeColor, ColorRGB fillColor, double lineWidth) {
        super(rectangle, strokeColor, fillColor, lineWidth);
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
