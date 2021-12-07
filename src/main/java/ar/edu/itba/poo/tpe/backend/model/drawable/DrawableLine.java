package ar.edu.itba.poo.tpe.backend.model.drawable;

import ar.edu.itba.poo.tpe.backend.model.Line;
import ar.edu.itba.poo.tpe.backend.model.Point;
import ar.edu.itba.poo.tpe.backend.utils.ColorRGB;

import java.util.Objects;

public class DrawableLine extends DrawableFigure {

    public DrawableLine(Line line, ColorRGB strokeColor, double lineWidth){
        super(line, strokeColor, lineWidth);
    }

    public boolean hasFill(){
        return false;
    }

    @Override
    public boolean pointBelongs(Point point) {
        return false;
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
