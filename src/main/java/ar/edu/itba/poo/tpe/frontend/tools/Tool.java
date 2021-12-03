package ar.edu.itba.poo.tpe.frontend.tools;

import ar.edu.itba.poo.tpe.frontend.CanvasPane;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public interface Tool {
    void action(CanvasPane canvasPane);
    EventHandler<MouseEvent> getOnMouseDragged();
    EventHandler<MouseEvent> getOnMousePressed();
    EventHandler<MouseEvent> getOnMouseRealesed();
}
