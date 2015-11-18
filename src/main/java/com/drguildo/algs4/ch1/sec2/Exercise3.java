package com.drguildo.algs4.ch1.sec2;

import java.util.Arrays;
import java.util.Random;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.Interval2D;

public class Exercise3 {
  private static final Random rand = new Random();

  private static Interval1D rndIntrvl(double min, double max) {
    double diff = max - min;

    double a = min + rand.nextDouble() * diff;
    double b = min + rand.nextDouble() * diff;

    if (a < b)
      return new Interval1D(a, b);
    else
      return new Interval1D(b, a);
  }

  public static void main(String[] args) {
    if (args.length < 3)
      System.exit(-1);

    int n = Integer.parseInt(args[0]);
    double min = Double.parseDouble(args[1]);
    double max = Double.parseDouble(args[2]);

    if (min < 0.0 || min > 1.0 || max < 0.0 || max > 1.0)
      System.exit(-1);

    Interval2D[] intervals = new Interval2D[n];

    for (int i = 0; i < n; i++) {
      intervals[i] = new Interval2D(rndIntrvl(min, max), rndIntrvl(min, max));
      intervals[i].draw();
    }

    System.out.println(Arrays.toString(intervals));

    int intrsctcnt = 0;
    for (int i = 0; i < intervals.length - 1; i++) {
      for (int j = i + 1; j < intervals.length; j++) {
        if (intervals[i].intersects(intervals[j]))
          intrsctcnt++;
        // XXX I don't think it's possible to detect the number of intervals
        // contained in others.
      }
    }

    System.out.println("Intersect: " + intrsctcnt);
  }
}
