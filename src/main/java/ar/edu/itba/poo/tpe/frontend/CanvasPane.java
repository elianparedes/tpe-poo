package ar.edu.itba.poo.tpe.frontend;

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
    public void onFigureDraw() {
        this.setOnMousePressed(e -> {
            //Hacer algo cuando se presiona el mouse
        });

        this.setOnMouseDragged(e -> {
            //Hacer algo cuando se arrastra el mouse
        });

        this.setOnMouseReleased(e -> {
            //Hacer algo cuando se suelta el mouse
        });
    }

    @Override
    public void onSelection() {
        this.setOnMousePressed(e -> {
            //Hacer algo cuando se presiona el mouse
        });

        this.setOnMouseDragged(e -> {
            //Hacer algo cuando se arrastra el mouse
        });

        this.setOnMouseReleased(e -> {
            //Hacer algo cuando se suelta el mouse
        });
    }

    @Override
    public void onIdle() {

        /*
         * Reset de los eventos del Mouse, pues no se espera ningún comportamiento.
         */

        this.setOnMousePressed(null);

        this.setOnMouseDragged(null);

        this.setOnMouseReleased(null);

    }
}
