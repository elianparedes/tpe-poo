package ar.edu.itba.poo.tpe.frontend;

import ar.edu.itba.poo.tpe.frontend.tools.*;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

//TODO: Unificar los estilos. Armar una sección de estilos en la parte superior de la class?

public class ToolsPane extends VBox {

    private final CanvasPane canvasPane;

    public ToolsPane(CanvasPane canvasPane) {

        this.setStyle(
                "-fx-background-color: #999;" +
                        " -fx-padding: 5;" +
                        " -fx-spacing: 20;" +
                        " -fx-pref-width: 100"
        );

        this.canvasPane = canvasPane;

        this.getChildren().addAll(
                new Tools(canvasPane),
                new Actions(canvasPane),
                new Controls(canvasPane)
        );

    }

}
