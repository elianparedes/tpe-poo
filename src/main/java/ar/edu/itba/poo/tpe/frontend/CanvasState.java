package ar.edu.itba.poo.tpe.frontend;

import ar.edu.itba.poo.tpe.frontend.drawable.DrawableFigure;
import javafx.scene.paint.Color;

import java.util.*;

public class CanvasState {

    private final List<DrawableFigure> list = new ArrayList<>();

    public void addFigure(DrawableFigure figure) {
        list.add(figure);
    }

    public List<DrawableFigure> figures() {
        return list;
    }

    public void deleteAll(Collection<DrawableFigure> collection){list.removeAll(collection);}

    private Map<DrawableFigure, Color> selectedFigures = new HashMap<>();

    public Map<DrawableFigure,Color> getSelectedFigures(){
        return selectedFigures;
    }

    public void resetSelectedFigures(){
        this.selectedFigures = new HashMap<>();
    }
}
