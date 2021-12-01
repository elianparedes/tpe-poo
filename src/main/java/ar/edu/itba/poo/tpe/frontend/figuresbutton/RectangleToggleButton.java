package ar.edu.itba.poo.tpe.frontend.figuresbutton;

import ar.edu.itba.poo.tpe.frontend.Drawable.DrawableFigure;
import ar.edu.itba.poo.tpe.frontend.Drawable.DrawableRectangle;

public class RectangleToggleButton extends FigureToggleButton{

    public RectangleToggleButton(){
        super("Rectángulo");
    }
    @Override
    public DrawableFigure createFigure() {
        return new DrawableRectangle();
    }
}
