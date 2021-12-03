package ar.edu.itba.poo.tpe.frontend.drawable;

import ar.edu.itba.poo.tpe.backend.model.Circle;
import javafx.scene.paint.Color;

public class DrawableCircle extends DrawableEllipse {

    public DrawableCircle(Circle circle, Color stroke, Color fill, double lineWidth) {
        super(circle, stroke, fill, lineWidth);
    }

    public DrawableCircle(Circle circle){
        this(circle, Color.ORANGE, Color.LIGHTBLUE, 5);
    }

}
