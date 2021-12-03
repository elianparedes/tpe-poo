package ar.edu.itba.poo.tpe.frontend.painttools;

import ar.edu.itba.poo.tpe.frontend.CanvasPane;
import ar.edu.itba.poo.tpe.frontend.ToolsListener;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public interface PaintTool {
    void action(CanvasPane canvasPane);
    EventHandler<MouseEvent> getOnMouseDragged();
    EventHandler<MouseEvent> getOnMousePressed();
    EventHandler<MouseEvent> getOnMouseRealesed();
}
