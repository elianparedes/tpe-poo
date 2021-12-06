package ar.edu.itba.poo.tpe.backend;

import ar.edu.itba.poo.tpe.backend.model.Figure;
import ar.edu.itba.poo.tpe.backend.model.Point;
import ar.edu.itba.poo.tpe.backend.model.drawable.DrawableFigure;
import ar.edu.itba.poo.tpe.backend.model.drawable.DrawableFigure2D;

import java.util.*;

public class CanvasState {

    private final Deque<DrawableFigure> figures = new LinkedList<>();
    private final Deque<DrawableFigure> selectedFigures = new LinkedList<>();

    private final ArrayList<StateListener> listeners = new ArrayList<>();

    public void addStateListener(StateListener stateListener) {
        listeners.add(stateListener);
    }

    public void addFigure(DrawableFigure figure) {
        figures.offer(figure);
        notifyStateChange();
    }

    public void sendToBack(DrawableFigure figure) {
        figures.remove(figure);
        figures.offerFirst(figure);
    }

    public void sendToBack(Deque<DrawableFigure> figures) {
        Iterator<DrawableFigure> it = figures.descendingIterator();
        while (it.hasNext())
            sendToBack(it.next());
    }

    public void bringToFront(DrawableFigure figure) {
        figures.remove(figure);
        figures.offerLast(figure);
    }

    public void bringToFront(Deque<DrawableFigure> figures) {
        for (DrawableFigure figure : figures)
            bringToFront(figure);
    }

    public void unselectAllFigures() {
        selectedFigures.clear();
        notifyStateChange();
    }

    public void selectFigure(Point point) {
        Iterator<DrawableFigure> it = figures.descendingIterator();
        while (it.hasNext()) {
            DrawableFigure figure = it.next();
            if (figure.pointBelongs(point)) {
                selectFigure(figure);
                return;
            }
        }
    }

    public void selectFigure(DrawableFigure figure) {
        selectedFigures.offer(figure);
        notifyStateChange();
    }

    public void selectFiguresWithin(Figure figure){
        for (DrawableFigure target : figures ) {
            if (figure.containsFigure(target.getFigure())){
                selectFigure(target);
            }
        }
    }

    public void removeSelectedFigures() {
        for (DrawableFigure selected : selectedFigures) {
            figures.remove(selected);
        }
        unselectAllFigures();
    }

    public void moveSelectedFigures(double deltaX, double deltaY){
        for (DrawableFigure selected : selectedFigures ) {
            selected.moveFigure(deltaX, deltaY);
        }
        notifyStateChange();
    }

    public boolean isSelected(DrawableFigure figure){
        return selectedFigures.contains(figure);
    }

    public boolean hasSelectedFigures(){
        return !selectedFigures.isEmpty();
    }

    public void setSelectedFiguresFillColor(String color) {
        for (DrawableFigure selected : selectedFigures) {
            if (selected.hasFill()) {
                ((DrawableFigure2D) selected).setFillColor(color); //TODO: Ver este casteo
            }
        }
        notifyStateChange();
    }

    public void setSelectedFiguresStrokeColor(String color){
        for (DrawableFigure selected : selectedFigures) {
            selected.setStrokeColor(color);
        }
        notifyStateChange();
    }

    public void setSelectedFiguresStrokeWidth(double width){
        for (DrawableFigure selected : selectedFigures) {
            selected.setStrokeWidth(width);
        }
        notifyStateChange();
    }

    public int selectedFiguresCount() {
        return selectedFigures.size();
    }

    public Deque<DrawableFigure> getSelectedFigures(){
        return new LinkedList<>(selectedFigures);
    }

    public Deque<DrawableFigure> getFigures() {
        return figures;
    }

    private void notifyStateChange(){
        for (StateListener stateListener :  listeners) {
            stateListener.onStateChange();
        }
    }

}
