package com.drguildo.algs4.ch1.sec3;

import edu.princeton.cs.algs4.Queue;

public class Exercise15 {
  public static void main(String[] args) {
    Queue<String> q = new Queue<>();

    if (args.length < 2)
      System.exit(-1);

    for (int i = 1; i < args.length; i++)
      q.enqueue(args[i]);

    // how many items to dequeue to get the one we want
    int k = q.size() - Integer.parseInt(args[0]) - 1;

    if (k < 0 || k >= q.size())
      throw new IndexOutOfBoundsException();

    while (k > 0) {
      q.dequeue();
      k--;
    }

    System.out.println(q.dequeue());
  }
}
