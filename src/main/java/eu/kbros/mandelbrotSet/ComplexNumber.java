package eu.kbros.mandelbrotSet;

public final class ComplexNumber {

    public final float re;
    public final float im;

    public ComplexNumber(float re, float im) {
        this.re = re;
        this.im = im;
    }

    public static ComplexNumber complex(float re, float im) {
        return new ComplexNumber(re, im);
    }


    public ComplexNumber plus(ComplexNumber b) {
        ComplexNumber a = this;
        return complex(a.re+b.re, a.im+b.im);
    }

    public ComplexNumber minus(ComplexNumber b) {
        ComplexNumber a = this;
        return complex(a.re-b.re, a.im-b.im);
    }

    public float absoluteValue(){
        return (float)Math.sqrt(this.re * this.re + this.im * this.im);
    }

    public static ComplexNumber squareComplexNumber(ComplexNumber complexNumber) {
        float valueX = complexNumber.re;
        float valueY = complexNumber.im;

        float newValueX = (valueX * valueX) - (valueY * valueY);
        float newValueY = 2 * valueX * valueY;

        ComplexNumber complexSquare = new ComplexNumber(newValueX, newValueY);

        return complexSquare;
    }

}
