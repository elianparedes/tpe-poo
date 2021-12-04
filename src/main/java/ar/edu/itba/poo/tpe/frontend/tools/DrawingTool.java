package ar.edu.itba.poo.tpe.frontend.tools;

import ar.edu.itba.poo.tpe.backend.model.Point;
import ar.edu.itba.poo.tpe.frontend.CanvasPane;
import ar.edu.itba.poo.tpe.frontend.CanvasState;
import ar.edu.itba.poo.tpe.frontend.drawable.DrawableFigure;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public abstract class DrawingTool extends Tool {
    private Point startPoint , endPoint;
    public abstract DrawableFigure createFigure(Point firstPoint, Point secondPoint);

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
            /*
            TODO: Agregar checkeo para que las figuras se dibujen en diagonal derecha abajo
             */
            if(startPoint == null || endPoint == null || Double.compare(endPoint.distance(startPoint) , 10) < 0 )
                return;
            canvasPane.addFigure(createFigure(startPoint, endPoint));
        });
    }
}
