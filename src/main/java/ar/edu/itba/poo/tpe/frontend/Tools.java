package ar.edu.itba.poo.tpe.frontend;

import ar.edu.itba.poo.tpe.frontend.tools.*;
import javafx.scene.Cursor;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Tools {

    Map<ToggleButton, Tool> tools = new HashMap<>();
    ToggleButton selection = new ToggleButton("Selección");
    ToggleButton rectangle = new ToggleButton("Rectángulo");
    ToggleButton circle = new ToggleButton("Círculo");
    ToggleButton square = new ToggleButton("Cuadrado");
    ToggleButton ellipse = new ToggleButton("Elipse");
    ToggleButton line = new ToggleButton("Línea");
    ToggleGroup toggleGroup = new ToggleGroup();

    public Tools() {
        tools.put(selection,new SelectionTool());
        tools.put(rectangle,new RectangleTool());
        tools.put(circle,new CircleTool());
        tools.put(square, new SquareTool());
        // tools.put(ellipse, new EllipseTool());
        // tools.put(line, new LineTool());
        setToggleGroup();
    }

    public Set<ToggleButton> getToggleSet(){
        return tools.keySet();
    }

    public ToggleGroup getToggleGroup(){
        return toggleGroup;
    }

    public Tool getSelectedTool(Toggle selectedToggle){
        return tools.get(selectedToggle);
    }

    private void setToggleGroup(){
        Set<ToggleButton> toggleSet = tools.keySet();
        for (ToggleButton toggle : toggleSet ) {
            toggle.setStyle("-fx-min-width: 90");
            toggle.setCursor(Cursor.HAND);
            toggle.setToggleGroup(toggleGroup);
        }
    }

}
