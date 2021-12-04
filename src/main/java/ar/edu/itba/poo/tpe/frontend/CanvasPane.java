package ar.edu.itba.poo.tpe.frontend;

import ar.edu.itba.poo.tpe.frontend.drawable.DrawableFigure;
import ar.edu.itba.poo.tpe.frontend.tools.Tool;
import javafx.scene.Cursor;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Arrays;

//TODO: Unificar los estilos. Armar una sección de estilos en la parte superior de la class?

public class CanvasPane extends Canvas{

    private final GraphicsContext graphicsContext = getGraphicsContext2D();
    private final CanvasState canvasState;
    private Color fillSelectedColor, strokeSelectedColor, selectedFigureColor;
    private double strokeSelectedWidth = 25;

    public CanvasPane(){
        super(800,600);
        this.setCursor(Cursor.CROSSHAIR);
        this.canvasState = new CanvasState();
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

    public void addFigure(DrawableFigure figure){
        canvasState.addFigure(figure);
        render();
    }

    public Iterable<DrawableFigure> figures(){
        return canvasState.figures();
    }

    public CanvasState getCanvasState() {
        return canvasState;
    }

}
