package ar.edu.itba.poo.tpe.frontend.pane;

import ar.edu.itba.poo.tpe.backend.CanvasState;
import ar.edu.itba.poo.tpe.backend.StateListener;
import ar.edu.itba.poo.tpe.backend.model.Point;
import ar.edu.itba.poo.tpe.backend.model.drawable.DrawableFigure;
import ar.edu.itba.poo.tpe.backend.model.drawable.DrawableFigure2D;
import ar.edu.itba.poo.tpe.backend.utils.ColorRGB;
import javafx.scene.Cursor;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class CanvasPane extends Canvas implements StateListener {

    private final CanvasState canvasState;
    private final GraphicsContext graphicsContext = getGraphicsContext2D();

    private Color selectedFillColor;
    private Color  selectedStrokeColor;
    private Color strokeColorPreview;
    private double selectedStrokeWidth;

    private static final Color SELECTION_STROKE_COLOR = Color.RED;
    private boolean inStrokeColorPreview = false;

    public CanvasPane(CanvasState canvasState, StatusPane statusPane) {
        super(800,600);
        this.canvasState = canvasState;
        this.setCursor(Cursor.CROSSHAIR);
        this.setOnMouseMoved(e -> {
            Point mousePoint = new Point(e.getX(), e.getY());
            statusPane.updateStatusPoint(mousePoint);

            StringBuilder statusString = new StringBuilder();
            for (DrawableFigure figure : canvasState.getFigures() ) {
                if (figure.pointBelongs(mousePoint))
                           statusString.append(figure);
            }

            if (!statusString.isEmpty())
                statusPane.updateStatus(statusString.toString());
        });

        canvasState.addStateListener(this);
    }

    public void render() {
        graphicsContext.clearRect(0, 0, this.getWidth(), this.getHeight());
        for (DrawableFigure drawableFigure : canvasState.getFigures()) {
            graphicsContext.setLineWidth(drawableFigure.getStrokeWidth());

            if(inStrokeColorPreview)
                graphicsContext.setStroke(strokeColorPreview);
            if (canvasState.hasSelectedFigures() && canvasState.isSelected(drawableFigure) && !inStrokeColorPreview)
                graphicsContext.setStroke(SELECTION_STROKE_COLOR);
            else{
                ColorRGB strokeColor = drawableFigure.getStrokeColor();
                graphicsContext.setStroke(Color.color(strokeColor.getRed(), strokeColor.getGreen(), strokeColor.getBlue()));
            }
            if (drawableFigure.hasFill()){
                ColorRGB fillColor = ((DrawableFigure2D) drawableFigure).getFillColor();
                graphicsContext.setFill(Color.color(fillColor.getRed(), fillColor.getGreen(), fillColor.getBlue()));
            }
            drawableFigure.drawFigure();
        }
    }

    @Override
    public void onStateChange() {
        if (!canvasState.hasSelectedFigures())
            inStrokeColorPreview = false;
        render();
    }

    public boolean InStrokeColorPreview(){
        return inStrokeColorPreview;
    }

    public void endPreview(){
        inStrokeColorPreview = false;
        render();
    }

    public void startPreview(Color color){
        inStrokeColorPreview = true;
        strokeColorPreview = color;
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
