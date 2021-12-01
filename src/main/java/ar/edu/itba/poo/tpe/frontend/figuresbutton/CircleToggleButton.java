package ar.edu.itba.poo.tpe.frontend.figuresbutton;

import ar.edu.itba.poo.tpe.frontend.Drawable.DrawableCircle;
import ar.edu.itba.poo.tpe.frontend.Drawable.DrawableFigure;

public class CircleToggleButton extends FigureToggleButton{

    public CircleToggleButton(){
        super("Círculo");
    }
    @Override
    public DrawableFigure createFigure() {
        return new DrawableCircle();
    }
}
