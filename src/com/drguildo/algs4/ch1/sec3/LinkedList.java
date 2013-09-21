package com.drguildo.algs4.ch1.sec3;

public class LinkedList<T> {
  private Node<T> first;
  private Node<T> last;
  private int n;

  public boolean isEmpty() {
    return first == null;
  }

  public int size() {
    return n;
  }

  public void enqueue(T item) {
    Node<T> node = new Node<>(item);
    enqueue(node);
  }

  public void enqueue(Node<T> node) {
    if (isEmpty()) {
      first = node;
      last = node;
    } else {
      last.next = node;
      last = node;
    }
    n++;
  }

  public T dequeue() {
    T item = first.item;
    first = first.next;
    if (isEmpty())
      last = null;
    n--;
    return item;
  }

  public void delete(int k) {
    if (size() == 0)
      return;

    if (k == 0) {
      if (first.next != null)
        first = first.next;
      else {
        first = null;
        last = null;
      }
      return;
    }

    Node<T> node = first;
    while (k > 1 && node.next != null) {
      k--;
      node = node.next;
    }
    if (node != null && node.next != null) {
      node.next = node.next.next;
    }
  }

  public boolean find(T item) {
    Node<T> node = first;
    while (node != null) {
      if (node.item.equals(item))
        return true;
      else
        node = node.next;
    }
    return false;
  }

  public void removeAfter(Node<T> node) {
    if (node == null)
      return;

    if (node.next != null)
      node.next = node.next.next;
  }

  // insert b after a
  public void insertAfter(Node<T> a, Node<T> b) {
    if (a == null || b == null)
      return;

    b.next = a.next;
    a.next = b;
  }

  public void remove(T item) {
    if (size() == 0)
      return;

    Node<T> cur = first;

    // if there is only one item in the list, remove it if it matches
    if (first.next == null) {
      if (first.item.equals(item)) {
        first = null;
        last = null;
      }
      return;
    }

    // to avoid having to keep modifying first in the case where a number of
    // elements at the head of the list match, we ignore the head of the list
    // until we've processed the rest of it.
    while (cur != null && cur.next != null) {
      while (cur.next != null && cur.next.item.equals(item))
        removeAfter(cur);
      cur = cur.next;
    }

    if (first.item.equals(item)) {
      first = first.next;
    }
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    Node<T> node = first;
    while (node != null) {
      sb.append(node.item);
      if (node.next != null)
        sb.append(" -> ");
      node = node.next;
    }
    sb.append("}");

    return sb.toString();
  }

  public static Integer max(Node<Integer> node) {
    if (node == null)
      throw new IllegalArgumentException();

    Integer m = node.item;
    while (node.next != null) {
      node = node.next;
      if (node.item > m)
        m = node.item;
    }

    return m;
  }

  // a recursive implementation of max()
  public static Integer max2(Node<Integer> node) {
    if (node == null)
      throw new IllegalArgumentException();

    return maxRecur(node, node.item);
  }

  // see max2()
  public static Integer maxRecur(Node<Integer> node, Integer m) {
    if (node == null)
      return m;

    if (node.item > m)
      return maxRecur(node.next, node.item);
    else
      return maxRecur(node.next, m);
  }

  // non-destructive reversal
  public static <T> Node<T> reverse(Node<T> n) {
    return reverseRecur(n, null);
  }

  // see reverse()
  public static <T> Node<T> reverseRecur(Node<T> pred, Node<T> succ) {
    // in the original linked list, the last element will point to null.
    if (pred.next == null) {
      pred.next = succ;
      return pred;
    } else {
      Node<T> tmp = pred.next;
      pred.next = succ;
      return reverseRecur(tmp, pred);
    }
  }

  public static <T> Node<T> reverseDestr(Node<T> cur) {
    if (cur == null)
      return null;

    // if if the next node is null, that means we're at the end of the original
    // list. we want this to be the new head of the list and so we return it and
    // the return cascades back to the original call.
    if (cur.next == null)
      return cur;

    Node<T> first = reverseDestr(cur.next);

    Node<T> next = cur.next;
    next.next = cur;
    cur.next = null;

    return first;
  }

  // prints a linked list starting at cur
  public static <T> void print(Node<T> cur) {
    if (cur.next == null) {
      System.out.println(cur.item);
      return;
    }

    System.out.print(cur.item + " -> ");

    print(cur.next);
  }

  public static void main(String[] args) {
    LinkedList<Integer> list = new LinkedList<>();
    Node<Integer> test = new Node<>(666);

    list.enqueue(test);
    list.enqueue(123);
    list.enqueue(456);
    list.enqueue(783);
    list.enqueue(135);

    print(list.first);
    Node<Integer> n = reverseDestr(list.first);
    print(n);
  }
}
