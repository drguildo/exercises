package com.drguildo.algorithms.disjointsets;

import java.util.Arrays;

public class QuickFind {
  public static void main(final String[] args) {
    final QuickFind qu = new QuickFind(10);
    qu.union(9, 0);
    qu.union(3, 4);
    qu.union(6, 0);
    qu.union(0, 4);
    qu.union(3, 2);
    qu.union(0, 5);
  }

  private final int[] id;

  public QuickFind(final int n) {
    id = new int[n];

    for (int i = 0; i < id.length; i++) {
      id[i] = i;
    }
  }

  public boolean connected(final int p, final int q) {
    return id[p] == id[q];
  }

  public int find(final int p) {
    return id[p];
  }

  public void union(final int p, final int q) {
    final int x = id[p];

    for (int i = 0; i < id.length; i++) {
      if (x == id[i]) {
        id[i] = id[q];
      }
    }

    System.out.println(Arrays.toString(id));
  }
}
