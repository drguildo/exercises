package com.drguildo.algs4.ch1.sec1;

public class Euclid {
  public static void main(String[] args) {
    if (args.length < 2)
      System.exit(1);

    int p = Integer.parseInt(args[0]);
    int q = Integer.parseInt(args[1]);
    System.out.printf("gcd(%d, %d): %d\n", p, q, gcd(p, q));
  }

  public static int gcd(int p, int q) {
    System.out.printf("p: %d q: %d\n", p, q);
    // If q = 0 then p is the gcd since 0 / p = 0 for any value p since
    // 0 * p = 0.
    if (q == 0)
      return p;
    // if q > 0 then we divide p by q. r will be the remainder which is either
    // 0, in which case we have found the gcd, or r will be the remainder, which
    // will be less than q. This replaces q as the second argument to gcd() and
    // so q converges on 0.
    int r = p % q;
    return gcd(q, r);
  }
}
