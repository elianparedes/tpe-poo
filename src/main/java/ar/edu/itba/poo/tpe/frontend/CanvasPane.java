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


        DrawableRectangle rect1 = new DrawableRectangle(
                new Rectangle(new Point(50,50), new Point(200,200)), Color.BLACK, Color.BLUE, 5);

        DrawableRectangle rect2 = new DrawableRectangle(
                new Rectangle(new Point(75,75), new Point(225,225)), Color.BLACK, Color.YELLOW, 5);

        DrawableRectangle rect3 = new DrawableRectangle(
                new Rectangle(new Point(100,100), new Point(250,250)), Color.BLACK, Color.RED, 5);

        DrawableRectangle rect4 = new DrawableRectangle(
                new Rectangle(new Point(125,125), new Point(300,300)), Color.BLACK, Color.GREEN, 5);

        DrawableRectangle rect5 = new DrawableRectangle(
                new Rectangle(new Point(150,150), new Point(350,350)), Color.BLACK, Color.PURPLE, 5);

        addFigure(rect1);
        addFigure(rect2);
        addFigure(rect3);
        addFigure(rect4);
        addFigure(rect5);

        /*Deque<DrawableFigure> select = new LinkedList<>();

        select.add(rect1);
        select.add(rect2);

        canvasState.selectFigure(rect2);
        canvasState.selectFigure(rect1);*/

        render();

    }

    public void addFigure(DrawableFigure figure){
        canvasState.addFigure(figure);
        render();
    }

    public Deque<DrawableFigure> getSelectedFigures(){
        return canvasState.getSelectedFigures();
    }


    public Iterable<DrawableFigure> figures(){
        return canvasState.figures();
    }

    public void unselectAllFigures(){
        canvasState.unselectAllFigures();
        render();
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

    public CanvasState getCanvasState() {
        return canvasState;
    }

    public void defaultMouseBehaviour(){
        setOnMouseClicked(null);
        setOnMouseDragged(null);
        setOnMouseReleased(null);
    }
}
