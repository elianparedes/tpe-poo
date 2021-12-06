package ar.edu.itba.poo.tpe.backend.model.drawable;

import ar.edu.itba.poo.tpe.backend.model.Figure;

public abstract class DrawableFigure2D extends DrawableFigure {

    private String fillColor;

    public DrawableFigure2D(Figure figure, String stroke, String fill, double lineWidth){
        super(figure, stroke ,lineWidth);
        this.fillColor =fill;
    }

    public void drawFigure(){
        if (drawingFunction != null)
            drawingFunction.draw();
    }

    public boolean hasFill(){
        return true;
    }

    public String getFillColor(){
        return fillColor;
    }

    public void setFillColor(String color){
        this.fillColor = color;
    }

}
