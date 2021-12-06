package ar.edu.itba.poo.tpe.frontend.tools;

import ar.edu.itba.poo.tpe.backend.model.Point;
import ar.edu.itba.poo.tpe.frontend.pane.CanvasPane;
import ar.edu.itba.poo.tpe.backend.model.drawable.DrawableFigure;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * DrawingTool administra los eventos para la creación de figuras sobre el canvas.
 */
public abstract class DrawingTool extends Tool {

    protected static final int DRAWING_TOLERANCE =10;
    protected Point startPoint , endPoint;

    public DrawingTool(CanvasPane canvasPane) {
        super(canvasPane);
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
        });
    }

    @Override
    public EventHandler<MouseEvent> onMouseDragged() {
        return (e -> {
            endPoint = new Point(e.getX(),e.getY());
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
