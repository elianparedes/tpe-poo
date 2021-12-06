package ar.edu.itba.poo.tpe.frontend;

import ar.edu.itba.poo.tpe.backend.CanvasState;
import ar.edu.itba.poo.tpe.frontend.pane.PaintPane;
import javafx.scene.layout.VBox;

public class MainFrame extends VBox {

    public MainFrame(CanvasState canvasState) {
        getChildren().addAll(
                new AppMenuBar(),
                new PaintPane(canvasState)
        );
    }

}
