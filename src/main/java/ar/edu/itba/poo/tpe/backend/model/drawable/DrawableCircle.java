package ar.edu.itba.poo.tpe.backend.model.drawable;

import ar.edu.itba.poo.tpe.backend.model.Circle;

public class DrawableCircle extends DrawableEllipse {

    public DrawableCircle(Circle circle, String strokeColor, String fillColor, double lineWidth) {
        super(circle, strokeColor, fillColor, lineWidth);
    }

}
