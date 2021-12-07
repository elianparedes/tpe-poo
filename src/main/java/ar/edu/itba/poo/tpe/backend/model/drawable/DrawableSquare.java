package ar.edu.itba.poo.tpe.backend.model.drawable;

import ar.edu.itba.poo.tpe.backend.model.Square;
import ar.edu.itba.poo.tpe.backend.utils.ColorRGB;

public class DrawableSquare extends DrawableRectangle{

    public DrawableSquare(Square square, ColorRGB strokeColor, ColorRGB fillColor, double lineWidth) {
        super(square, strokeColor, fillColor, lineWidth);
    }
}
