package ar.edu.itba.poo.tpe.frontend.tools;

import ar.edu.itba.poo.tpe.backend.model.Point;
import ar.edu.itba.poo.tpe.backend.model.Rectangle;
import ar.edu.itba.poo.tpe.frontend.CanvasPane;
import ar.edu.itba.poo.tpe.frontend.drawable.DrawableFigure;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.util.*;

public class SelectionTool extends Tool {
    private DrawableFigure selectedFigure = null;
    private Color selectedFigureColor;
    private Map<DrawableFigure,Color> selectedFigures = canvasPane.getCanvasState().getSelectedFigures();
    private Point startPoint = null, endPoint = null;
    private Rectangle selectionRectangle;
    private final String SIMPLE_SELECTION = "Seleccion simple" , MULTIPLE_SELECTION = "Seleccion multiple" , DEFAULT = "default" ;
    private boolean multipleSelectionActive = false;
    private String actionCase = DEFAULT;

    public SelectionTool(CanvasPane canvasPane) {
        super(canvasPane);
    }

    private void setSelectedFigure(Point selectPoint) {
        for (DrawableFigure figure : canvasPane.figures()) {
            if (figure.pointBelongs(selectPoint)) {
                selectedFigure = figure;
                selectedFigureColor = selectedFigure.getStroke();
            }
        }
    }

    private void resetSelectedFigures(){
        Set<Map.Entry<DrawableFigure,Color>> entrySet = selectedFigures.entrySet();
        for (Map.Entry<DrawableFigure,Color> entry : entrySet) {
            entry.getKey().setStroke(entry.getValue());
        }
        canvasPane.getCanvasState().resetSelectedFigures();
        selectedFigures = canvasPane.getCanvasState().getSelectedFigures();
    }

    private void resetValues(){
        actionCase = DEFAULT;
        multipleSelectionActive = false;
        selectedFigure = null;
        selectedFigureColor = null;
        selectedFigures = null;
        startPoint = null;
        endPoint = null;

    };


    @Override
    public EventHandler<MouseEvent> onMousePressed() {

        return switch (actionCase) {
            case MULTIPLE_SELECTION -> (e -> {
                startPoint = new Point(e.getX(), e.getY());
            });

            default -> (e -> {

                startPoint = new Point(e.getX(), e.getY());
                if(selectedFigure != null){
                    selectedFigure.setStroke(selectedFigureColor);
                    selectedFigure = null;
                    canvasPane.render();
                }
                setSelectedFigure(startPoint);
                if(selectedFigure != null){
                    selectedFigureColor = selectedFigure.getStroke();
                    selectedFigure.setStroke(Color.RED);
                    actionCase = SIMPLE_SELECTION;
                    action();
                }

                else {
                    actionCase = MULTIPLE_SELECTION;
                    action();
                }
            });
        };
    }

    @Override
    public EventHandler<MouseEvent> onMouseDragged() {

        /*return (e->{
            if(!(actionCase.equals(MULTIPLE_SELECTION) || actionCase.equals(SIMPLE_SELECTION)))
                return;
            Point eventPoint = new Point(e.getX(), e.getY());
            double diffX = (eventPoint.getX() - startPoint.getX());
            double diffY = (eventPoint.getY() - startPoint.getY());
            if(actionCase.equals(MULTIPLE_SELECTION)){
                if(multipleSelectionActive) {
                    for (DrawableFigure figure : selectedFigures.keySet()) {
                        figure.moveFigure(diffX, diffY);
                    }
                }
            }
            else {
                if (selectedFigure.pointBelongs(startPoint)) {
                    selectedFigure.moveFigure(diffX, diffY);
                }
            }
            startPoint = eventPoint;
            canvasPane.render();
        });*/

       switch (actionCase){
            case MULTIPLE_SELECTION: return (e->{
                if(multipleSelectionActive){
                    Point eventPoint = new Point(e.getX(), e.getY());
                    double diffX = (eventPoint.getX() - startPoint.getX());
                    double diffY = (eventPoint.getY() - startPoint.getY());
                    for (DrawableFigure figure : selectedFigures.keySet()) {
                        figure.moveFigure(diffX, diffY);
                    }
                    startPoint = eventPoint;
                    canvasPane.render();
                }
            });
            case SIMPLE_SELECTION: return (e->{
                Point eventPoint = new Point(e.getX(), e.getY());
                double diffX = (eventPoint.getX() - startPoint.getX());
                double diffY = (eventPoint.getY() - startPoint.getY());
                if (selectedFigure.pointBelongs(startPoint)) {
                    selectedFigure.moveFigure(diffX, diffY);
                }
                startPoint = eventPoint;
                canvasPane.render();
            });
            default: return (null);
        }
    }


    @Override
    public EventHandler<MouseEvent> onMouseReleased() {

        if (actionCase.equals(MULTIPLE_SELECTION)) {
            return (e -> {
                if (multipleSelectionActive) {
                    resetSelectedFigures();
                    canvasPane.render();
                    resetValues();
                } else {
                    endPoint = new Point(e.getX(), e.getY());
                    selectionRectangle = new Rectangle(startPoint, endPoint);
                    selectedFigures = canvasPane.getCanvasState().getSelectedFigures();
                    for (DrawableFigure drawableFigure : canvasPane.figures()) {
                        if (selectionRectangle.containsFigure(drawableFigure.getFigure())) {
                            selectedFigures.put(drawableFigure, drawableFigure.getStroke());
                            drawableFigure.setStroke(Color.RED);
                        }
                    }
                    if (!selectedFigures.isEmpty()) {
                        canvasPane.render();
                        multipleSelectionActive = true;
                    } else {
                        resetValues();
                    }
                }
                action();
            });
        }
        if(actionCase.equals(SIMPLE_SELECTION)){
            return(e->{
                actionCase = DEFAULT;
            });
        }
            return (null);
    }
}
