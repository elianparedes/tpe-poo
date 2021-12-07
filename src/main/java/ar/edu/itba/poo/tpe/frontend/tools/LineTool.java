package ar.edu.itba.poo.tpe.frontend.tools;

import ar.edu.itba.poo.tpe.backend.model.Line;
import ar.edu.itba.poo.tpe.backend.model.Point;
import ar.edu.itba.poo.tpe.backend.utils.ColorRGB;
import ar.edu.itba.poo.tpe.frontend.pane.CanvasPane;
import ar.edu.itba.poo.tpe.backend.model.drawable.DrawableFigure;
import ar.edu.itba.poo.tpe.backend.model.drawable.DrawableLine;
import ar.edu.itba.poo.tpe.frontend.pane.StatusPane;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class LineTool extends DrawingTool{
    public LineTool(CanvasPane canvasPane, StatusPane statusPane) {
        super(canvasPane, statusPane);
    }

    @Override
    public DrawableFigure createFigure(Point firstPoint, Point secondPoint) {

        Color strokeColor = canvasPane.getSelectedStrokeColor();

        DrawableLine figure = new DrawableLine(
                new Line(firstPoint, secondPoint),
                new ColorRGB(strokeColor.getRed(), strokeColor.getGreen(), strokeColor.getBlue()),
                canvasPane.getSelectedStrokeWidth()
        );

        setDrawingFunction(figure);

        return figure;
    }

    @Override
    protected void setDrawingFunction(DrawableFigure drawableFigure) {
        drawableFigure.setDrawingFunction(() -> {
            /**
             * El casteo es seguro pues el llamado a la funcion se realiza desde el metodo CreateFigure, donde se
             * asegura que la figura creada se corresponde con la herramienta. Al ser protected, no se podra llamar al
             * metodo con una figura que cause un error de ejecucion por el casteo.
             */
            Line line = (Line) drawableFigure.getFigure();
            graphicsContext.strokeLine(
                    line.getStartPoint().getX(),
                    line.getStartPoint().getY(),
                    line.getEndPoint().getX(),
                    line.getEndPoint().getY()
            );
        });
    }

    @Override
    public EventHandler<MouseEvent> onMouseReleased() {
        return (e->{
            if(startPoint == null || endPoint == null || Double.compare(endPoint.distance(startPoint) , DRAWING_TOLERANCE) < 0 )
                return;
            canvasPane.getCanvasState().addFigure(createFigure(startPoint, endPoint));
        });
    }

}
