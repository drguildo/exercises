package com.drguildo.algorithms.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.drguildo.algorithms.LinearSearch;

public class LinearSearchTest {
  @Test
  public void test() {
    int[] a = new int[] { 0, 1, 2, 3, 4, 5 };

    assertEquals(LinearSearch.search(a, 1), 1);
    assertEquals(LinearSearch.search(a, 6), -1);
  }

  @Test
  public void testEmpty() {
    assertEquals(LinearSearch.search(new int[] {}, 1), -1);
  }
}
