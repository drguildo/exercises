package com.drguildo.algs4.ch1.sec2;

public class Accumulator {
  private double m;
  private double s;
  private int N;

  public void addDataValue(double x) {
    N++;
    s = s + 1.0 * (N - 1) / N * (x - m) * (x - m);
    m = m + (x - m) / N;
  }

  public double mean() {
    return m;
  }

  public double var() {
    return s / (N - 1);
  }

  public double stddev() {
    return Math.sqrt(this.var());
  }

  public static void main(String[] args) {
    Accumulator ac = new Accumulator();
    ac.addDataValue(1.0);
    ac.addDataValue(2.0);
    ac.addDataValue(1.0);
    ac.addDataValue(2.0);
    System.out.println(ac.mean());
    System.out.println(ac.var());
    System.out.println(ac.stddev());
  }
}
