package ar.edu.itba.poo.tpe.frontend;

import ar.edu.itba.poo.tpe.backend.model.Point;
import ar.edu.itba.poo.tpe.backend.model.Rectangle;
import ar.edu.itba.poo.tpe.frontend.drawable.DrawableFigure;
import ar.edu.itba.poo.tpe.frontend.drawable.DrawableRectangle;
import ar.edu.itba.poo.tpe.frontend.tools.Tool;
import javafx.scene.Cursor;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

//TODO: Unificar los estilos. Armar una sección de estilos en la parte superior de la class?

public class CanvasPane extends Canvas{

    private final GraphicsContext graphicsContext = getGraphicsContext2D();
    private final CanvasState canvasState = new CanvasState();
    private Color fillSelectedColor, strokeSelectedColor, selectedFigureColor;
    private double strokeSelectedWidth = 25;

    public CanvasPane(){
        super(800,600);
        this.setCursor(Cursor.CROSSHAIR);
    }

    public void addFigure(DrawableFigure figure){
        canvasState.addFigure(figure);
        render();
    }


    /*public Deque<Pair<DrawableFigure, Color>> getSelectedFigures(){
        return canvasState.getSelectedFigures();
    }*/

    /*public void selectFigures(Deque<DrawableFigure> figures){
        canvasState.selectFigures(figures);
        render();
    }*/

    public Iterable<DrawableFigure> figures(){
        return canvasState.figures();
    }

    public void render() {
        clear();
        for (DrawableFigure drawableFigure : canvasState.figures()) {
            drawableFigure.drawFigure(graphicsContext);
        }
    }

    public void clear() {
        graphicsContext.clearRect(0, 0, this.getWidth(), this.getHeight());
    }

}
