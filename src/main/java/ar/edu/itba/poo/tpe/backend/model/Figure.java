package ar.edu.itba.poo.tpe.backend.model;

import java.util.Set;

/**
 * Clase que modela una figura en un eje cartesiano
 */
public abstract class Figure {
    /**
     * Indica si el punto pasado como parámetro pertenece dentro de la figura
     *
     * @param point punto a evaluar
     * @return "true" si point pertenece a la figura, "false" si no
     */
    public abstract boolean pointBelongs(Point point);

    /**
     * Mueve la figura en el eje cartesiano por dos márgenes pasados como parámetros
     *
     * @param deltaX margen que indica el movimiento que hará la figura a través del eje X
     * @param deltaY margen que indica el movimiento que hará la figura a través del eje Y
     */
    public abstract void moveFigure(double deltaX, double deltaY);

    /**
     * Devuelve los puntos que delimitan la figura
     *
     * @return Set colección con los puntos externos
     */
    public abstract Set<Point> getOutsidePoints();

    /**
     * Indica si la figura pasada como parámetro está dentro de la figura
     *
     * @param figure figura a evaluar
     * @return "true" si figure pertenece, "false" si no
     */
    public boolean containsFigure(Figure figure){
        if(figure == null)
            return false;
        for (Point point : figure.getOutsidePoints()) {
            if(!(this.pointBelongs(point)))
                return false;
        }
        return true;
    }
}
