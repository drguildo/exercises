package com.drguildo.algs4.ch1.sec3;

import java.util.NoSuchElementException;

public class Stack<Item> {
  private Node first;
  private int N;

  private class Node {
    Item item;
    Node next;
  }

  public boolean isEmpty() {
    return first == null;
  }

  public int size() {
    return N;
  }

  public void push(Item item) {
    Node oldfirst = first;
    first = new Node();
    first.item = item;
    first.next = oldfirst;
    N++;
  }

  public Item pop() {
    Item item = first.item;
    first = first.next;
    N--;
    return item;
  }

  public Item peek() {
    if (isEmpty())
      throw new NoSuchElementException();

    return first.item;
  }
}
