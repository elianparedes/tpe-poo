package ar.edu.itba.poo.tpe.frontend.pickers;

import ar.edu.itba.poo.tpe.backend.CanvasState;
import ar.edu.itba.poo.tpe.backend.model.drawable.DrawableFigure;
import ar.edu.itba.poo.tpe.backend.model.drawable.DrawableFigure2D;
import ar.edu.itba.poo.tpe.frontend.pane.CanvasPane;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class PickersBox extends VBox {

    private static final Color DEFAULT_FILL_COLOR = Color.YELLOW;
    private static final Color DEFAULT_STROKE_COLOR = Color.BLACK;
    private static final double DEFAULT_STROKE_WIDTH = 10;

    private final CanvasState canvasState;

    public PickersBox(CanvasPane canvasPane) {

        this.canvasState = canvasPane.getCanvasState();

        this.setStyle(
                "-fx-spacing: 10;"
        );

        canvasPane.setSelectedFillColor(DEFAULT_FILL_COLOR);
        canvasPane.setSelectedStrokeColor(DEFAULT_STROKE_COLOR);
        canvasPane.setSelectedStrokeWidth(DEFAULT_STROKE_WIDTH);

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
        });

        ColorPicker strokeColorPicker = new ColorPicker();
        StrokePicker strokePicker = new StrokePicker(canvasPane);

        strokeColorPicker.setValue(DEFAULT_STROKE_COLOR);
        strokeColorPicker.setOnAction(e -> {
            strokePicker.action(strokeColorPicker.getValue());
        });

        Label fillTitle = new Label("Relleno");
        ColorPicker fillColorPicker = new ColorPicker();
        FillPicker fillPicker = new FillPicker(canvasPane);

        fillColorPicker.setValue(DEFAULT_FILL_COLOR);
        fillColorPicker.setOnAction(e -> {
            fillPicker.action(fillColorPicker.getValue());
        });

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
