package ar.edu.itba.poo.tpe.frontend;

import ar.edu.itba.poo.tpe.frontend.drawable.DrawableFigure;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CanvasState {

    private final List<DrawableFigure> list = new ArrayList<>();

    public void addFigure(DrawableFigure figure) {
        list.add(figure);
    }

    public Iterable<DrawableFigure> figures() {
        return new ArrayList<>(list);
    }

    private Map<DrawableFigure, Color> selectedFigures = new HashMap<>();

    public Map<DrawableFigure,Color> getSelectedFigures(){
        return selectedFigures;
    }
}
