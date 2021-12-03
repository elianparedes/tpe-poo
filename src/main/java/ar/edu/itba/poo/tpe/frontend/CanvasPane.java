package ar.edu.itba.poo.tpe.frontend;

import ar.edu.itba.poo.tpe.frontend.drawable.DrawableFigure;
import ar.edu.itba.poo.tpe.frontend.tools.Tool;
import javafx.scene.Cursor;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

//TODO: Unificar los estilos. Armar una sección de estilos en la parte superior de la class?

public class CanvasPane extends Canvas implements MouseEventListener {

    private final GraphicsContext graphicsContext = getGraphicsContext2D();
    private final CanvasState canvasState;
    private Color fillSelectedColor, strokeSelectedColor, selectedFigureColor;
    private double strokeSelectedWidth = 25;

    public CanvasPane(CanvasState canvasState){
        super(800,600);
        this.canvasState = canvasState;
        this.setCursor(Cursor.CROSSHAIR);
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

    @Override
    public void onToolSelect(Tool tool) {
        this.setOnMousePressed(tool.getOnMousePressed());
        this.setOnMouseReleased(tool.getOnMouseRealesed());
        this.setOnMouseDragged(tool.getOnMouseDragged());
    }

    @Override
    public void onToolUnselect() {
        this.setOnMousePressed(null);
        this.setOnMouseDragged(null);
        this.setOnMouseReleased(null);
    }
}
