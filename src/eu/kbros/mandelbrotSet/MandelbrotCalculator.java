package eu.kbros.mandelbrotSet;

import java.util.HashMap;
import java.util.Map;

public class MandelbrotCalculator {

    public static ComplexNumber mandelbrotFunction(ComplexNumber complexNumberZ, ComplexNumber complexNumberC) {
        ComplexNumber result = ComplexNumber.squareComplexNumber(complexNumberZ);
        result = result.plus(complexNumberC);

        return result;
    }

    public static boolean isInRangeAfterIteration(ComplexNumber complexNumberInput) {
        int n = 100;
        int howOftenInRange = 0;
        ComplexNumber complexNumberZ = new ComplexNumber(0,0);

        for(int i = 0; i<n; i++){
            complexNumberZ = mandelbrotFunction(complexNumberZ, complexNumberInput);
            if(isInRange(complexNumberInput, complexNumberZ)) {howOftenInRange++;}
            else { return false;}
        }

        return howOftenInRange == n;
    }

    public static boolean isInRange(ComplexNumber complexOrigin, ComplexNumber complexIteration){

        boolean inRange = true;
        float distance = distanceComplexNumber(complexOrigin, complexIteration);
        if(distance >= 2f){
            inRange = false;
        }

        return inRange;
    }

    public static float distanceComplexNumber(ComplexNumber complexNumberA, ComplexNumber complexNumberB){
        ComplexNumber complexNumberDistance = complexNumberA.minus(complexNumberB);
        return complexNumberDistance.absoluteValue();
    }

    public static HashMap<Pixel,ComplexNumber> mapPixelsToCValues(Range range, Canvas canvas){
        HashMap<Pixel,ComplexNumber> pixelCValueMap = new HashMap<Pixel,ComplexNumber>();

        float distanceBetweenPixelsX = range.getXRangeLength()/canvas.getPixelX();
        float distanceBetweenPixelsY = range.getYRangeLength()/canvas.getPixelY();

        for(int i = 0; i < canvas.getPixelX(); i++){
            for(int j = 0; j < canvas.getPixelY(); j++){
                Pixel currentPixel = new Pixel(i, j);
                float complexXValue = range.getCxMin() + distanceBetweenPixelsX * i;
                float complexYValue = range.getCyMin() + distanceBetweenPixelsY * j;
                ComplexNumber cValue = new ComplexNumber(complexXValue, complexYValue);
                pixelCValueMap.put(currentPixel, cValue);
            }
        }

        return pixelCValueMap;
    }

    public static void assignColorToPixels(HashMap<Pixel, ComplexNumber> map){
        for (Map.Entry<Pixel, ComplexNumber> entry: map.entrySet()) {
            Pixel pixel = entry.getKey();
            ComplexNumber cNumber = entry.getValue();
            boolean isColored = isInRangeAfterIteration(cNumber);

            if(isColored){
                pixel.setColor("#");
            } else{
                pixel.setColor(" ");
            }
        }
    }
}
