package eu.kbros.mandelbrotSet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MandelbrotCalculatorTest {

    @Test
    public void plus() {
        ComplexNumber complexNumberA = new ComplexNumber(3, 4);
        ComplexNumber complexNumberB = new ComplexNumber(1, 2);
        ComplexNumber complexNumberSum = complexNumberA.plus(complexNumberB);
        assertEquals(4, complexNumberSum.re, 0.001);
        assertEquals(6, complexNumberSum.im, 0.001);
    }

    @Test
    public void squareComplexNumber() {
        ComplexNumber complexNumberA = new ComplexNumber(3, 4);
        ComplexNumber complexNumberSquare = ComplexNumber.squareComplexNumber(complexNumberA);
        assertEquals(-7, complexNumberSquare.re,0.001);
        assertEquals(24, complexNumberSquare.im,0.001);
    }

    @Test
    public void mandelbrotFunction(){
        ComplexNumber complexNumberZ = new ComplexNumber(3,4);
        ComplexNumber complexNumberC = new ComplexNumber(1,2);
        ComplexNumber complexNumberActualResult = MandelbrotCalculator.mandelbrotFunction(complexNumberZ, complexNumberC);
        assertEquals(-6, complexNumberActualResult.re,0.001);
        assertEquals(26, complexNumberActualResult.im,0.001);
    }

    @Test
    public void isInRange(){
        ComplexNumber complexNumberInputFalse = new ComplexNumber(-0.6f,0.65f);
        ComplexNumber complexNumberInputTrue = new ComplexNumber(-0.4f,0.5f);
        assertTrue(MandelbrotCalculator.isInRangeAfterIteration(complexNumberInputTrue));
        assertFalse(MandelbrotCalculator.isInRangeAfterIteration(complexNumberInputFalse));
    }

    @Test
    public void calculateDistance(){
        ComplexNumber complexNumberA = new ComplexNumber(-1,0);
        ComplexNumber complexNumberB = new ComplexNumber(1,0);
        float distance = MandelbrotCalculator.distanceComplexNumber(complexNumberA, complexNumberB);

        assertEquals(2f, distance, 0.1);
    }

    @Test
    public void isInMandelbrotRange(){
        ComplexNumber complexNumberInputFalse = new ComplexNumber(-0.6f,0.65f);
        ComplexNumber complexNumberInputTrue = new ComplexNumber(-0.4f,0.5f);
        assertTrue(MandelbrotCalculator.isInRangeAfterIteration(complexNumberInputTrue));
        assertFalse(MandelbrotCalculator.isInRangeAfterIteration(complexNumberInputFalse));
    }

    @Test
    public void mapPixelsToCValues(){
        Range range = new Range(-0.6f,-0.4f,0.5f,0.65f);
        Canvas canvas = new Canvas(120,40);
    }
}