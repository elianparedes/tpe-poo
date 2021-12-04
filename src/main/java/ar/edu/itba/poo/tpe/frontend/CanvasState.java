package ar.edu.itba.poo.tpe.frontend;

import ar.edu.itba.poo.tpe.frontend.drawable.DrawableFigure;
import javafx.scene.paint.Color;
import javafx.util.Pair;

import java.util.*;

public class CanvasState {

    private final List<DrawableFigure> list = new ArrayList<>();
    private final Deque<DrawableFigure> figures = new LinkedList<>();
    //private final Deque<Pair<DrawableFigure, Color>> selectedFigures = new LinkedList<>();

    public void addFigure(DrawableFigure figure) {
        figures.add(figure);
    }

    public void sendToBack(DrawableFigure figure) {
        figures.remove(figure);
        figures.addFirst(figure);
    }

    public void sendToBack(Deque<DrawableFigure> figures){
        Iterator<DrawableFigure> it = figures.descendingIterator();
        while (it.hasNext())
            sendToBack(it.next());
    }

    public void bringToFront(DrawableFigure figure) {
        figures.remove(figure);
        figures.addLast(figure);
    }

    public void bringToFront(Deque<DrawableFigure> figures){
        for (DrawableFigure figure : figures)
            bringToFront(figure);
    }

    public void deselectAllFigures(){
        selectedFigures.clear();
    }

    public void removeFigure(DrawableFigure figure){
        figures.remove(figure);
    }

    /*public void selectFigure(DrawableFigure figure){
        selectedFigures.add(new Pair<>(figure, figure.getStroke()));
    }*/

    /*public void selectFigures(Deque<DrawableFigure> figures){
        for (DrawableFigure figure : figures ) {
            selectFigure(figure);
        }
    }*/

    /*public Deque<Pair<DrawableFigure, Color>> getSelectedFigures(){
        return selectedFigures;
    }*/

    public Iterable<DrawableFigure> figures() {
        return new ArrayList<>(figures);
    }

    private Map<DrawableFigure, Color> selectedFigures = new HashMap<>();

    public Map<DrawableFigure, Color> getSelectedFigures(){
        return selectedFigures;
    }

}
