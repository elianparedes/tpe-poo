package ar.edu.itba.poo.tpe.frontend;
import ar.edu.itba.poo.tpe.frontend.painttools.DrawTool;
import javafx.scene.paint.Color;

public interface ToolsListener {

    void onFigureDraw(DrawTool drawTool); // Cuando se dibujará una figura

    void onFillColorSelect(Color selectedColor); // Cuando se selecciona un nuevo color de relleno

    void onStrokeColorSelect(Color selectedColor); // Cuando se selecciona un nuevo color para el trazo

    void onStrokeWidthSelect(double width); // Cuando se selecciona un nuevo espesor de trazo

    void onSelect(); // Cuando se seleccionará un elemento del Canvas

    void onIdle(); // Cuando no hay ninguna herramienta seleccionada

}
