package ar.edu.itba.poo.tpe.frontend;

import ar.edu.itba.poo.tpe.frontend.painttools.PaintTool;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

//TODO: Unificar los estilos. Armar una sección de estilos en la parte superior de la class?

public class ToolsPane extends VBox {

    ToolsListener toolsListener;

    public ToolsPane(){
        this.setStyle(
                "-fx-background-color: #999;" +
                " -fx-padding: 5;" +
                " -fx-spacing: 10;" +
                " -fx-pref-width: 100"
        );

        Tools tools = new Tools();
        ToggleGroup toggleGroup = tools.getToggleGroup();
        getChildren().addAll(tools.getToggleSet());

        /*
         * Para manejar el evento de cambio de estado del ToggleGroup
         */

        toggleGroup.selectedToggleProperty().addListener(e -> {
            Toggle selectedToggle = toggleGroup.getSelectedToggle();
            if(selectedToggle == null) {
                toolsListener.onIdle();
                return;
            }
            PaintTool selectedTool = tools.getSelectedTool(selectedToggle);
            selectedTool.action(toolsListener);
        });

    }

    public void setToolsListener(ToolsListener toolsListener){
        this.toolsListener = toolsListener;
    }

}
