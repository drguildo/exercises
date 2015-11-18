package com.drguildo.algs4.ch1.sec1;

import java.util.Arrays;
import java.util.Random;

public class Exercise35 {
  private static Random rand = new Random();

  private static int diceRoll() {
    return rand.nextInt(6) + 1;
  }

  public static void main(String[] args) {
    if (args.length < 1)
      System.exit(-1);

    int SIDES = 6;
    double[] dist = new double[2 * SIDES + 1];

    for (int i = 1; i <= SIDES; i++)
      for (int j = 1; j <= SIDES; j++)
        dist[i + j] += 1.0;

    for (int k = 2; k <= 2 * SIDES; k++)
      dist[k] = (double) Math.round((dist[k] / 36) * 1000) / 1000;

    System.out.println(Arrays.toString(dist));

    double[] rolls = new double[2 * SIDES + 1];

    int n = Integer.parseInt(args[0]);
    for (int i = 0; i < n; i++)
      rolls[diceRoll() + diceRoll()] += 1.0;

    for (int k = 2; k <= 2 * SIDES; k++)
      rolls[k] = (double) Math.round((rolls[k] / n) * 1000) / 1000;

    System.out.println(Arrays.toString(rolls));
  }
}
