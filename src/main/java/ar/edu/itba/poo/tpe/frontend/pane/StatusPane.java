package ar.edu.itba.poo.tpe.frontend.pane;

import ar.edu.itba.poo.tpe.backend.model.Point;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;


/**
 * Panel de visualizacion con informacion actual de las acciones realizadas y de elementos en pantalla
 */
public class StatusPane extends BorderPane {

	private final Label statusLabel;

	public StatusPane() {
		setStyle(
				"-fx-background-color: #4EBCF8"
		);

		statusLabel = new Label("Paint 1.0");
		statusLabel.setAlignment(Pos.CENTER);
		statusLabel.setStyle("-fx-font-size: 16");
		setCenter(statusLabel);
	}

	public void updateStatus(String text) {
		statusLabel.setText(text);
	}

	public void updateStatusPoint(Point point){
		updateStatus(point.toString());
	}

	public void updateStatusColor(String text, Color color){
		updateStatus(String.format("%s: #%s", text, color));
	}

	public void updateStatusWidth(double width){
		updateStatus(String.format("Espesor de trazo: %.2f", width));
	}

}