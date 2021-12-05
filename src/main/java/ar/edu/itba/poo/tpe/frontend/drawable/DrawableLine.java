package ar.edu.itba.poo.tpe.frontend.drawable;

import ar.edu.itba.poo.tpe.backend.model.Figure;
import ar.edu.itba.poo.tpe.backend.model.Line;
import ar.edu.itba.poo.tpe.backend.model.Point;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Objects;

public class DrawableLine extends DrawableFigure{

    public DrawableLine(Line line, Color stroke, double lineWidth){
        super(line, stroke, lineWidth);
    }

    public DrawableLine(Line line){
        this(line, Color.ORANGE,  10);
    }

    public boolean hasFill(){
        return false;
    }

    @Override
    public void strokeFigure(GraphicsContext gc) {
        Line line= (Line) getFigure();
        gc.strokeLine(line.getStartPoint().getX(), line.getStartPoint().getY(),
                line.getEndPoint().getX(), line.getEndPoint().getY());
    }

    @Override
    public boolean pointBelongs(Point point) {
        return false;
    }

    @Override
    public void moveFigure(double deltaX, double deltaY) {
        getFigure().moveFigure(deltaX, deltaY);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(!(obj instanceof DrawableLine that))
            return false;
        return this.getFigure().equals(that.getFigure());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getFigure());
    }

}
