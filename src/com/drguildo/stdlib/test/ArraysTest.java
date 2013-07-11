package com.drguildo.stdlib.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.drguildo.stdlib.Arrays;

public class ArraysTest {
  @Test
  public void testUniqueOrder() {
    int[] a = new int[] { 1, 1, 2, 2, 3, 3, 4, 4 };
    assertArrayEquals(Arrays.unique(a), new int[] { 1, 2, 3, 4 });
  }

  @Test
  public void testUniqueSingle() {
    int[] a = new int[] { 0 };
    assertArrayEquals(Arrays.unique(a), new int[] { 0 });

    int[] b = new int[] { 1, 1 };
    assertArrayEquals(Arrays.unique(b), new int[] { 1 });
  }

  @Test
  public void testUniqueEmpty() {
    assertArrayEquals(Arrays.unique(new int[] {}), new int[] {});
  }

  @Test
  public void testToStringEmpty() {
    assertEquals(Arrays.toString(new double[][] {}), "[]");
    assertEquals(Arrays.toString(new int[][] {}), "[]");
    assertEquals(Arrays.toString(new String[][] {}), "[]");

    assertEquals(Arrays.toString(new double[][] { {} }), "[[]]");
    assertEquals(Arrays.toString(new int[][] { {} }), "[[]]");
    assertEquals(Arrays.toString(new String[][] { {} }), "[[]]");

    assertEquals(Arrays.toString(new double[][] { {}, {} }), "[[], []]");
    assertEquals(Arrays.toString(new int[][] { {}, {} }), "[[], []]");
    assertEquals(Arrays.toString(new String[][] { {}, {} }), "[[], []]");
  }

  @Test
  public void testToString() {
    assertEquals(Arrays.toString(new double[][] { { 1.0 } }), "[[1.0]]");
    assertEquals(Arrays.toString(new int[][] { { 1 } }), "[[1]]");
    assertEquals(Arrays.toString(new String[][] { { "" } }), "[[]]");
    assertEquals(Arrays.toString(new String[][] { { "a" } }), "[[a]]");
  }
}
