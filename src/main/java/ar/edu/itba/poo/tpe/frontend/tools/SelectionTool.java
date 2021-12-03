package ar.edu.itba.poo.tpe.frontend.tools;

import ar.edu.itba.poo.tpe.backend.model.Point;
import ar.edu.itba.poo.tpe.backend.model.Rectangle;
import ar.edu.itba.poo.tpe.frontend.CanvasPane;
import ar.edu.itba.poo.tpe.frontend.CanvasState;
import ar.edu.itba.poo.tpe.frontend.drawable.DrawableFigure;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class SelectionTool implements Tool {
        private DrawableFigure selectedFigure = null;
        private List<DrawableFigure> selectedFigures = new ArrayList<>();
        private Point startPoint = null , endPoint = null;

        private CanvasPane canvasPane;
        private CanvasState canvasState;
        private boolean selectionActive = false;
        private Color selectedFigureColor;
        private Rectangle selectionRectangle;



        /*
        @Override
        public void action(ToolsListener listener) {
                this.canvasPane = canvasPane;
                canvasState = canvasPane.getCanvasState();
                canvasPane.onToolSelect(this);
        }
         */

        @Override
        public void action(CanvasPane canvasPane) {
                this.canvasPane = canvasPane;
                canvasState = canvasPane.getCanvasState();
                canvasPane.onToolSelect(this);
        }

        private void setSelectedFigure(Point selectPoint){
                for(DrawableFigure figure : canvasState.figures()){
                        if(figure.pointBelongs(selectPoint)){
                                selectedFigure = figure;
                                selectedFigureColor = selectedFigure.getStroke();
                        }
                }
        }

        @Override
        public EventHandler<MouseEvent> getOnMousePressed() {
                /*
                Si al presionar el mouse, no hay figuras seleccionadas entonces es porque:
                        - Voy a seleccionar una figura
                        - Voy a crear un rectangulo de seleccion
                Si al presionar el mouse, hay figuras seleccionadas, es porque voy a moverlas
                 */
                if(selectedFigure == null && selectedFigures.isEmpty())
                        return (e -> {
                                Point mousePoint = new Point(e.getX() , e.getY());
                                // Busca si hay figuras en ese punto. Si la hay, sera la figura seleccionada
                                setSelectedFigure(mousePoint);
                                if(selectedFigure != null){
                                        selectedFigure.setStroke(Color.RED);
                                        canvasPane.render();
                                }
                                // Si no toque ninguna figura, debo preparar un rectangulo de seleccion
                                else
                                        startPoint = mousePoint;
                                canvasPane.onToolSelect(this);
                        });
                else return (e ->{
                        startPoint = new Point(e.getX(), e.getY());
                        canvasPane.onToolSelect(this);
                });

        }

        @Override
        public EventHandler<MouseEvent> getOnMouseDragged() {

                /*
                Si arrastro el mouse y hay figuras seleccionadas es porque:
                        - Quiero mover las figuras
                Si arrastro el mouse y no hay figuras seleccionadas es porque:
                        - Estoy arrastando para crear un rectangulo de seleccion
                 */
                if(selectionActive == false)
                        return (e->{canvasPane.onToolSelect(this);});

                if(!(selectedFigures.isEmpty()) || (selectedFigure != null)){
                        return (e -> {
                                Point eventPoint = new Point(e.getX(), e.getY());
                                double diffX = (eventPoint.getX() - startPoint.getX());
                                double diffY = (eventPoint.getY() - startPoint.getY());
                                if (selectedFigure != null) {
                                        if (selectedFigure.pointBelongs(startPoint)) {
                                                selectedFigure.moveFigure(diffX, diffY);
                                        }
                                }
                                else {
                                        for (DrawableFigure figure: selectedFigures) {
                                                figure.moveFigure(diffX,diffY);
                                        }
                                }
                                startPoint = eventPoint;
                                canvasPane.render();
                                canvasPane.onToolSelect(this);
                        });
                }
                System.out.println("llegue hasta este punto");
                return (e->{canvasPane.onToolSelect(this);});
        }


        @Override
        public EventHandler<MouseEvent> getOnMouseRealesed() {

                /*
                Si suelto el mouse y hay una figura seleccionada es porque:
                        -Quiero pintarla de seleccionar
                        -Quiero despintarla porque ya la movi
                Si suelto el mouse y hay figuras seleccionadas es porque:
                        -Quiero despintarlas porque ya las movi
                Si suelto el mouse y no hay figuras seleccionadas es porque:
                        -Quiero crear un rectangulo de seleccion y pintar las figuras que pertenezcan
                 */

                if((selectedFigure == null) && selectedFigures.isEmpty()){
                        return (e->{
                                endPoint = new Point(e.getX() , e.getY());
                                selectionRectangle = new Rectangle(startPoint , endPoint);
                                for (DrawableFigure drawableFigure: canvasState.figures()) {
                                        if(selectionRectangle.containsFigure(drawableFigure.getFigure())) {
                                                selectedFigures.add(drawableFigure);
                                                drawableFigure.setStroke(Color.RED);
                                        }
                                }
                                if(!selectedFigures.isEmpty()){
                                        canvasPane.render();
                                        selectionActive = true;
                                }
                                canvasPane.onToolSelect(this);
                        });
                }
                if(selectedFigure != null){
                        if(selectionActive){
                                return (e->{
                                        selectedFigure.setStroke(selectedFigureColor);
                                        selectedFigure = null;
                                        selectionActive = false;
                                        canvasPane.render();
                                        canvasPane.onToolSelect(this);
                                });
                        }else
                                return (e->{
                                        selectionActive = true;
                                        canvasPane.onToolSelect(this);
                                });
                }
                return (e->{
                        for (DrawableFigure figure: selectedFigures) {
                                figure.setStroke(Color.BLUEVIOLET);
                        }
                        canvasPane.render();
                        selectedFigures = new ArrayList<>();
                        selectionActive = false;
                        canvasPane.onToolSelect(this);
                });
        }
}
