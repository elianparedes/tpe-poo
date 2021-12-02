package ar.edu.itba.poo.tpe.frontend;

import ar.edu.itba.poo.tpe.backend.model.Circle;
import ar.edu.itba.poo.tpe.backend.model.Point;
import ar.edu.itba.poo.tpe.backend.model.Rectangle;
import ar.edu.itba.poo.tpe.frontend.Drawable.DrawableFigure;
import ar.edu.itba.poo.tpe.frontend.painttools.DrawTool;
import javafx.scene.Cursor;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

//TODO: Unificar los estilos. Armar una sección de estilos en la parte superior de la class?

public class CanvasPane extends Canvas implements ToolsListener {

    private final GraphicsContext graphicsContext = getGraphicsContext2D();
    private final CanvasState canvasState;
    private Point startPoint, endPoint, selectPoint;
    private DrawableFigure selectedFigure;

    public CanvasPane(CanvasState canvasState){
        super(800,600);
        this.canvasState = canvasState;
        this.setCursor(Cursor.CROSSHAIR);
    }

    public void render() {
        clear();
        for (DrawableFigure drawableFigure : canvasState.figures()) {
            drawableFigure.draw(graphicsContext);
        }
    }

    public void clear() {
        graphicsContext.clearRect(0, 0, this.getWidth(), this.getHeight());
    }


    @Override
    public void onFigureDraw(DrawTool tool) {
        this.setOnMousePressed(e -> {
            startPoint = new Point(e.getX(), e.getY());
        });

        this.setOnMouseDragged(e -> {
            endPoint = new Point(e.getX(), e.getY());
        });

        this.setOnMouseReleased(e -> {
            canvasState.addFigure(tool.createFigure(startPoint, endPoint));
            render();
        });
    }

    public void onSelect() {

        setOnMouseClicked(e -> {
                    selectPoint= new Point(e.getX(), e.getY());
                    for (DrawableFigure figure : canvasState.figures()) {
                        if (figure.pointBelongs(selectPoint)) {
                            selectedFigure = figure;
                        }
                    }
                }
        );

        setOnMousePressed(e ->
                startPoint = new Point(e.getX(), e.getY())
        );

        setOnMouseDragged(e -> {

                    Point eventPoint = new Point(e.getX(), e.getY());
                    double diffX = (eventPoint.getX() - startPoint.getX())/100 ;
                    double diffY = (eventPoint.getY() - startPoint.getY())/100 ;
                    if (selectedFigure instanceof Rectangle) {
                        Rectangle rectangle = (Rectangle) selectedFigure;
                        rectangle.getTopLeft().x += diffX;
                        rectangle.getBottomRight().x += diffX;
                        rectangle.getTopLeft().y += diffY;
                        rectangle.getBottomRight().y += diffY;
                    } else if (selectedFigure instanceof Circle) {
                        Circle circle = (Circle) selectedFigure;
                        circle.getCenterPoint().x += diffX;
                        circle.getCenterPoint().y += diffY;
                    }
                    render();

                }
        );

        setOnMouseReleased(e -> {
            selectPoint = null;
        });
    }

    @Override
    public void onIdle() {

        /*
         * Reset de los eventos del Mouse, pues no se espera ningún comportamiento.
         */

        this.setOnMousePressed(null);

        this.setOnMouseDragged(null);

        this.setOnMouseReleased(null);

    }
}
