package ar.edu.itba.poo.tpe.frontend;

public interface ToolsListener {

    void onFigureDraw(); // Cuando se dibujará una figura

    void onSelection(); // Cuando se seleccionará un elemento del Canvas

    void onIdle(); // Cuando no hay ninguna herramienta seleccionada

}
