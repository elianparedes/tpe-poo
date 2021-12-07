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

/**
 * Panel de visualizacion del area de trabajo y renderizado de figuras
 */
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

    /**
     * Establece los valores de trazo y relleno para el renderizado de las figuras.Contempla distintos casos como
     * una preview de seleccion de trazos, o renderizado con borde en rojo para figuras seleccionadas
     */
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

    /**
     * Metodo de la interfaz StateListener que se ejecuta cada vez que se realiza un cambio en el canvasState
     */
    @Override
    public void onStateChange() {
        if (!canvasState.hasSelectedFigures())
            inStrokeColorPreview = false;
        render();
    }

    public boolean InStrokeColorPreview(){
        return inStrokeColorPreview;
    }

    /**
     * Finaliza el renderizado en modo preview, permitiendo reestablecer el comportamiento general de seleccion
     * de figuras y visualizacion de figuras
     */
    public void endPreview(){
        inStrokeColorPreview = false;
        render();
    }

    /**
     * Establece un renderizado especifico para mostrar una preview al usuario de los colores del stroke
     * @param color del stroke seleccionado en el picker
     */
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
