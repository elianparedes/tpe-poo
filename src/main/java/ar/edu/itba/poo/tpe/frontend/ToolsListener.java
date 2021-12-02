package ar.edu.itba.poo.tpe.frontend;
import ar.edu.itba.poo.tpe.frontend.painttools.DrawTool;

public interface ToolsListener {

    void onFigureDraw(DrawTool drawTool); // Cuando se dibujará una figura

    void onSelect(); // Cuando se seleccionará un elemento del Canvas

    void onIdle(); // Cuando no hay ninguna herramienta seleccionada

}
