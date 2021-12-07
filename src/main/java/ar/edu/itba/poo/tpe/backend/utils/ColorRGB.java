package ar.edu.itba.poo.tpe.backend.utils;

public class ColorRGB {

    private double red, green, blue;
    private static final double RGB_MAX_VALUE = 255;
    private static final double RGB_MIN_VALUE = 0;

    public ColorRGB(double red, double green, double blue) {
        if(!isRGBValid(red, green, blue))
            throw new IllegalArgumentException("Invalid RGB value");
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public double getRed() {
        return red;
    }

    public void setRed(double red) {
        this.red = red;
    }

    public double getGreen() {
        return green;
    }

    public void setGreen(double green) {
        this.green = green;
    }

    public double getBlue() {
        return blue;
    }

    public void setBlue(double blue) {
        this.blue = blue;
    }

    private boolean isRGBValid(double red, double green, double blue){
        return  red >= RGB_MIN_VALUE && red <= RGB_MAX_VALUE &&
                green >= RGB_MIN_VALUE && green <= RGB_MAX_VALUE &&
                blue >= RGB_MIN_VALUE && blue <= RGB_MAX_VALUE;
    }
}
