package ar.edu.itba.poo.tpe.frontend.pane;

import ar.edu.itba.poo.tpe.frontend.actions.Actions;
import ar.edu.itba.poo.tpe.frontend.pickers.Pickers;
import ar.edu.itba.poo.tpe.frontend.tools.Tools;
import javafx.scene.layout.VBox;

public class ToolsPane extends VBox {

    public ToolsPane(CanvasPane canvasPane, StatusPane statusPane) {

        this.setStyle(
                "-fx-background-color: #999;" +
                        " -fx-padding: 5;" +
                        " -fx-spacing: 20;" +
                        " -fx-pref-width: 100"
        );

        this.getChildren().addAll(
                new Tools(canvasPane, statusPane),
                new Actions(canvasPane, statusPane),
                new Pickers(canvasPane, statusPane)
        );

    }

}
