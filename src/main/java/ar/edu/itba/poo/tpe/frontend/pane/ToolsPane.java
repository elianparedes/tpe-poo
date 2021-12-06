package ar.edu.itba.poo.tpe.frontend.pane;

import ar.edu.itba.poo.tpe.frontend.actions.ActionsBox;
import ar.edu.itba.poo.tpe.frontend.pickers.PickersBox;
import ar.edu.itba.poo.tpe.frontend.tools.ToolsBox;
import javafx.scene.layout.VBox;

/**
 * ToolsPane es la barra lateral del editor que contiene los controles y herramientas para el dibujado, modificacion
 * y seleccion de figuras.
 */
public class ToolsPane extends VBox {

    public ToolsPane(CanvasPane canvasPane) {

        this.setStyle(
                "-fx-background-color: #999;" +
                        " -fx-padding: 5;" +
                        " -fx-spacing: 20;" +
                        " -fx-pref-width: 100"
        );

        this.getChildren().addAll(
                new ToolsBox(canvasPane),
                new ActionsBox(canvasPane),
                new PickersBox(canvasPane)
        );

    }

}
