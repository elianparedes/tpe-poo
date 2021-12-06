package ar.edu.itba.poo.tpe.frontend.tools;

import ar.edu.itba.poo.tpe.frontend.pane.CanvasPane;

import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

/**
 * Tools es el panel de las herramientas que inconporan un comprotamiento que depende de las acciones del mouse sobre el
 * canvas. Crea y administra los botones, agregandoles su respectiva Tool , es decir, el comportamiento que deberan adoptar
 * al ser utilizadas.
 */
public class ToolsBox extends VBox {

    ToggleGroup toggleGroup = new ToggleGroup();

    public ToolsBox(CanvasPane canvasPane) {
        this.setStyle(
                "-fx-spacing: 10;"
        );

        ToggleButton selection = new ToggleButton("Selección");
        selection.setUserData(new SelectionTool(canvasPane));
        selection.selectedProperty().addListener(e-> {
                canvasPane.getCanvasState().unselectAllFigures();
        });

        ToggleButton rectangle = new ToggleButton("Rectángulo");
        rectangle.setUserData(new RectangleTool(canvasPane));

        ToggleButton circle = new ToggleButton("Círculo");
        circle.setUserData(new CircleTool(canvasPane));

        ToggleButton square = new ToggleButton("Cuadrado");
        square.setUserData(new SquareTool(canvasPane));

        ToggleButton ellipse = new ToggleButton("Elipse");
        ellipse.setUserData(new EllipseTool(canvasPane));

        ToggleButton line = new ToggleButton("Línea");
        line.setUserData(new LineTool(canvasPane));

        ToggleButton[] toggleButtons = {selection, rectangle, circle, square, ellipse, line};

        for (ToggleButton toggle : toggleButtons ) {
            toggle.setMinWidth(90);
            toggle.setToggleGroup(toggleGroup);
        }

        toggleGroup.selectedToggleProperty().addListener(e -> {
            if(toggleGroup.getSelectedToggle() == null){
                canvasPane.defaultMouseBehaviour();}
            else {
                Tool selectedTool = (Tool) toggleGroup.getSelectedToggle().getUserData();
                selectedTool.execute();
            }

        });
        getChildren().addAll(selection, rectangle, circle, square, ellipse, line);

    }

}
