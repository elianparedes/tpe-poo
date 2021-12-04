package ar.edu.itba.poo.tpe.frontend;

import ar.edu.itba.poo.tpe.frontend.tools.*;

import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

public class Tools extends VBox {

    ToggleGroup toggleGroup = new ToggleGroup();


    public Tools(CanvasPane canvasPane) {
        this.setStyle(
                "-fx-spacing: 10;"
        );

        ToggleButton selection = new ToggleButton("Selección");
        selection.setUserData(new SelectionTool(canvasPane));
        selection.selectedProperty().addListener(e -> canvasPane.unselectAllFigures());

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
            if(toggleGroup.getSelectedToggle() == null)
                canvasPane.defaultMouseBehaviour();
            else {
                Tool selectedTool = (Tool) toggleGroup.getSelectedToggle().getUserData();
                selectedTool.action();
            }
        });

        getChildren().addAll(selection, rectangle, circle, square, ellipse, line);

    }

}
