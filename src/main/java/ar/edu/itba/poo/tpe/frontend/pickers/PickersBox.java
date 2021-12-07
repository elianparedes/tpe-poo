package ar.edu.itba.poo.tpe.frontend.pickers;

import ar.edu.itba.poo.tpe.backend.CanvasState;
import ar.edu.itba.poo.tpe.backend.model.drawable.DrawableFigure;
import ar.edu.itba.poo.tpe.backend.model.drawable.DrawableFigure2D;
import ar.edu.itba.poo.tpe.frontend.pane.CanvasPane;
import ar.edu.itba.poo.tpe.frontend.pane.StatusPane;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 * PickersBox es el panel de pickers y sliders que incorporan el comportamiento de modificación de figuras (grosor y
 * color de borde, color de relleno)
 * Cada picker implementa su comportamiento mediante la clase Picker, que ejecuta la modificación cuando se elige un color
 */
public class PickersBox extends VBox {

    private static final Color DEFAULT_FILL_COLOR = Color.YELLOW;
    private static final Color DEFAULT_STROKE_COLOR = Color.BLACK;
    private static final double DEFAULT_STROKE_WIDTH = 10;

    private final CanvasState canvasState;

    public PickersBox(CanvasPane canvasPane, StatusPane statusPane) {

        this.canvasState = canvasPane.getCanvasState();

        this.setStyle(
                "-fx-spacing: 10;"
        );

        canvasPane.setSelectedFillColor(DEFAULT_FILL_COLOR);
        canvasPane.setSelectedStrokeColor(DEFAULT_STROKE_COLOR);
        canvasPane.setSelectedStrokeWidth(DEFAULT_STROKE_WIDTH);

        /**
         *  Slider con su comportamiento implementado cuando se arrastra
         */
        Label strokeTitle = new Label("Borde");
        Slider strokeSlider = new Slider(1, 50, 25);

        strokeSlider.setShowTickMarks(true);
        strokeSlider.setShowTickLabels(true);
        strokeSlider.setValue(DEFAULT_STROKE_WIDTH);
        strokeSlider.setOnMouseDragged(e -> {
            double width = strokeSlider.getValue();
            if (canvasState.hasSelectedFigures())
                canvasState.setSelectedFiguresStrokeWidth(width);
            canvasPane.setSelectedStrokeWidth(width);
            statusPane.updateStatusWidth(width);
        });

        /**
         *  Pickers con su comportamiento implementado cuando se selecciona un color
         */
        ColorPicker strokeColorPicker = new ColorPicker();
        StrokePicker strokePicker = new StrokePicker(canvasPane, statusPane);

        strokeColorPicker.setValue(DEFAULT_STROKE_COLOR);
        strokeColorPicker.setOnAction(e -> {
            strokePicker.action(strokeColorPicker.getValue());
        });

        Label fillTitle = new Label("Relleno");
        ColorPicker fillColorPicker = new ColorPicker();
        FillPicker fillPicker = new FillPicker(canvasPane, statusPane);

        fillColorPicker.setValue(DEFAULT_FILL_COLOR);
        fillColorPicker.setOnAction(e -> {
            fillPicker.action(fillColorPicker.getValue());
        });

        /**
         *  Se añade un observador al canvasState para que cuando se seleccionen figuras tanto los pickers como el slider
         *  se fijen en los valores de la ultima figura seleccionada
         */
        canvasState.addStateListener(() -> {
            if (canvasState.hasSelectedFigures()) {
                for (DrawableFigure figure : canvasState.getSelectedFigures()) {
                    if (figure.hasFill())
                        fillColorPicker.setValue(Color.valueOf(((DrawableFigure2D) figure).getFillColor()));
                    strokeColorPicker.setValue(Color.valueOf(figure.getStrokeColor()));
                    strokeSlider.setValue(figure.getStrokeWidth());
                }
            }
        });

        getChildren().addAll(strokeTitle, strokeSlider, strokeColorPicker, fillTitle, fillColorPicker);
    }

}
