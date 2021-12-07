package ar.edu.itba.poo.tpe.frontend.tools;

import ar.edu.itba.poo.tpe.backend.CanvasState;
import ar.edu.itba.poo.tpe.backend.model.Point;
import ar.edu.itba.poo.tpe.backend.model.Rectangle;
import ar.edu.itba.poo.tpe.frontend.pane.CanvasPane;
import ar.edu.itba.poo.tpe.frontend.pane.StatusPane;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;


/**
 * SelectionTool adminsitra el comportamiento de selección simple y selección múltiple de figuras.
 * Las figuras seleccionadas muestran su trazo en rojo. Al deseleccionarse, el color de su trazo será el original.
 *
 *  Comportamiento Simple: Al clickear sobre una figura, la misma se muestra seleccionada. Al moverla, seguirá seleccionada
 *  para un nuevo movimiento. Si se desea deseleccionar la figura, clickear en un espacio en blanco en el canvas.
 *
 *  Comportamiento Multiple: Se debe crear un rectángulo de selección. El mismo seleccionará todas las figuras que en
 *  su totalidad pertenézcan al area del rectángulo. Se puede presionar en cualquier sector de la pantalla, iclusive sobre
 *  una figura, para mover las seleccionadas. Al finalizar el movimiento, todas se deseleccionaran.
 */
public class SelectionTool extends Tool {

    private boolean inMultipleSelection = false;
    private Point startPoint = null, endPoint = null;
    private Rectangle selectionRectangle;

    private final CanvasState canvasState;

    public SelectionTool(CanvasPane canvasPane, StatusPane statusPane) {
        super(canvasPane, statusPane);
        this.canvasState = canvasPane.getCanvasState();
    }

    /**
     * Setea los valores por defécto que se consideran necesarios para poder llevar a cabo una próxima selección
     * a la ejecutada al momento de llamar a este método.
     */
    private void resetValues() {
        inMultipleSelection = false;
        canvasState.unselectAllFigures();
    }

    private void updateStatus(){
        statusPane.updateStatus(
                canvasState.hasSelectedFigures() ?
                        "Se seleccionó: " + canvasState.getSelectedFigures() :
                        "Ninguna figura encontrada"
        );
    }

    @Override
    public EventHandler<MouseEvent> onMousePressed() {
        return (e -> {
            startPoint = new Point(e.getX(), e.getY());
            if (inMultipleSelection) {
                if(canvasPane.InStrokeColorPreview())
                    canvasPane.endPreview();
                return;
            }
            if (canvasState.selectedFiguresCount() > 0) {
                canvasState.unselectAllFigures();
            }
            canvasState.selectFigure(startPoint);
            if (canvasState.selectedFiguresCount() != 1) {
                inMultipleSelection = true;
            } else {
                updateStatus();
            }
        });
    }

    @Override
    public EventHandler<MouseEvent> onMouseDragged() {
        return (e -> {
            if (canvasState.hasSelectedFigures()) {
                Point eventPoint = new Point(e.getX(), e.getY());
                double diffX = (eventPoint.getX() - startPoint.getX());
                double diffY = (eventPoint.getY() - startPoint.getY());
                canvasState.moveSelectedFigures(diffX, diffY);
                startPoint = eventPoint;
            }
        });
    }

    @Override
    public EventHandler<MouseEvent> onMouseReleased() {
        return (e -> {
            if (inMultipleSelection) {
                if (canvasState.hasSelectedFigures()) {
                    canvasState.unselectAllFigures();
                    canvasPane.render();
                    resetValues();
                } else {
                    endPoint = new Point(e.getX(), e.getY());
                    selectionRectangle = new Rectangle(startPoint, endPoint);
                    canvasState.selectFiguresWithin(selectionRectangle);
                    updateStatus();
                    if (!canvasState.hasSelectedFigures()) {
                        resetValues();
                    }
                }
            }
        });
    }
}
