package ar.edu.itba.poo.tpe.frontend;

import ar.edu.itba.poo.tpe.backend.CanvasState;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

//TODO: Unificar los estilos. Armar una sección de estilos en la parte superior de la class?

public class CanvasPane extends Canvas implements ToolsListener {

    GraphicsContext graphicsContext;
    CanvasState canvasState;

    public CanvasPane(CanvasState canvasState){
        super(800,600);
        graphicsContext = getGraphicsContext2D();
        this.canvasState = canvasState;
    }

    @Override
    public void onToolSelected() {

    }
}
