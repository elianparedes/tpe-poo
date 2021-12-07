package ar.edu.itba.poo.tpe.backend.model.drawable;

import ar.edu.itba.poo.tpe.backend.model.Circle;
import ar.edu.itba.poo.tpe.backend.utils.ColorRGB;

public class DrawableCircle extends DrawableEllipse {

    public DrawableCircle(Circle circle, ColorRGB strokeColor, ColorRGB fillColor, double lineWidth) {
        super(circle, strokeColor, fillColor, lineWidth);
    }

}
