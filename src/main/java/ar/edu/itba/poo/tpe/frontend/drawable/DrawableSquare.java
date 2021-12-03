package ar.edu.itba.poo.tpe.frontend.drawable;

import ar.edu.itba.poo.tpe.backend.model.Square;
import javafx.scene.paint.Color;

public class DrawableSquare extends DrawableRectangle{

    public DrawableSquare(Square square, Color stroke, Color fill, double lineWidth) {
        super(square, stroke, fill, lineWidth);
    }
    public DrawableSquare(Square square){
        this(square, Color.ORANGE, Color.LIGHTBLUE, 5);
    }
}
