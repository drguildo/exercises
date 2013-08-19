package edu.princeton.cs.algs4;

/*************************************************************************
 *  Compilation:  javac ResizingArrayQueue.java
 *  Execution:    java ResizingArrayQueue < input.txt
 *  Data files:   http://algs4.cs.princeton.edu/13stacks/tobe.txt
 *
 *  Queue implementation with a resizing array.
 *
 *  % java ResizingArrayQueue < tobe.txt
 *  to be or not to be (2 left on queue)
 *
 *************************************************************************/

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizingArrayQueue<Item> implements Iterable<Item> {
  private Item[] q; // queue elements
  private int N = 0; // number of elements on queue
  private int first = 0; // index of first element of queue
  private int last = 0; // index of next available slot

  // cast needed since no generic array creation in Java
  @SuppressWarnings("unchecked")
  public ResizingArrayQueue() {
    q = (Item[]) new Object[2];
  }

  public boolean isEmpty() {
    return N == 0;
  }

  public int size() {
    return N;
  }

  // resize the underlying array
  @SuppressWarnings("unchecked")
  private void resize(int max) {
    assert max >= N;
    Item[] temp = (Item[]) new Object[max];
    for (int i = 0; i < N; i++) {
      temp[i] = q[(first + i) % q.length];
    }
    q = temp;
    first = 0;
    last = N;
  }

  public void enqueue(Item item) {
    // double size of array if necessary and recopy to front of array
    if (N == q.length)
      resize(2 * q.length); // double size of array if necessary
    q[last++] = item; // add item
    if (last == q.length)
      last = 0; // wrap-around
    N++;
  }

  // remove the least recently added item
  public Item dequeue() {
    if (isEmpty())
      throw new NoSuchElementException("Queue underflow");
    Item item = q[first];
    q[first] = null; // to avoid loitering
    N--;
    first++;
    if (first == q.length)
      first = 0; // wrap-around
    // shrink size of array if necessary
    if (N > 0 && N == q.length / 4)
      resize(q.length / 2);
    return item;
  }

  @Override
  public Iterator<Item> iterator() {
    return new ArrayIterator();
  }

  // an iterator, doesn't implement remove() since it's optional
  private class ArrayIterator implements Iterator<Item> {
    private int i = 0;

    @Override
    public boolean hasNext() {
      return i < N;
    }

    @Override
    public void remove() {
      throw new UnsupportedOperationException();
    }

    @Override
    public Item next() {
      if (!hasNext())
        throw new NoSuchElementException();
      Item item = q[(i + first) % q.length];
      i++;
      return item;
    }
  }

  /**
    * A test client.
    */
  public static void main(String[] args) {
    ResizingArrayQueue<String> q = new ResizingArrayQueue<String>();
    while (!StdIn.isEmpty()) {
      String item = StdIn.readString();
      if (!item.equals("-"))
        q.enqueue(item);
      else if (!q.isEmpty())
        StdOut.print(q.dequeue() + " ");
    }
    StdOut.println("(" + q.size() + " left on queue)");
  }

}
