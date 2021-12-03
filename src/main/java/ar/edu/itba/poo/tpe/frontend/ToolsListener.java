package ar.edu.itba.poo.tpe.frontend;
import ar.edu.itba.poo.tpe.frontend.painttools.PaintTool;
import javafx.scene.paint.Color;

public interface ToolsListener {

    void setMouseBehavior(PaintTool tool);
    void onIdle(); // Cuando no hay ninguna herramienta seleccionada

}
