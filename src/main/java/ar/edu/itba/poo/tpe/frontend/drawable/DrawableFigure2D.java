package ar.edu.itba.poo.tpe.frontend.drawable;

import ar.edu.itba.poo.tpe.backend.model.Figure;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class DrawableFigure2D extends DrawableFigure{
    private Color fill;

    public DrawableFigure2D(Figure figure, Color stroke, Color fill, double lineWidth){
        super(figure, stroke,lineWidth);
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

    public boolean hasFill(){
        return true;
    }

    public Color getFill(){
        return fill;
    }

    public void setFill(Color fill){
        this.fill=fill;
    }

    public abstract void fillFigure(GraphicsContext gc);


}
