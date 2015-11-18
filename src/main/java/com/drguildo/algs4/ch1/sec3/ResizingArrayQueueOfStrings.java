package com.drguildo.algs4.ch1.sec3;

import java.util.Arrays;

public class ResizingArrayQueueOfStrings {
  private String[] elems; // the elements in the queue
  private int n; // the number of elements
  private int front, back;

  // create an empty queue
  public ResizingArrayQueueOfStrings() {
    elems = new String[2];
    n = 0;
    front = 0;
    back = 0;
  }

  // add an item
  public void enqueue(String s) {
    // add the new string to the array
    elems[back++] = s;
    n++;

    // check whether we need to make more space
    if (back >= elems.length) {
      // if there's space at the beginning of the array then move everything
      // down to make space at the end
      if (front != 0) {
        optimise();
      } else {
        // otherwise increase the size of the array
        elems = Arrays.copyOf(elems, elems.length * 2);
      }
    }
  }

  // remove the least recently added item
  public String dequeue() {
    if (n == 0)
      throw new java.util.NoSuchElementException();

    String s = elems[front];
    elems[front++] = null;
    n--;
    return s;
  }

  // is the queue empty?
  public boolean isEmpty() {
    return n == 0;
  }

  // number of items in the queue
  public int size() {
    return n;
  }

  private void optimise() {
    if (front == 0)
      return;

    for (int i = 0; i < n; i++) {
      elems[i] = elems[front + i];
      elems[front + i] = null;
    }

    front = 0;
    back = n;
  }
}
