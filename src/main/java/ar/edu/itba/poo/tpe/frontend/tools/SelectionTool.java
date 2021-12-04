package ar.edu.itba.poo.tpe.frontend.tools;

import ar.edu.itba.poo.tpe.backend.model.Point;
import ar.edu.itba.poo.tpe.backend.model.Rectangle;
import ar.edu.itba.poo.tpe.frontend.drawable.DrawableFigure;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.util.*;

public class SelectionTool extends Tool {
    private DrawableFigure selectedFigure = null;
    private Color selectedFigureColor;
    private Map<DrawableFigure,Color> selectedFigures = new HashMap<>();
    private Point startPoint = null, endPoint = null;
    private Rectangle selectionRectangle;
    private boolean selectionActive = false;



    private void setSelectedFigure(Point selectPoint) {
        for (DrawableFigure figure : canvasPane.figures()) {
            if (figure.pointBelongs(selectPoint)) {
                selectedFigure = figure;
                selectedFigureColor = selectedFigure.getStroke();
            }
        }
    }

    @Override
    public EventHandler<MouseEvent> onMousePressed() {
                /*
                Si al presionar el mouse, no hay figuras seleccionadas entonces es porque:
                        - Voy a seleccionar una figura
                        - Voy a crear un rectangulo de seleccion
                Si al presionar el mouse, hay figuras seleccionadas, es porque voy a moverlas
                 */
        if (selectedFigure == null && selectedFigures.isEmpty())
            return (e -> {
                Point mousePoint = new Point(e.getX(), e.getY());
                // Busca si hay figuras en ese punto. Si la hay, sera la figura seleccionada
                setSelectedFigure(mousePoint);
                if (selectedFigure != null) {
                    selectedFigure.setStroke(Color.RED);
                    canvasPane.render();
                }
                // Si no toque ninguna figura, debo preparar un rectangulo de seleccion
                else
                    startPoint = mousePoint;
                action(canvasPane);
            });
        else return (e -> {
            startPoint = new Point(e.getX(), e.getY());
            action(canvasPane);
        });

    }

    @Override
    public EventHandler<MouseEvent> onMouseDragged() {

                /*
                Si arrastro el mouse y hay figuras seleccionadas es porque:
                        - Quiero mover las figuras
                Si arrastro el mouse y no hay figuras seleccionadas es porque:
                        - Estoy arrastando para crear un rectangulo de seleccion
                 */
        if (selectionActive == false)
            return (e -> {
                action(canvasPane);
            });

        if (!(selectedFigures.isEmpty()) || (selectedFigure != null)) {
            return (e -> {
                Point eventPoint = new Point(e.getX(), e.getY());


                if (selectedFigure != null) {
                    if (selectedFigure.pointBelongs(startPoint)) {
                        selectedFigure.moveFigure(diffX, diffY);
                    }
                } else {
                    for (DrawableFigure figure : selectedFigures.keySet()) {
                        figure.moveFigure(diffX, diffY);
                    }
                }
                startPoint = eventPoint;
                canvasPane.render();
                action(canvasPane);
            });
        }
        System.out.println("llegue hasta este punto");
        return (e -> {
            action(canvasPane);
        });
    }


    @Override
    public EventHandler<MouseEvent> onMouseReleased() {

                /*
                Si suelto el mouse y hay una figura seleccionada es porque:
                        -Quiero pintarla de seleccionar
                        -Quiero despintarla porque ya la movi
                Si suelto el mouse y hay figuras seleccionadas es porque:
                        -Quiero despintarlas porque ya las movi
                Si suelto el mouse y no hay figuras seleccionadas es porque:
                        -Quiero crear un rectangulo de seleccion y pintar las figuras que pertenezcan
                 */

        if ((selectedFigure == null) && selectedFigures.isEmpty()) {
            return (e -> {
                endPoint = new Point(e.getX(), e.getY());
                selectionRectangle = new Rectangle(startPoint, endPoint);
                for (DrawableFigure drawableFigure : canvasPane.figures()) {
                    if (selectionRectangle.containsFigure(drawableFigure.getFigure())) {
                        selectedFigures.put(drawableFigure,drawableFigure.getStroke());
                        drawableFigure.setStroke(Color.RED);
                    }
                }
                if (!selectedFigures.isEmpty()) {
                    canvasPane.render();
                    selectionActive = true;
                }
                action(canvasPane);
            });
        }
        if (selectedFigure != null) {
            if (selectionActive) {
                return (e -> {
                    selectedFigure.setStroke(selectedFigureColor);
                    selectedFigure = null;
                    selectionActive = false;
                    canvasPane.render();
                    action(canvasPane);
                });
            } else
                return (e -> {
                    selectionActive = true;
                    action(canvasPane);
                });
        }
        return (e -> {
            Set<Map.Entry<DrawableFigure,Color>> entrySet = selectedFigures.entrySet();
            for (Map.Entry<DrawableFigure,Color> entry : entrySet) {
                entry.getKey().setStroke(entry.getValue());
            }
            canvasPane.render();
            selectedFigures = new HashMap<>();
            selectionActive = false;
            action(canvasPane);
        });
    }
}
