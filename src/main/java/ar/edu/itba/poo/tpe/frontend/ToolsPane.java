package ar.edu.itba.poo.tpe.frontend;

import javafx.scene.Cursor;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

import java.util.Arrays;

//TODO: Unificar los estilos. Armar una sección de estilos en la parte superior de la class?

public class ToolsPane extends VBox {

    ToolsListener toolsListener;

    ToggleButton selectionButton = new ToggleButton("Seleccionar");
    ToggleButton rectangleButton = new ToggleButton("Rectángulo");
    ToggleButton circleButton = new ToggleButton("Círculo");

    public ToolsPane(){
        this.setStyle(
                "-fx-background-color: #999;" +
                " -fx-padding: 5;" +
                " -fx-spacing: 10;" +
                " -fx-pref-width: 100"
        );

        ToggleGroup toggleGroup = new ToggleGroup();

        ToggleButton[] toggleButtons = {selectionButton, rectangleButton, circleButton};
        Arrays.stream(toggleButtons).forEach(toggleButton -> {
            toggleButton.setStyle("-fx-min-width: 90");
            toggleButton.setCursor(Cursor.HAND);
            toggleButton.setToggleGroup(toggleGroup);
        });

        getChildren().addAll(toggleButtons);;

    }

    public void setToolsListener(ToolsListener toolsListener){
        this.toolsListener = toolsListener;
    }

}
