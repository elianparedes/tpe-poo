package ar.edu.itba.poo.tpe.backend.model.drawable;

import ar.edu.itba.poo.tpe.backend.model.Square;

public class DrawableSquare extends DrawableRectangle{

    public DrawableSquare(Square square, String strokeColor, String fillColor, double lineWidth) {
        super(square, strokeColor, fillColor, lineWidth);
    }
}
