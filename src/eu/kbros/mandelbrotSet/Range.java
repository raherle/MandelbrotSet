package eu.kbros.mandelbrotSet;

public class Range {

    private float cxMin;
    private float cxMax;
    private float cyMin;
    private float cyMax;

    public Range(float cxMin, float cxMax, float cyMin, float cyMax) {
        this.cxMin = cxMin;
        this.cxMax = cxMax;
        this.cyMin = cyMin;
        this.cyMax = cyMax;
    }

    public float getCxMin() {
        return cxMin;
    }

    public float getCxMax() {
        return cxMax;
    }

    public float getCyMin() {
        return cyMin;
    }

    public float getCyMax() {
        return cyMax;
    }

    public float getXRangeLength(){
        return Math.abs(cxMax - cxMin);
    }

    public float getYRangeLength(){
        return Math.abs(cyMax - cyMin);
    }
}
