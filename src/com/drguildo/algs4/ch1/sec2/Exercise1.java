package com.drguildo.algs4.ch1.sec2;

import java.util.Random;

import edu.princeton.cs.algs4.Point2D;

public class Exercise1 {
  public static void main(String[] args) {
    if (args.length < 1)
      System.exit(-1);

    Random rand = new Random();
    Point2D[] points = new Point2D[Integer.parseInt(args[0])];

    if (points.length < 2)
      System.exit(-1);

    for (int i = 0; i < points.length; i++)
      points[i] = new Point2D(rand.nextDouble(), rand.nextDouble());

    double shortest = points[0].distanceTo(points[1]);
    for (int i = 0; i < points.length - 1; i++) {
      for (int j = i + 1; j < points.length; j++) {
        if (points[i].distanceTo(points[j]) < shortest) {
          shortest = points[i].distanceTo(points[j]);
          System.out.println(shortest + " is new shortest distance.");
        }
      }
    }

    System.out.println("Shortest: " + shortest);
  }
}
