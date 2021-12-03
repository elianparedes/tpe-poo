package ar.edu.itba.poo.tpe.frontend.drawable;

import ar.edu.itba.poo.tpe.backend.model.Figure;
import ar.edu.itba.poo.tpe.backend.model.Line;
import ar.edu.itba.poo.tpe.backend.model.Point;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class DrawableLine extends DrawableFigure{
    private Line line;

    public DrawableLine(Line line, Color stroke, Color fill, double lineWidth){
        super(stroke, fill, lineWidth);
        this.line=line;
    }

    public DrawableLine(Line line){
        this(line, Color.ORANGE, Color.LIGHTBLUE, 10);
    }

    @Override
    public Figure getFigure() {
        return line;
    }

    @Override
    public void fillFigure(GraphicsContext gc) {

    }

    @Override
    public void strokeFigure(GraphicsContext gc) {
        gc.strokeLine(line.getStartPoint().getX(), line.getStartPoint().getY(),
                line.getEndPoint().getX(), line.getEndPoint().getY());
    }

    @Override
    public boolean pointBelongs(Point point) {
        return line.pointBelongs(point);
    }

    @Override
    public void moveFigure(double deltaX, double deltaY) {
        line.moveFigure(deltaX, deltaY);
    }
}
