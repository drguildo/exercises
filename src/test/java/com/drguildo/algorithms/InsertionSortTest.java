package com.drguildo.algorithms.tests;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

import com.drguildo.algorithms.InsertionSort;

public class InsertionSortTest {
  @Test
  public void test() {
    int[] a = new int[] { 5, 4, 3, 2, 1 };
    int[] sorted = new int[] { 1, 2, 3, 4, 5 };

    assertTrue(Arrays.equals(InsertionSort.sort(a), sorted));
  }

  @Test
  public void testEmpty() {
    assertTrue(Arrays.equals(InsertionSort.sort(new int[] {}), new int[] {}));
  }
}
