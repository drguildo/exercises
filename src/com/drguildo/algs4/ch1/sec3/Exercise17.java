package com.drguildo.algs4.ch1.sec3;

import java.util.Arrays;

import com.drguildo.algs4.ch1.sec2.Transaction;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;

public class Exercise17 {
  public static void main(String[] args) {
    System.out.println(Arrays
        .toString(readTransaction("data/transactions.txt")));
  }

  public static Transaction[] readTransaction(String name) {
    In in = new In(name);
    Queue<Transaction> q = new Queue<>();

    Transaction sd;
    while (!in.isEmpty()) {
      sd = new Transaction(in.readLine());
      q.enqueue(sd);
    }

    int N = q.size();
    Transaction[] a = new Transaction[N];
    for (int i = 0; i < N; i++)
      a[i] = q.dequeue();

    return a;
  }
}
