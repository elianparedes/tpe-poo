package ar.edu.itba.poo.tpe.frontend;

import ar.edu.itba.poo.tpe.frontend.pickers.FillPicker;
import ar.edu.itba.poo.tpe.frontend.pickers.Picker;
import ar.edu.itba.poo.tpe.frontend.pickers.StrokePicker;
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
        Slider strokeSlider = new Slider(1, 20, 10);

        strokeSlider.setShowTickMarks(true);
        strokeSlider.setShowTickLabels(true);
        strokeSlider.setOnMouseReleased(e -> {
           canvasPane.getCanvasState().setSelectedFiguresStrokeWidth(strokeSlider.getValue());
           canvasPane.render();
        });

        ColorPicker strokeColorPicker = new ColorPicker(); //Si le pongo clase
        StrokePicker strokePicker= new StrokePicker(canvasPane);

        strokeColorPicker.setOnAction(e -> {
            strokePicker.action(strokeColorPicker.getValue());
            canvasPane.render();
        });

        Label fillTitle = new Label("Relleno");
        ColorPicker fillColorPicker = new ColorPicker();
        FillPicker fillPicker = new FillPicker(canvasPane);

        fillColorPicker.setOnAction(e -> {
            fillPicker.action(fillColorPicker.getValue());
            canvasPane.render();
        });



        getChildren().addAll(strokeTitle, strokeSlider, strokeColorPicker, fillTitle, fillColorPicker);
    }

}
