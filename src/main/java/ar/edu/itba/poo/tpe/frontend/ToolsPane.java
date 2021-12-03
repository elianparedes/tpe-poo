package ar.edu.itba.poo.tpe.frontend;

import ar.edu.itba.poo.tpe.frontend.painttools.PaintTool;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

//TODO: Unificar los estilos. Armar una sección de estilos en la parte superior de la class?

public class ToolsPane extends VBox {

    CanvasPane canvasPane;

    public ToolsPane() {
        this.setStyle(
                "-fx-background-color: #999;" +
                        " -fx-padding: 5;" +
                        " -fx-spacing: 10;" +
                        " -fx-pref-width: 100"
        );

        this.getChildren().addAll(
                createToolsModule());
                //createStrokeModule(),
                //createFillModule()
    }

    public void setToolsListener(CanvasPane canvasPane) {
        this.canvasPane = canvasPane;
    }

    private Node createToolsModule() {
        VBox module = new VBox();
        module.setStyle(
                "-fx-spacing: 10;"
        );

        Tools tools = new Tools();
        ToggleGroup toggleGroup = tools.getToggleGroup();
        toggleGroup.selectedToggleProperty().addListener(e -> {
            Toggle selectedToggle = toggleGroup.getSelectedToggle();
            if (selectedToggle == null) {
                canvasPane.onIdle();
                return;
            }
            PaintTool selectedTool = tools.getSelectedTool(selectedToggle);
            selectedTool.action(canvasPane);
        });
        module.getChildren().addAll(tools.getToggleSet());

        return module;
    }

    //TODO: Analizar qué ocurre cuando se selecciona un color por default
    /*
    private Node createStrokeModule() {
        VBox module = new VBox();
        Label strokeTitle = new Label("Borde");

        Slider strokeSlider = new Slider(1, 50, 25);
        strokeSlider.setShowTickMarks(true);
        strokeSlider.setShowTickLabels(true);
        strokeSlider.setOnMouseReleased(e -> {
            toolsListener.onStrokeWidthSelect(strokeSlider.getValue());
        });

        ColorPicker strokeColorPicker = new ColorPicker();
        strokeColorPicker.setOnAction(e -> {
            toolsListener.onStrokeColorSelect(strokeColorPicker.getValue());
        });
        module.getChildren().addAll(strokeTitle, strokeSlider, strokeColorPicker);

        return module;
    }

    private Node createFillModule() {
        VBox module = new VBox();
        Label fillTitle = new Label("Relleno");

        ColorPicker fillColorPicker = new ColorPicker();

        fillColorPicker.setOnAction(e -> {
            toolsListener.onFillColorSelect(fillColorPicker.getValue());
        });

        module.getChildren().addAll(fillTitle, fillColorPicker);

        return module;
    }*/

}
