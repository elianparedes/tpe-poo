package ar.edu.itba.poo.tpe.frontend.figuresbutton;

public class CircleToggleButton extends FigureToggleButton{

    public CircleToggleButton(){
        super("Círculo");
    }
    @Override
    public DrawableFigure createFigure() {
        return new DrawableCircle();
    }
}
