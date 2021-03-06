package ar.edu.itba.poo.tpe.frontend.tools;

import ar.edu.itba.poo.tpe.backend.model.Point;
import ar.edu.itba.poo.tpe.frontend.pane.CanvasPane;
import ar.edu.itba.poo.tpe.backend.model.drawable.DrawableFigure;
import ar.edu.itba.poo.tpe.frontend.pane.StatusPane;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * DrawingTool administra los eventos para la creación de figuras sobre el canvas.
 *
 * Para dibujar una figura en el canvas, se debe realizar un primer click el cual colocará un primer punto. El mouse
 * debe ser arrastrado en direcciones de un cuarto cuadrante de un sistema de coordenadas y luego se debe realizar un
 * segundo click. Dichos dos puntos determinan la figura. Cada figura los utilizará, a su manera, para determinárse
 * a sí mismas.
 */
public abstract class DrawingTool extends Tool {

    protected static final int DRAWING_TOLERANCE =10;
    protected Point startPoint , endPoint;

    public DrawingTool(CanvasPane canvasPane, StatusPane statusPane) {
        super(canvasPane, statusPane);
    }

    /**
     *Crea una DrawableFigure a partir de dos puntos.
     *
     * @param firstPoint primer punto del dibujado de la figura
     * @param secondPoint segundo punto del dibujado de la figura
     * @return DrawableFigure que haga referencia al nombre de la tool.
     */
    public abstract DrawableFigure createFigure(Point firstPoint, Point secondPoint);

    /**
     * Setea la drawingFunction de la figura
     *
     * @param drawableFigure
     */
    protected abstract void setDrawingFunction(DrawableFigure drawableFigure);

    @Override
    public EventHandler<MouseEvent> onMousePressed() {
        return (e -> {
            endPoint = null;
            startPoint = new Point(e.getX(),e.getY());
            statusPane.updateStatusPoint(startPoint);
        });
    }

    @Override
    public EventHandler<MouseEvent> onMouseDragged() {
        return (e -> {
            endPoint = new Point(e.getX(),e.getY());
            statusPane.updateStatusPoint(endPoint);
        });
    }

    @Override
    public EventHandler<MouseEvent> onMouseReleased() {
        return (e->{
            if(startPoint == null || endPoint == null || !startPoint.isLower(endPoint) ||
                    Double.compare(endPoint.distance(startPoint) , DRAWING_TOLERANCE) < 0 )
                return;
            canvasPane.getCanvasState().addFigure(createFigure(startPoint, endPoint));
        });
    }

}
