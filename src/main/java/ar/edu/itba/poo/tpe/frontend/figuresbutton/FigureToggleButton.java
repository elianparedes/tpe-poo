package ar.edu.itba.poo.tpe.frontend.figuresbutton;

import ar.edu.itba.poo.tpe.frontend.Drawable.DrawableFigure;
import javafx.scene.control.ToggleButton;

public abstract class FigureToggleButton extends ToggleButton {

    public FigureToggleButton(String type){
        super(type);
    }
    public abstract DrawableFigure createFigure();
}
