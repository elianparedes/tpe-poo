package ar.edu.itba.poo.tpe.frontend;

import ar.edu.itba.poo.tpe.backend.model.Point;
import ar.edu.itba.poo.tpe.backend.utils.Pair;
import ar.edu.itba.poo.tpe.frontend.drawable.DrawableFigure;
import javafx.scene.paint.Color;

import java.util.*;

public class CanvasState {

    private final Deque<DrawableFigure> figures = new LinkedList<>();
    private final Deque<Pair<DrawableFigure, Color>> selectedFigures = new LinkedList<>();

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

    public void unselectAllFigures(){
        for (Pair<DrawableFigure, Color> selection : selectedFigures )
            selection.getKey().setStroke(selection.getValue());
        selectedFigures.clear();
    }

    public void selectFigure(Point point){
        Iterator<DrawableFigure> it = figures.descendingIterator();
        while (it.hasNext()) {
            DrawableFigure figure = it.next();
            if (figure.pointBelongs(point)) {
                selectFigure(figure);
                return;
            }
        }
    }

    public int selectedFiguresCount(){
        return selectedFigures.size();
    }

    public void selectFigure(DrawableFigure figure){
        selectedFigures.add(new Pair<>(figure, figure.getStroke()));
        figure.setStroke(Color.RED);
    }

    public void removeSelectedFigures(){
        for (Pair<DrawableFigure,Color> selectedFigure: selectedFigures) {
            figures.remove(selectedFigure.getKey());
        }
        selectedFigures.clear();
    }

    public void setSelectedFiguresFillColor(Color color){
        for (Pair<DrawableFigure, Color> selection : selectedFigures ) {
            //selection.getKey().setFill(color);
        }
    }

    public void setSelectedFiguresStrokeColor(Color color){
        for (Pair<DrawableFigure, Color> selection : selectedFigures) {
            selection.setValue(color);
        }
    }

    public void setSelectedFiguresStrokeWidth(double width){
        for (Pair<DrawableFigure, Color> selection : selectedFigures) {
            selection.getKey().setLineWidth(width);
        }
    }

    public void selectFigures(Deque<DrawableFigure> figures){
        for (DrawableFigure figure : figures ) {
            selectFigure(figure);
        }
    }

    public void removeFigure(DrawableFigure figure){
        figures.remove(figure);
    }

    public DrawableFigure getSelectedFigure(){
        return selectedFigures.getFirst().getKey();
    }

    public boolean hasSelectedFigures(){
        return !selectedFigures.isEmpty();
    }

    public Deque<DrawableFigure> getSelectedFigures(){
        Deque<DrawableFigure> selection = new LinkedList<>();
        for (Pair<DrawableFigure, Color> figure : selectedFigures ) {
            selection.add(figure.getKey());
        }
        return selection;
    }

    public Deque<DrawableFigure> figures() {
        return figures;
    }

}
