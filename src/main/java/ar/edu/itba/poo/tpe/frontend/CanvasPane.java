package ar.edu.itba.poo.tpe.frontend;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

//TODO: Unificar los estilos. Armar una sección de estilos en la parte superior de la class?

public class CanvasPane extends Canvas {

    GraphicsContext graphicsContext;

    public CanvasPane(){
        super(800,600);
        graphicsContext = getGraphicsContext2D();
    }

}
