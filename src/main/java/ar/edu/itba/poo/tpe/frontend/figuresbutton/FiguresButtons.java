package ar.edu.itba.poo.tpe.frontend.figuresbutton;

public enum FiguresButtons {

    CIRCLE{
        @Override
        public FigureToggleButton getButton() {
            return new CircleToggleButton();
        }
    },
    RECTANGLE{
        @Override
        public FigureToggleButton getButton() {
            return new RectangleToggleButton();
        }
    };

    public abstract FigureToggleButton getButton();

}
