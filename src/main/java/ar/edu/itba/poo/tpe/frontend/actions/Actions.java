package ar.edu.itba.poo.tpe.frontend.actions;

import ar.edu.itba.poo.tpe.frontend.pane.CanvasPane;
import ar.edu.itba.poo.tpe.frontend.pane.StatusPane;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class Actions extends VBox {

    public Actions(CanvasPane canvasPane, StatusPane statusPane){

        this.setStyle(
                "-fx-spacing: 10"
        );

        DeleteAction deleteAction = new DeleteAction();
        Button delete = new Button("Borrar");
        delete.setMinWidth(90);
        delete.setOnAction(e -> {
            deleteAction.execute(canvasPane, statusPane);
        });

        FrontAction frontAction = new FrontAction();
        Button front = new Button("Al frente");
        front.setMinWidth(90);
        front.setOnAction(e -> {
            frontAction.execute(canvasPane, statusPane);
        });

        BackAction backAction = new BackAction();
        Button back = new Button("Al fondo");
        back.setMinWidth(90);
        back.setOnAction(e -> {
            backAction.execute(canvasPane, statusPane);
        });

        getChildren().addAll(delete,front,back);

    }

}
