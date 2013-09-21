package com.drguildo.algs4.ch1.sec3;

public class DoublyLinkedList<T> {
  static class DoubleNode<T> {
    T item;
    DoubleNode<T> prev;
    DoubleNode<T> next;

    DoubleNode() {
      prev = null;
      next = null;
    }

    DoubleNode(T item) {
      this.item = item;
    }
  }

  public static <T> DoubleNode<T> insertBeginning(DoubleNode<T> head,
      DoubleNode<T> node) {
    head.prev = node;
    node.next = head;

    return node;
  }

  public static <T> DoubleNode<T> insertEnd(DoubleNode<T> head,
      DoubleNode<T> node) {
    if (head.next == null) {
      head.next = node;
      node.prev = head;
    } else
      insertEnd(head.next, node);

    return head;
  }

  public static <T> DoubleNode<T> removeBeginning(DoubleNode<T> head) {
    DoubleNode<T> newHead = head.next;

    if (newHead != null) {
      newHead.prev = null;
    }

    return newHead;
  }

  public static <T> DoubleNode<T> removeEnd(DoubleNode<T> head) {
    if (head == null)
      return null;

    if (head.next == null)
      return null;

    if (head.next.next == null)
      head.next = null;
    else
      removeEnd(head.next);

    return head;
  }

  public static <T> DoubleNode<T> insertBefore(DoubleNode<T> head,
      DoubleNode<T> node, int idx) {
    if (head.next == null)
      if (idx == 0) {
        node.next = head;
        head.prev = node;
        return node;
      } else
        return head;

    DoubleNode<T> next = insertBefore(head.next, node, idx - 1);

    if (idx == 0) {
      node.next = head;
      head.prev = node;
      return node;
    } else {
      head.next = next;
      next.prev = head;
      return head;
    }
  }

  public static <T> DoubleNode<T> insertAfter(DoubleNode<T> head,
      DoubleNode<T> node, int idx) {
    if (head.next == null) {
      if (idx == 0) {
        node.prev = head;
        head.next = node;
        return head;
      }
      return head;
    }

    DoubleNode<T> next = insertAfter(head.next, node, idx - 1);

    if (idx == 0) {
      node.prev = head;
      node.next = next;
      head.next = node;
      next.prev = node;
    } else {
      head.next = next;
      next.prev = head;
    }

    return head;
  }

  public static <T> DoubleNode<T> remove(DoubleNode<T> head, int idx) {
    if (head.next == null)
      if (idx == 0)
        return null;
      else
        return head;

    DoubleNode<T> next = remove(head.next, idx - 1);

    if (idx == 0) {
      return head.next;
    }

    head.next = next;
    if (next != null)
      next.prev = head;

    return head;
  }

  public static <T> void print(DoubleNode<T> node) {
    if (node.next == null) {
      System.out.println(node.item);
      return;
    }

    System.out.print(node.item + " <=> ");

    print(node.next);
  }

  public static void main(String[] args) {
    DoubleNode<Integer> head = new DoubleNode<>(10);
    head = insertBeginning(head, new DoubleNode<>(30));
    print(head);
    head = insertAfter(head, new DoubleNode<>(20), 0);
    print(head);
  }
}
