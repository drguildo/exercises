package com.drguildo.algs4.ch1.sec1;

import io.sjm.sjmlib.Arrays;

import java.util.Scanner;

import edu.princeton.cs.algs4.StdDraw;

public class Exercise32 {
  public static void main(String[] args) {
    if (args.length < 3)
      System.exit(-1);

    int n = Integer.parseInt(args[0]);
    double l = Double.parseDouble(args[1]);
    double r = Double.parseDouble(args[2]);

    double inc = (r - l) / n;

    int[] hist = new int[n];

    Scanner s = new Scanner(System.in);
    while (s.hasNext()) {
      double x = s.nextDouble();
      if (x >= l && x <= r) {
        int i = (int) Math.floor((x - l) / inc);
        hist[i]++;
      }
    }
    s.close();

    double barwidth = 1.0 / (hist.length - 1);

    int max = Arrays.max(hist);

    for (int i = 0; i < hist.length; i++) {
      System.out.printf("%d/%d\n", max, hist[i]);
      System.out.println((double) hist[i] / max);

      double barheight = ((double) hist[i] / max);
      StdDraw.setPenColor(StdDraw.RED);
      StdDraw.filledRectangle(i * barwidth, barheight / 2, barwidth / 2,
          barheight / 2);
      StdDraw.setPenColor(StdDraw.BLACK);
      StdDraw.rectangle(i * barwidth, barheight / 2, barwidth / 2,
          barheight / 2);
    }
  }
}
