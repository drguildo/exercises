package com.drguildo.algs4.ch1.sec3;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

public class Exercise6 {
  public static void main(String[] args) {
    Queue<String> q = new Queue<>();
    q.enqueue("to");
    q.enqueue("be");
    q.enqueue("or");
    q.enqueue("not");
    q.enqueue("to");
    q.enqueue("be");

    Stack<String> stack = new Stack<String>();
    while (!q.isEmpty())
      stack.push(q.dequeue());
    while (!stack.isEmpty())
      q.enqueue(stack.pop());

    for (String s : q)
      System.out.println(s);
  }
}
