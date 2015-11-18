package com.drguildo.algs4.ch1.sec2;

import java.util.ArrayList;
import java.util.Scanner;

import edu.princeton.cs.algs4.Interval1D;

public class Exercise2 {
  public static void main(String[] args) {
    if (args.length < 1)
      System.exit(-1);

    int n = Integer.parseInt(args[0]);

    Scanner scanner = new Scanner(System.in);

    double a, b;
    int read = 0;
    ArrayList<Interval1D> intervals = new ArrayList<>();
    Interval1D interval;
    while (read < n) {
      a = scanner.nextDouble();
      b = scanner.nextDouble();

      if (a < b)
        interval = new Interval1D(a, b);
      else
        interval = new Interval1D(b, b);

      for (Interval1D i : intervals)
        if (interval.intersects(i))
          System.out.println(interval + " intersects " + i);

      intervals.add(interval);

      read++;
    }

    scanner.close();
  }
}
