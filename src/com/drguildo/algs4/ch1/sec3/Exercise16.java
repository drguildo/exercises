package com.drguildo.algs4.ch1.sec3;

import java.util.Arrays;

import com.drguildo.algs4.ch1.sec2.SmartDate;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;

public class Exercise16 {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(readDates("data/dates.txt")));
  }

  public static SmartDate[] readDates(String name) {
    In in = new In(name);
    Queue<SmartDate> q = new Queue<>();

    SmartDate sd;
    while (!in.isEmpty()) {
      sd = new SmartDate(in.readString());
      q.enqueue(sd);
    }

    int N = q.size();
    SmartDate[] a = new SmartDate[N];
    for (int i = 0; i < N; i++)
      a[i] = q.dequeue();

    return a;
  }
}
