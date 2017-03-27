package br.com.kecyo.helltriangle;

import br.com.kecyo.helltriangle.exception.InvalidTriangleException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static br.com.kecyo.helltriangle.Run.start;
import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class HellTriangleTest {

    @Test
    public void test_triangle_2_level(){
        int[][] array = {{3}, {8, 2}};
        assertEquals(start(array), 11);
    }

    @Test
    public void test_triangle_3_level(){
        int[][] array = {{3}, {8, 2}, {1, 2, 9}};
        assertEquals(start(array), 14);
    }

    @Test
    public void test_triangle_4_level(){
        int[][] array = {{6}, {3, 5}, {9, 7, 1}, {4, 6, 8, 4}};
        assertEquals(start(array), 26);
    }

    @Test
    public void test_triangle_4_level_number_part_equals(){
        int[][] array = {{1}, {1, 2}, {1, 1, 1}, {1, 1, 1, 1}};
        assertEquals(start(array), 5);
    }

    @Test
    public void test_triangle_4_level_number_equals(){
        int[][] array = {{1}, {1, 1}, {1, 1, 1}, {1, 1, 1, 1}};
        assertEquals(start(array), 4);
    }

    @Test
    public void test_triangle_5_level(){
        int[][] array = {{6}, {3, 5}, {9, 7, 1}, {4, 6, 8, 4},{9, 1, 7, 2, 5}};
        assertEquals(start(array), 33);
    }

    @Test(expected = InvalidTriangleException.class)
    public void test_InvalidTriangle(){
        int[][] array = {{3}, {8, 2}, {1, 2}};
        start(array);
    }

    @Test(expected = InvalidTriangleException.class)
    public void test_InvalidTriangle_1_level(){
        int[][] array = {{3}};
        start(array);
    }

}
