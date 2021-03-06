package ar.edu.itba.poo.tpe.backend.model.drawable;

import ar.edu.itba.poo.tpe.backend.model.Ellipse;
import ar.edu.itba.poo.tpe.backend.utils.ColorRGB;

import java.util.Objects;

public class DrawableEllipse extends DrawableFigure2D{


    public DrawableEllipse(Ellipse ellipse, ColorRGB strokeColor, ColorRGB fillColor, double lineWidth) {
        super(ellipse, strokeColor, fillColor, lineWidth);
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
