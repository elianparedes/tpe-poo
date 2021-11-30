package ar.edu.itba.poo.tpe.frontend;

import ar.edu.itba.poo.tpe.backend.CanvasState;
import ar.edu.itba.poo.tpe.backend.model.Circle;
import ar.edu.itba.poo.tpe.backend.model.Figure;
import ar.edu.itba.poo.tpe.backend.model.Point;
import ar.edu.itba.poo.tpe.backend.model.Rectangle;
import ar.edu.itba.poo.tpe.frontend.Drawable.DrawableCircle;
import ar.edu.itba.poo.tpe.frontend.Drawable.DrawableFigure;
import ar.edu.itba.poo.tpe.frontend.Drawable.DrawableRectangle;
import ar.edu.itba.poo.tpe.frontend.figuresbutton.FigureToggleButton;
import ar.edu.itba.poo.tpe.frontend.figuresbutton.FiguresButtons;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class PaintPane extends BorderPane {

	// BackEnd
	CanvasState canvasState;

	// Canvas y relacionados
	Canvas canvas = new Canvas(800, 600);
	GraphicsContext gc = canvas.getGraphicsContext2D();
	Color lineColor = Color.BLACK;
	Color fillColor = Color.YELLOW;

	// Botones Barra Izquierda
	ToggleButton selectionButton = new ToggleButton("Seleccionar");

	// Dibujar una figura
	Point startPoint;

	// Seleccionar una figura
	Figure selectedFigure;

	// StatusBar
	StatusPane statusPane;

	public PaintPane(CanvasState canvasState, StatusPane statusPane) {
		this.canvasState = canvasState;
		this.statusPane = statusPane;
		ArrayList<ToggleButton> figureToolsArr = new ArrayList<>();
		ArrayList<ToggleButton> selectionToolsArr = new ArrayList<>();
		selectionToolsArr.add(selectionButton);
		for (FiguresButtons buttonType: FiguresButtons.values()) {
			figureToolsArr.add(buttonType.getButton());
		}
		ToggleGroup figureTools = new ToggleGroup();
		ToggleGroup selectionTools = new ToggleGroup();
		/*
		Manejar este comportamiento en una funcion auxiliar para ambos tipos de grupos (de edicion y de figuras)
		 */

		for (ToggleButton tool : figureToolsArr) {
			tool.setMinWidth(90);
			tool.setToggleGroup(figureTools);
			tool.setCursor(Cursor.HAND);
		}
		for (ToggleButton tool : selectionToolsArr) {
			tool.setMinWidth(90);
			tool.setToggleGroup(selectionTools);
			tool.setCursor(Cursor.HAND);
		}
		/*
		--------------------------------------------------------------------------------------------------------
		--------------------------------------------------------------------------------------------------------
		 */
		VBox buttonsBox = new VBox(10);

		buttonsBox.getChildren().addAll(selectionToolsArr); // estas dos lineas quedan un poco raras
		buttonsBox.getChildren().addAll(figureToolsArr);

		buttonsBox.setPadding(new Insets(5));
		buttonsBox.setStyle("-fx-background-color: #999");
		buttonsBox.setPrefWidth(100);
		gc.setLineWidth(1);
		canvas.setOnMousePressed(event -> {
			startPoint = new Point(event.getX(), event.getY());
		});
		canvas.setOnMouseReleased(event -> {
			Point endPoint = new Point(event.getX(), event.getY());
			if(startPoint == null) {
				return ;
			}
			if(endPoint.getX() < startPoint.getX() || endPoint.getY() < startPoint.getY()) {
				return ;
			}
			FigureToggleButton selectedButton = (FigureToggleButton)(figureTools.getSelectedToggle());
			if(selectedButton == null)
				return;
			canvasState.addFigure(selectedButton.createFigure());
			startPoint = null;
			redrawCanvas();
		});
		canvas.setOnMouseMoved(event -> {
			Point eventPoint = new Point(event.getX(), event.getY());
			boolean found = false;
			StringBuilder label = new StringBuilder();
			for(Figure figure : canvasState.figures()) {
				if(figure.pointBelongs(eventPoint)) {
					found = true;
					label.append(figure.toString());
				}
			}
			if(found) {
				statusPane.updateStatus(label.toString());
			} else {
				statusPane.updateStatus(eventPoint.toString());
			}
		});

		canvas.setOnMouseClicked(event -> {
			if(selectionButton.isSelected()) {
				Point eventPoint = new Point(event.getX(), event.getY());
				boolean found = false;
				StringBuilder label = new StringBuilder("Se seleccionó: ");
				for (Figure figure : canvasState.figures()) {
					if(figure.pointBelongs(eventPoint)) {
						found = true;
						selectedFigure = figure;
						label.append(figure.toString());
					}
				}
				if (found) {
					statusPane.updateStatus(label.toString());
				} else {
					selectedFigure = null;
					statusPane.updateStatus("Ninguna figura encontrada");
				}
				redrawCanvas();
			}
		});
		canvas.setOnMouseDragged(event -> {
			if(selectionButton.isSelected()) {
				Point eventPoint = new Point(event.getX(), event.getY());
				double diffX = (eventPoint.getX() - startPoint.getX()) / 100;
				double diffY = (eventPoint.getY() - startPoint.getY()) / 100;
				if(selectedFigure instanceof Rectangle) {
					Rectangle rectangle = (Rectangle) selectedFigure;
					rectangle.getTopLeft().x += diffX;
					rectangle.getBottomRight().x += diffX;
					rectangle.getTopLeft().y += diffY;
					rectangle.getBottomRight().y += diffY;
				} else if(selectedFigure instanceof Circle) {
					Circle circle = (Circle) selectedFigure;
					circle.getCenterPoint().x += diffX;
					circle.getCenterPoint().y += diffY;
				}
				redrawCanvas();
			}
		});
		setLeft(buttonsBox);
		setRight(canvas);
	}

	void redrawCanvas() {
		gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
		for(Figure figure : canvasState.figures()) {
			if(figure == selectedFigure) {
				gc.setStroke(Color.RED);
			} else {
				gc.setStroke(lineColor);
			}
			gc.setFill(fillColor);
			DrawableFigure aux= (DrawableFigure) figure;
			aux.drawFigure(gc); //TODO casteo inseguro
		}
	}


}
