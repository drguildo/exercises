package com.drguildo.algorithms.disjointsets;

public class QuickUnion {
  private final int[] id;

  public QuickUnion(final int n) {
    id = new int[n];

    for (int i = 0; i < id.length; i++) {
      id[i] = i;
    }
  }

  public boolean connected(final int p, final int q) {
    // If two objects have the same root node then they're in the same
    // connected component.
    return find(p) == find(q);
  }

  public int find(final int p) {
    int i = p;

    while (id[i] != i) {
      i = id[i];
    }

    return i;
  }

  /**
   * Make p's root node's parent q's root node.
   */
  public void union(final int p, final int q) {
    id[find(p)] = id[find(q)];
  }
}
