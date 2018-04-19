package eu.kbros.mandelbrotSet;

public class Canvas {

    private int pixelX;
    private int pixelY;


    public Canvas(int x, int y){
        pixelX = x;
        pixelY = y;
    }

    public int getPixelX() {
        return pixelX;
    }

    public int getPixelY() {
        return pixelY;
    }
}
