package com.drguildo.algs4.ch1.sec2;

import java.util.Random;

import edu.princeton.cs.algs4.StdDraw;

public class VisualCounter implements Comparable<VisualCounter> {
  private int maxops;
  private int maxcount;

  private int count = 0;
  private int ops = 0;

  private String name;

  public VisualCounter(String name, int maxops, int maxcount) {
    this.maxops = maxops;
    this.maxcount = maxcount;
    this.name = name;
  }

  public void increment() {
    if (ops == maxops || count == maxcount)
      return;

    ops++;
    count++;

    draw();
  }

  public void decrement() {
    if (ops == maxops)
      return;

    ops++;
    count--;

    draw();
  }

  public int tally() {
    return count;
  }

  public void draw() {
    System.out.println("x: " + (double) ops / maxops + ", y: " + (double) count
        / maxcount);
    StdDraw.point((double) ops / maxops, (double) count / maxcount);
  }

  @Override
  public String toString() {
    return count + " " + name;
  }

  @Override
  public int compareTo(VisualCounter that) {
    if (this.count < that.count)
      return -1;
    else if (this.count > that.count)
      return 1;
    else
      return 0;
  }

  public static void main(String[] args) {
    Random rand = new Random();
    VisualCounter counter = new VisualCounter("doodads", 1000, 1000);
    for (int i = 0; i < 1000; i++) {
      if (rand.nextInt(10) < 8)
        counter.increment();
      else
        counter.decrement();
    }
    System.out.println(counter);
  }
}
