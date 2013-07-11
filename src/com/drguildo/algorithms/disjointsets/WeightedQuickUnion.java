package com.drguildo.algorithms.disjointsets;

import java.util.Arrays;

public class WeightedQuickUnion {
  public static void main(final String[] args) {
    final WeightedQuickUnion wqu = new WeightedQuickUnion(10);
    wqu.union(4, 1);
    wqu.union(3, 9);
    wqu.union(1, 3);
    wqu.union(5, 7);
    wqu.union(0, 6);
    wqu.union(8, 1);
    wqu.union(5, 0);
    wqu.union(6, 9);
    wqu.union(6, 2);
  }

  private final int[] id;
  private final int[] sz;

  public WeightedQuickUnion(final int n) {
    id = new int[n];
    sz = new int[n];

    for (int i = 0; i < n; i++) {
      id[i] = i;
      sz[i] = 1;
    }
  }

  public boolean connected(final int p, final int q) {
    // If two objects have the same root node then they're in the same
    // connected component.
    return find(p) == find(q);
  }

  public int find(final int p) {
    if (id[p] == p) {
      // p is the root node.
      return p;
    } else {
      return find(id[p]);
    }
  }

  /**
   * Find the shortest component and make it's parent the root node of the other
   * component.
   */
  public void union(final int p, final int q) {
    final int i = find(p);
    final int j = find(q);

    if (sz[i] < sz[j]) {
      id[i] = j;
      sz[j] += sz[i];
    } else {
      id[j] = i;
      sz[i] += sz[j];
    }

    System.out.println(Arrays.toString(id));
  }
}
