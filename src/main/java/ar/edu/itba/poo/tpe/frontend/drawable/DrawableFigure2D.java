package ar.edu.itba.poo.tpe.frontend.drawable;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class DrawableFigure2D extends DrawableFigure{
    private Color fill;

    public DrawableFigure2D(Color stroke, Color fill, double lineWidth){
        super(stroke,lineWidth);
        this.fill=fill;
    }

    public void drawFigure(GraphicsContext gc){
        setGraphicsContext(gc);
        fillFigure(gc);
        strokeFigure(gc);
    }

    @Override
    protected void setGraphicsContext(GraphicsContext gc){
        super.setGraphicsContext(gc);
        gc.setFill(fill);
    }

    public Color getFill(){
        return fill;
    }

    public void setFill(Color fill){
        this.fill=fill;
    }

    public abstract void fillFigure(GraphicsContext gc);


}
