package ar.edu.itba.poo.tpe.frontend;
import ar.edu.itba.poo.tpe.frontend.tools.Tool;

public interface MouseEventListener {

    void onToolSelect(Tool tool);
    void onToolUnselect(); // Cuando no hay ninguna herramienta seleccionada

}
