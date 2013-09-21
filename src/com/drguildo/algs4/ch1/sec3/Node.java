package com.drguildo.algs4.ch1.sec3;

public class Node<T> {
  T item;
  Node<T> next;

  public Node() {
    this.item = null;
    this.next = null;
  }

  public Node(T item) {
    this.item = item;
    this.next = null;
  }
}
