package ar.edu.itba.poo.tpe.frontend;

import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;

public class Controls extends VBox {

    public Controls(CanvasPane canvasPane) {

        this.setStyle(
                "-fx-spacing: 10;"
        );

        Label strokeTitle = new Label("Borde");

        Slider strokeSlider = new Slider(1, 50, 25);
        strokeSlider.setShowTickMarks(true);
        strokeSlider.setShowTickLabels(true);
        strokeSlider.setOnMouseReleased(e -> {
            //toolsListener.onStrokeWidthSelect(strokeSlider.getValue());
        });

        ColorPicker strokeColorPicker = new ColorPicker();
        strokeColorPicker.setOnAction(e -> {
            // toolsListener.onStrokeColorSelect(strokeColorPicker.getValue());
        });

        Label fillTitle = new Label("Relleno");

        ColorPicker fillColorPicker = new ColorPicker();
        fillColorPicker.setOnAction(e -> {
            //toolsListener.onFillColorSelect(fillColorPicker.getValue());
        });

        getChildren().addAll(strokeTitle, strokeSlider, strokeColorPicker, fillTitle, fillColorPicker);
    }

}
