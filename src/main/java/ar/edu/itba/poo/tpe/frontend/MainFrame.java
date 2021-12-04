package ar.edu.itba.poo.tpe.frontend;

import javafx.scene.layout.VBox;

public class MainFrame extends VBox {

    public MainFrame() {
        getChildren().add(new AppMenuBar());
        getChildren().add(new PaintPane());
    }

}
