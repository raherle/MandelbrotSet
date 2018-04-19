package eu.kbros.mandelbrotSet;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class OutputGeneratorTest {


    @Test
    public void generateOutputString(){
        String[][] array = new String[4][12];
        array[0] = new String[]{"0", "0", "1", "1", "0", "1", "0", "0", "1", "1", "1", "0"};
        array[1] = new String[]{"0", "0", "1", "1", "0", "1", "0", "0", "1", "1", "1", "1"};;
        array[2] = new String[]{"0", "0", "0", "1", "0", "1", "0", "0", "1", "1", "1", "0"};;
        array[3] = new String[]{"0", "0", "1", "1", "0", "1", "0", "0", "1", "1", "1", "1"};;

        String outPut = "001101001110\n001101001111\n000101001110\n001101001111\n";

        assertEquals(outPut, OutputGenerator.generateOutputString(array));
    }

    @Test
    @DisplayName("Array 2x2")
    public void traverse(){
        String[][] array = {
                {"1", "2"},
                {"3", "4"}};

        String[][] expected = {
                {"2", "4"},
                {"1", "3"}};

        assertArrayEquals(expected, OutputGenerator.traverse(array));
    }

    @Test
    @DisplayName("Array 2x3")
    public void traverseUnequalLength(){
        String[][] array = {
                {"1", "2", "3"},
                {"4", "5", "6"}};

        String[][] expected = {
                {"3", "6"},
                {"2", "5"},
                {"1", "4"}};

        assertArrayEquals(expected, OutputGenerator.traverse(array));
    }

    @Test
    @DisplayName("Array 3x3")
    public void traverseThreeSquare(){
        String[][] array = {
                {"1", "2", "3"},
                {"4", "5", "6"},
                {"7", "8", "9"}};

        String[][] expected = {
                {"3", "6", "9"},
                {"2", "5", "8"},
                {"1", "4", "7"}};

        assertArrayEquals(expected, OutputGenerator.traverse(array));
    }

}