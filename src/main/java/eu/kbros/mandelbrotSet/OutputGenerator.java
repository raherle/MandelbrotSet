package eu.kbros.mandelbrotSet;

import java.util.HashMap;
import java.util.Map;
import static eu.kbros.mandelbrotSet.MandelbrotCalculator.assignColorToPixels;
import static eu.kbros.mandelbrotSet.MandelbrotCalculator.mapPixelsToCValues;

public class OutputGenerator {

    public static void main (String[] args){
        Range range = new Range(-2f,1f,-1f,1f);
        Canvas canvas = new Canvas(120,40);

        HashMap<Pixel,ComplexNumber> pixelMap = mapPixelsToCValues(range,canvas);
        assignColorToPixels(pixelMap);
        String[][] outputArray = rotated(convertPixelMapIntoArray(pixelMap, canvas));
        String outputString = generateOutputString(outputArray);
        System.out.println(outputString);
    }

    public static String[][] rotated(String[][] array) {
        String[][] result = new String[array[0].length][array.length];

        for(int i = 0; i<array.length; i++){
            for(int j = 0; j<array[i].length; j++){
                result[array[0].length-j-1][i] = array[i][j];
            }
        }
        return result;
    }

    public static String generateOutputString(String[][] array) {
        String outputString = "";
        for(int i = 0; i<array.length; i++){
            for(int j = 0; j<array[i].length; j++){
                outputString +=array[i][j];
            }
            outputString +="\n";
        }
        return outputString;
    }

    public static String[][] convertPixelMapIntoArray(HashMap<Pixel, ComplexNumber> map, Canvas canvas){
        String[][] pixelArray = new String[canvas.getPixelX()][canvas.getPixelY()];

        for (Map.Entry<Pixel, ComplexNumber> entry: map.entrySet()) {
            Pixel pixel = entry.getKey();
            pixelArray[pixel.getX()][pixel.getY()] = pixel.getColor();
        }

        return pixelArray;
    }
}
