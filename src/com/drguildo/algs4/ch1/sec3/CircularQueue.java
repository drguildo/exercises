package com.drguildo.algs4.ch1.sec3;

public class CircularQueue<T> {
  private Node last;
  private int n;

  private class Node {
    T item;
    Node next;
  }

  public boolean isEmpty() {
    return last == null;
  }

  public int size() {
    return n;
  }

  public void enqueue(T item) {
    Node newNode = new Node();
    newNode.item = item;

    if (last == null) {
      last = newNode;
      last.next = last;
    }

    Node cur = last;
    while (!cur.next.equals(last))
      cur = cur.next;

    // we've got to the head of the queue
    cur.next = newNode;
    newNode.next = last;
    last = newNode;

    n++;
  }

  public T dequeue() {
    if (isEmpty())
      throw new IllegalArgumentException();

    T item = last.item;

    if (last.next.equals(last)) {
      last = null;
      return item;
    }

    Node cur = last;
    while (!cur.next.equals(last))
      cur = cur.next;
    cur.next = last.next;
    last = cur.next;

    return item;
  }

  public String toString() {
    if (isEmpty())
      return "<empty>";
    else
      return last.item + str(last.next);
  }

  // toString helper
  private String str(Node n) {
    if (n.equals(last))
      return "";
    else
      return " -> " + n.item + str(n.next);
  }

  public static void main(String[] args) {
    CircularQueue<Integer> queue = new CircularQueue<>();
    System.out.println(queue);
    queue.enqueue(123);
    System.out.println(queue);
    queue.enqueue(456);
    System.out.println(queue);
    queue.enqueue(789);
    System.out.println(queue);
  }
}
