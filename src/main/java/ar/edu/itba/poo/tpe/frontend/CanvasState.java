package ar.edu.itba.poo.tpe.frontend;

import ar.edu.itba.poo.tpe.frontend.Drawable.DrawableFigure;

import java.util.ArrayList;
import java.util.List;

public class CanvasState {

    private final List<DrawableFigure> list = new ArrayList<>();

    public void addFigure(DrawableFigure figure) {
        list.add(figure);
    }

    public Iterable<DrawableFigure> figures() {
        return new ArrayList<>(list);
    }

}
