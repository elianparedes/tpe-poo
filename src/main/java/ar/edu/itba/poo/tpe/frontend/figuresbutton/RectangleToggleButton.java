package ar.edu.itba.poo.tpe.frontend.figuresbutton;

public class RectangleToggleButton extends FigureToggleButton{

    public RectangleToggleButton(){
        super("Rectángulo");
    }
    @Override
    public DrawableFigure createFigure() {
        return new DrawableRectangle();
    }
}
