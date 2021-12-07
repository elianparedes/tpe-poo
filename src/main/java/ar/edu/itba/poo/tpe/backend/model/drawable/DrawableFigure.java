package ar.edu.itba.poo.tpe.backend.model.drawable;

import ar.edu.itba.poo.tpe.backend.model.Figure;
import ar.edu.itba.poo.tpe.backend.model.Point;
import ar.edu.itba.poo.tpe.backend.utils.ColorRGB;

/**
 * Clase que modela una figura que se puede dibujar.
 */
public abstract class DrawableFigure {

    /**
     * Características de la figura
     */
    private final Figure figure;
    private double strokeWidth;
    private ColorRGB strokeColor;

    /**
     * Interfaz funcional que indica a la figura como será dibujada
     */
    protected DrawingFunction drawingFunction;

    public DrawableFigure(Figure figure, ColorRGB strokeColor, double lineWidth) {
        this.figure = figure;
        this.strokeColor = strokeColor;
        this.strokeWidth = lineWidth;
    }

    /**
     * Dibuja la figura a través de la interfaz drawingFunction. Si no existe una drawingFunction,
     * colocoda, lanza NullPointerException
     */
    public void drawFigure() {
        if (drawingFunction == null)
            throw new NullPointerException("No DrawableFunction defined");
        drawingFunction.draw();
    }

    //***************************
    // Getters
    //***************************
    public ColorRGB getStrokeColor() {
        return strokeColor;
    }

    public double getStrokeWidth(){
        return strokeWidth;
    }

    public Figure getFigure() {
        return figure;
    }

    //***************************
    // Setters
    //***************************
    public void setStrokeColor(ColorRGB color) {
        this.strokeColor = color;
    }

    public void setStrokeWidth(double strokeWidth) {
        this.strokeWidth = strokeWidth;
    }

    public void setDrawingFunction(DrawingFunction drawingFunction){
        this.drawingFunction = drawingFunction;
    }

    /**
     * Indica si la figura tiene relleno o no (en el caso de una figura 1D, no posee relleno)
     *
     * @return "true" si la figura posee relleno, "false" si no
     */
    public abstract boolean hasFill();

    /**
     * Indica si la figura contiene el punto que se le pasa como parámetro
     *
     * @param point punto a evaluar
     * @return "true" si point pertenece a la figura, "false" si no
     */
    public boolean pointBelongs(Point point){
        return figure.pointBelongs(point);
    }

    /**
     * Mueve la figura en el eje cartesiano por dos márgenes pasados como parámetros
     *
     * @param deltaX margen que indica el movimiento que hará la figura a través del eje X
     * @param deltaY margen que indica el movimiento que hará la figura a través del eje Y
     */
    public void moveFigure(double deltaX, double deltaY){
        figure.moveFigure(deltaX, deltaY);
    }

    @Override
    public String toString() {
        return figure.toString();
    }
}