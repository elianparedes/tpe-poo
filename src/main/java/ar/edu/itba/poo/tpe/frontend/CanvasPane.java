package ar.edu.itba.poo.tpe.frontend;

import ar.edu.itba.poo.tpe.backend.model.Circle;
import ar.edu.itba.poo.tpe.backend.model.Point;
import ar.edu.itba.poo.tpe.backend.model.Rectangle;
import ar.edu.itba.poo.tpe.frontend.drawable.DrawableFigure;
import ar.edu.itba.poo.tpe.frontend.painttools.DrawTool;
import javafx.scene.Cursor;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.TransferMode;
import javafx.scene.paint.Color;

//TODO: Unificar los estilos. Armar una sección de estilos en la parte superior de la class?

public class CanvasPane extends Canvas implements ToolsListener {

    private final GraphicsContext graphicsContext = getGraphicsContext2D();
    private final CanvasState canvasState;
    private Point startPoint, endPoint, selectPoint;
    private DrawableFigure selectedFigure;
    private Color fillSelectedColor, strokeSelectedColor, selectedFigureColor;
    private boolean selectionActive = false;
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

    @Override
    public void onFillColorSelect(Color selectedColor) {
        this.fillSelectedColor = selectedColor;

    }

    @Override
    public void onStrokeColorSelect(Color selectedColor) {
        this.strokeSelectedColor = selectedColor;
    }

    @Override
    public void onStrokeWidthSelect(double selectedWidth) {
        this.strokeSelectedWidth = selectedWidth;
    }

    @Override
    public void onFigureDraw(DrawTool tool) {
        this.onIdle();
        this.setOnMousePressed(e -> {
            endPoint = null;
            startPoint = new Point(e.getX(), e.getY());
        });

        this.setOnMouseDragged(e -> {
            endPoint = new Point(e.getX(), e.getY());
        });

        this.setOnMouseReleased(e -> {
            /*
            TODO: Agregar checkeo para que las figuras se dibujen en diagonal derecha abajo
             */
            if(startPoint == null || endPoint == null || Double.compare(endPoint.distance(startPoint) , 10) < 0 )
                return;

            canvasState.addFigure(tool.createFigure(startPoint, endPoint));
            render();
        });
    }

    public void onSelect() {
        this.onIdle();
        setOnMousePressed(e -> {
                    if ((!selectionActive) && (selectedFigure == null)) {
                        selectPoint = new Point(e.getX(), e.getY());
                        for (DrawableFigure figure : canvasState.figures()) {
                            if (figure.pointBelongs(selectPoint)) {
                                selectedFigure = figure;
                                selectedFigureColor = selectedFigure.getStroke();

                            }
                        }
                        if(selectedFigure != null){
                            selectedFigure.setStroke(Color.RED);
                            render();
                        }
                        return;
                    }
            if (selectionActive)
                startPoint = new Point(e.getX(), e.getY());
                }
        );

        setOnMouseDragged(e -> {
                    if (selectionActive) {
                        Point eventPoint = new Point(e.getX(), e.getY());
                        if (selectedFigure.pointBelongs(startPoint)) {
                            double diffX = (eventPoint.getX() - startPoint.getX());
                            double diffY = (eventPoint.getY() - startPoint.getY());
                            selectedFigure.moveFigure(diffX, diffY);
                        }
                        startPoint = eventPoint;
                        render();
                    }
                }
        );

        setOnMouseReleased(e->{
            if((selectedFigure != null) && (!selectionActive)){
                selectionActive = true;
            return;
            }
            if(selectionActive){
                selectedFigure.setStroke(selectedFigureColor);
                render();
                selectedFigure = null;
                selectionActive = false;
            }

        });

    }

    @Override
    public void onIdle() {

        selectedFigure = null;
        /*
         * Reset de los eventos del Mouse, pues no se espera ningún comportamiento.
         */

        this.setOnMousePressed(null);

        this.setOnMouseDragged(null);

        this.setOnMouseReleased(null);

    }
}
