package ar.edu.itba.poo.tpe.backend.model.drawable;

import ar.edu.itba.poo.tpe.backend.model.Figure;
import ar.edu.itba.poo.tpe.backend.utils.ColorRGB;

/**
 * Clase que modela una figura en dos dimensiones
 */
public abstract class DrawableFigure2D extends DrawableFigure {

    private ColorRGB fillColor;

    public DrawableFigure2D(Figure figure, ColorRGB strokeColor, ColorRGB fillColor, double lineWidth){
        super(figure, strokeColor,lineWidth);
        this.fillColor = fillColor;
    }

    public void drawFigure(){
        if (drawingFunction != null)
            drawingFunction.draw();
    }

    public boolean hasFill(){
        return true;
    }

    public ColorRGB getFillColor(){
        return fillColor;
    }

    public void setFillColor(ColorRGB color){
        this.fillColor = color;
    }

}
