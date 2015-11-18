package com.drguildo.algs4.ch1.sec2;

public class Rational {
  private long n, d;

  public Rational(int n, int d) {
    this.n = n;
    this.d = d;

    int x = gcd(n, d);
    this.n = this.n / x;
    this.d = this.d / x;
  }

  public Rational plus(Rational that) {
    return new Rational((int) (this.n * that.d + that.n * d),
        (int) (this.d * that.d));
  }

  public Rational times(Rational that) {
    return new Rational((int) (this.n * that.n), (int) (this.d * that.d));
  }

  public Rational divides(Rational that) {
    return new Rational((int) (this.n * that.d), (int) (this.d * that.n));
  }

  private int gcd(int p, int q) {
    if (q == 0)
      return p;
    int r = p % q;
    return gcd(q, r);
  }

  public boolean equals(Rational that) {
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
    return n + "/" + d;
  }

  public static void main(String[] args) {
    Rational r1 = new Rational(1, 2);
    Rational r2 = new Rational(2, 4);

    System.out.println(r1.plus(r2));
  }
}
