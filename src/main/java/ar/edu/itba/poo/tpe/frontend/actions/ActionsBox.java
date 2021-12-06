package ar.edu.itba.poo.tpe.frontend.actions;

import ar.edu.itba.poo.tpe.frontend.pane.CanvasPane;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

/**
 * ActionsBox es el panel de los botones que inconporan un comportamiento que se ve reflejado sobre el
 * canvas. Crea y administra los botones, agregándoles su respectiva Action , es decir, el comportamiento que
 * deberán adoptar al ser presionados.
 */
public class ActionsBox extends VBox {

    public ActionsBox(CanvasPane canvasPane){

        this.setStyle(
                "-fx-spacing: 10"
        );

        DeleteAction deleteAction = new DeleteAction();
        Button delete = new Button("Borrar");
        delete.setMinWidth(90);
        delete.setOnAction(e -> {
            deleteAction.action(canvasPane);
        });

        FrontAction frontAction = new FrontAction();
        Button front = new Button("Al frente");
        front.setMinWidth(90);
        front.setOnAction(e -> {
            frontAction.action(canvasPane);
        });

        BackAction backAction = new BackAction();
        Button back = new Button("Al fondo");
        back.setMinWidth(90);
        back.setOnAction(e -> {
            backAction.action(canvasPane);
        });

        getChildren().addAll(delete,front,back);

    }

}
