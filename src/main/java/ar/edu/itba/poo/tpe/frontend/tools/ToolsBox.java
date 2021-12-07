package ar.edu.itba.poo.tpe.frontend.tools;

import ar.edu.itba.poo.tpe.frontend.pane.CanvasPane;

import ar.edu.itba.poo.tpe.frontend.pane.StatusPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

/**
 * ToolsBox es el panel de las herramientas que inconporan un comportamiento que depende de las acciones del mouse sobre
 * el canvas. Crea y administra los botones, agregándoles su respectiva Tool , es decir, el comportamiento que
 * deberán adoptar al ser utilizadas.
 */
public class ToolsBox extends VBox {

    ToggleGroup toggleGroup = new ToggleGroup();

    public ToolsBox(CanvasPane canvasPane, StatusPane statusPane) {

        this.setStyle(
                "-fx-spacing: 10;"
        );

        ToggleButton selection = new ToggleButton("Selección");
        selection.setUserData(new SelectionTool(canvasPane, statusPane));
        selection.selectedProperty().addListener(e-> {
                canvasPane.getCanvasState().unselectAllFigures();
        });

        ToggleButton rectangle = new ToggleButton("Rectángulo");
        rectangle.setUserData(new RectangleTool(canvasPane, statusPane));

        ToggleButton circle = new ToggleButton("Círculo");
        circle.setUserData(new CircleTool(canvasPane, statusPane));

        ToggleButton square = new ToggleButton("Cuadrado");
        square.setUserData(new SquareTool(canvasPane, statusPane));

        ToggleButton ellipse = new ToggleButton("Elipse");
        ellipse.setUserData(new EllipseTool(canvasPane, statusPane));

        ToggleButton line = new ToggleButton("Línea");
        line.setUserData(new LineTool(canvasPane, statusPane));

        ToggleButton[] toggleButtons = {selection, rectangle, circle, square, ellipse, line};

        for (ToggleButton toggle : toggleButtons ) {
            toggle.setMinWidth(90);
            toggle.setToggleGroup(toggleGroup);
        }

        toggleGroup.selectedToggleProperty().addListener(e -> {
            if(toggleGroup.getSelectedToggle() == null){
                canvasPane.defaultMouseBehaviour();}
            else {
                /*
                 * El casteo es seguro pues siempre se estan guardando tools en los botones.
                 * De todas maneras, la función getUserData devuelve un Object, por lo que el casteo es necesario.
                 */
                Tool selectedTool = (Tool) toggleGroup.getSelectedToggle().getUserData();
                selectedTool.execute();
            }
        });

        getChildren().addAll(selection, rectangle, circle, square, ellipse, line);

    }

}
