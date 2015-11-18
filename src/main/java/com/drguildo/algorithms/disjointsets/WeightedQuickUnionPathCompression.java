package com.drguildo.algorithms.disjointsets;

public class WeightedQuickUnionPathCompression {
  private final int[] id;
  private final int[] sz;

  public WeightedQuickUnionPathCompression(final int n) {
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

  public int find(int p) {
    while (id[p] != p) {
      id[p] = id[id[p]];
      p = id[p];
    }

    return p;
  }

  /**
   * Find the shortest component and make it's parent the root node of the other
   * component.
   */
  public void union(final int p, final int q) {
    final int i = find(p);
    final int j = find(q);

    if (sz[p] < sz[q]) {
      id[i] = j;
      sz[j] += sz[i];
    } else {
      id[j] = i;
      sz[i] += sz[j];
    }
  }
}
