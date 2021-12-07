package ar.edu.itba.poo.tpe.backend;

import ar.edu.itba.poo.tpe.backend.model.Figure;
import ar.edu.itba.poo.tpe.backend.model.Point;
import ar.edu.itba.poo.tpe.backend.model.drawable.DrawableFigure;
import ar.edu.itba.poo.tpe.backend.model.drawable.DrawableFigure2D;

import java.util.*;

/**
 * Clase que modela un gestor de figuras que pueden ser dibujadas, almacenadas en una colección First In,First Out.
 */
public class CanvasState {

    private final Deque<DrawableFigure> figures = new LinkedList<>();
    private final List<DrawableFigure> selectedFigures = new ArrayList<>();

    private final ArrayList<StateListener> listeners = new ArrayList<>();

    /**
     * Permite añadir un observador a la clase
     *
     * @param stateListener Observador que será añadido
     */
    public void addStateListener(StateListener stateListener) {
        listeners.add(stateListener);
    }

    /**
     * Añade una figura pasada como parámetro a la Deque de figuras
     *
     * @param figure figura que será añadida
     */
    public void addFigure(DrawableFigure figure) {
        figures.offer(figure);
        notifyStateChange();
    }

    /**
     * Desplaza la figura pasada como parámetro al final de la colección, si es que está en la misma
     *
     * @param figure figura que será desplazada
     */
    public void sendToBack(DrawableFigure figure) {
        if (figures.contains(figure)) {
            figures.remove(figure);
            figures.offerFirst(figure);
            notifyStateChange();
        }
    }

    /**
     * Desplaza una colección Deque de figuras pasadas como parámetro al final de la colección
     *
     * @param figures colección Deque de figuras que serán desplazadas
     */
    public void sendToBack(Deque<DrawableFigure> figures) {
        Iterator<DrawableFigure> it = figures.descendingIterator();
        while (it.hasNext())
            sendToBack(it.next());
    }

    /**
     * Desplaza una figura pasada como parámetro al principio de la colección
     *
     * @param figure figura que será desplazada
     */
    public void bringToFront(DrawableFigure figure) {
        if (figures.contains(figure)) {
            figures.remove(figure);
            figures.offerLast(figure);
            notifyStateChange();
        }
    }

    /**
     * Desplaza una colección Deque de figuras pasadas como parámetro al principio de la colección
     *
     * @param figures colección Deque de figuras que serán desplazadas
     */
    public void bringToFront(Deque<DrawableFigure> figures) {
        for (DrawableFigure figure : figures)
            bringToFront(figure);
    }

    /**
     * Añade las figuras que contienen el punto pasado como parámetro a una lista de figuras seleccionadas
     *
     * @param point Punto que será evaluado
     */
    public void selectFigure(Point point) {
        Iterator<DrawableFigure> it = figures.descendingIterator();
        while (it.hasNext()) {
            DrawableFigure figure = it.next();
            if (figure.pointBelongs(point)) {
                selectFigure(figure);
                return;
            }
        }
    }

    /**
     * Añade la figura de la Deque de figuras pasada como parámetro a la lista de figuras seleccionadas
     *
     * @param figure Figura que será seleccionada
     */
    public void selectFigure(DrawableFigure figure) {
        if (figures.contains(figure)) {
            selectedFigures.add(figure);
            notifyStateChange();
        }
    }

    /**
     * Añade las figuras de la Deque de figuras que estén contenidas en la figura pasada como parámetro
     *
     * @param figure Figura que será evaluada en la Deque
     */
    public void selectFiguresWithin(Figure figure){
        for (DrawableFigure target : figures ) {
            if (figure.containsFigure(target.getFigure())){
                selectFigure(target);
            }
        }
    }

    /**
     *  Deselecciona todas las figuras seleccionadas
     */
    public void unselectAllFigures() {
        selectedFigures.clear();
        notifyStateChange();
    }

    /**
     *  Remueve las figuras seleccionadas de la colección Deque de figuras.
     *  Además, deselecciona todas las figuras seleccionadas
     */
    public void removeSelectedFigures() {
        for (DrawableFigure selected : selectedFigures) {
            figures.remove(selected);
        }
        unselectAllFigures();
    }

    /**
     * Mueve las figuras seleccionadas en el eje cartesiano por dos márgenes pasados como parámetro
     *
     * @param deltaX margen que indica el movimiento que hará la figura a través del eje X
     * @param deltaY margen que indica el movimiento que hará la figura a través del eje Y
     */
    public void moveSelectedFigures(double deltaX, double deltaY){
        for (DrawableFigure selected : selectedFigures ) {
            selected.moveFigure(deltaX, deltaY);
        }
        notifyStateChange();
    }

    /**
     * Indica si la figura pasada como parámetro esta seleccionada
     *
     * @param figure figura que será evaluada
     * @return "true" si la figura está seleccionada, "false" si no
     */
    public boolean isSelected(DrawableFigure figure){
        return selectedFigures.contains(figure);
    }

    /**
     * Indica si existen figuras seleccionadas
     *
     * @return "true" si existen, "false" si no
     */
    public boolean hasSelectedFigures(){
        return !selectedFigures.isEmpty();
    }

    /**
     * Cambia el color del relleno de las figuras seleccionadas
     *
     * @param color Nuevo color del relleno
     */
    public void setSelectedFiguresFillColor(String color) {
        for (DrawableFigure selected : selectedFigures) {
            if (selected.hasFill()) {
                ((DrawableFigure2D) selected).setFillColor(color);
                /**
                 * Este casteo es seguro porque se valida anteriormente si la figura tiene relleno o no. Si lo tiene,
                 * entonces es una figura de dos dimensiones y puede ser casteada para poder obtener el metodo que settea
                 * esta misma propiedad (el relleno)
                 */
            }
        }
        notifyStateChange();
    }

    /**
     * Cambia el color del borde de las figuras seleccionadas
     *
     * @param color Nuevo color del borde
     */
    public void setSelectedFiguresStrokeColor(String color){
        for (DrawableFigure selected : selectedFigures) {
            selected.setStrokeColor(color);
        }
        notifyStateChange();
    }

    /**
     * Cambia el grosor del borde de las figuras seleccionadas
     *
     * @param width Nuevo grosor del borde
     */
    public void setSelectedFiguresStrokeWidth(double width){
        for (DrawableFigure selected : selectedFigures) {
            selected.setStrokeWidth(width);
        }
        notifyStateChange();
    }

    /**
     * Devuelve la cantidad de figuras seleccionadas
     *
     * @return Cantidad de figuras seleccionadas
     */
    public int selectedFiguresCount() {
        return selectedFigures.size();
    }

    /**
     * Devuelve una lista con las figuras seleccionadas
     *
     * @return linked list con las figuras seleccionadas
     */
    public Deque<DrawableFigure> getSelectedFigures(){
        return new LinkedList<>(selectedFigures);
    }

    /**
     * Devuelve una cola con las figuras almacenadas
     *
     * @return Deque con las figuras almacendas
     */
    public Deque<DrawableFigure> getFigures() {
        return figures;
    }

    /**
     *  Ejecuta el método onStateChange() de los observadores
     */
    private void notifyStateChange(){
        for (StateListener stateListener :  listeners) {
            stateListener.onStateChange();
        }
    }

}
