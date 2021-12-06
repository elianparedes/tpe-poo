package ar.edu.itba.poo.tpe.frontend.pane;

import ar.edu.itba.poo.tpe.backend.CanvasState;
import ar.edu.itba.poo.tpe.backend.StateListener;
import ar.edu.itba.poo.tpe.backend.model.drawable.DrawableFigure;
import ar.edu.itba.poo.tpe.backend.model.drawable.DrawableFigure2D;
import javafx.scene.Cursor;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class CanvasPane extends Canvas implements StateListener {

    private final CanvasState canvasState;
    private final GraphicsContext graphicsContext = getGraphicsContext2D();

    private Color selectedFillColor = Color.YELLOW;
    private Color  selectedStrokeColor = Color.CORNFLOWERBLUE;
    private double selectedStrokeWidth = 5;

    private static final Color SELECTION_STROKE_COLOR = Color.RED;
    private boolean inSelectionPreview = false;

    public CanvasPane(CanvasState canvasState) {
        super(800,600);
        this.canvasState = canvasState;
        this.setCursor(Cursor.CROSSHAIR);
        canvasState.addStateListener(this);
    }


    public void render() {
        graphicsContext.clearRect(0, 0, this.getWidth(), this.getHeight());
        for (DrawableFigure drawableFigure : canvasState.getFigures()) {
            graphicsContext.setLineWidth(drawableFigure.getStrokeWidth());

            if (canvasState.hasSelectedFigures() && canvasState.isSelected(drawableFigure) && !inSelectionPreview)
                graphicsContext.setStroke(SELECTION_STROKE_COLOR);
            else
                graphicsContext.setStroke(Color.valueOf(drawableFigure.getStrokeColor()));

            if (drawableFigure.hasFill())
                graphicsContext.setFill(Color.valueOf(((DrawableFigure2D) drawableFigure).getFillColor()));
            drawableFigure.drawFigure();
        }
    }

    @Override
    public void onStateChange() {
        if (!canvasState.hasSelectedFigures())
            inSelectionPreview = false;
        render();
    }

    public void strokeColorPreview(String color){
        inSelectionPreview = true;
        graphicsContext.setStroke(Color.valueOf(color));
        canvasState.setSelectedFiguresStrokeColor(color);
    }


    public void defaultMouseBehaviour(){
        this.setOnMousePressed(null);
        this.setOnMouseDragged(null);
        this.setOnMouseReleased(null);
    }

    public CanvasState getCanvasState() {
        return canvasState;
    }

    public GraphicsContext getGraphicsContext(){
        return graphicsContext;
    }

    public Color getSelectedFillColor() {
        return selectedFillColor;
    }

    public Color getSelectedStrokeColor() {
        return selectedStrokeColor;
    }

    public double getSelectedStrokeWidth() {
        return selectedStrokeWidth;
    }

    public void setSelectedFillColor(Color selectedFillColor) {
        this.selectedFillColor = selectedFillColor;
    }

    public void setSelectedStrokeColor(Color selectedStrokeColor) {
        this.selectedStrokeColor = selectedStrokeColor;
    }

    public void setSelectedStrokeWidth(double selectedStrokeWidth) {
        this.selectedStrokeWidth = selectedStrokeWidth;
    }
}
