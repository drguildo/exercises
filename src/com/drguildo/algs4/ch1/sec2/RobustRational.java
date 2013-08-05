package com.drguildo.algs4.ch1.sec2;

public class RobustRational {
  private long n, d;

  public RobustRational(int n, int d) {
    this.n = n;
    this.d = d;

    int x = gcd(n, d);
    this.n = this.n / x;
    this.d = this.d / x;
  }

  private int robustCast(long x) {
    assert x < Integer.MAX_VALUE;
    assert x > Integer.MIN_VALUE;

    return (int) x;
  }

  public RobustRational plus(RobustRational that) {
    return new RobustRational(robustCast(this.n * that.d + that.n * d),
        robustCast(this.d * that.d));
  }

  public RobustRational times(RobustRational that) {
    return new RobustRational(robustCast(this.n * that.n), robustCast(this.d
        * that.d));
  }

  public RobustRational divides(RobustRational that) {
    return new RobustRational(robustCast(this.n * that.d), robustCast(this.d
        * that.n));
  }

  private int gcd(int p, int q) {
    if (q == 0)
      return p;
    int r = p % q;
    return gcd(q, r);
  }

  public boolean equals(RobustRational that) {
    if (this == that)
      return true;

    if (this.n != that.n)
      return false;

    if (this.d != that.d)
      return false;

    return true;
  }

  @Override
  public String toString() {
    if (n == d)
      return "1";
    return n + "/" + d;
  }

  public static void main(String[] args) {
    RobustRational r1 = new RobustRational(1, 2);
    RobustRational r2 = new RobustRational(2, 4);

    System.out.println(r1.plus(r2));
    System.out.println(r1.times(r2));
    System.out.println(r1.divides(r2));
  }
}
