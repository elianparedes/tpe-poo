package ar.edu.itba.poo.tpe.frontend;

import ar.edu.itba.poo.tpe.frontend.actions.DeleteAction;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class Actions extends VBox {

    public Actions(CanvasPane canvasPane){

        this.setStyle(
                "-fx-spacing: 10"
        );

        DeleteAction deleteAction = new DeleteAction();
        Button delete = new Button("Borrar");
        delete.setMinWidth(90);
        delete.setOnAction(e -> {
            deleteAction.action(canvasPane);
        });

        //FrontAction frontAction = new FrontAction();
        Button front = new Button("Al frente");
        front.setMinWidth(90);
        front.setOnAction(e -> {
            //frontAction.action(canvasPane);
        });

        //BackAction backAction = new BackAction();
        Button back = new Button("Al fondo");
        back.setMinWidth(90);
        back.setOnAction(e -> {
            //backAction.action(canvasPane);
        });

        getChildren().addAll(delete,front,back);

    }

}
