package com.drguildo.algs4.ch1.sec3;

import org.junit.Test;
import static org.junit.Assert.*;

import static com.drguildo.algs4.ch1.sec3.DoublyLinkedList.*;

public class DoublyLinkedListTest {
  @Test
  public void itemShouldMatchConstructorArg() {
    DoubleNode<Integer> head = new DoubleNode<>(1);
    assertEquals((Integer) 1, head.item);
  }

  @Test
  public void singleNodeListShouldHaveNullPointers() {
    DoubleNode<Integer> head = new DoubleNode<>(1);
    assertNull(head.next);
    assertNull(head.prev);
  }

  @Test
  public void insertBeginningShouldPutNewItemFirst() {
    DoubleNode<Integer> head = new DoubleNode<>(1);
    DoubleNode<Integer> first = new DoubleNode<>(2);
    DoubleNode<Integer> result = insertBeginning(head, first);

    // Check order of nodes.
    assertSame(first, result);
    assertSame(first.next, head);
    assertSame(head.prev, first);
  }

  @Test
  public void insertEndShouldPutNewItemLast() {
    DoubleNode<Integer> head = new DoubleNode<>(1);
    DoubleNode<Integer> last = new DoubleNode<>(2);
    DoubleNode<Integer> result = insertEnd(head, last);

    // Check order of nodes.
    assertSame(head, result);
    assertSame(last.prev, head);
    assertSame(head.next, last);
  }

  @Test
  public void removeBeginningShouldMakeNextHeadAndClearPrevPointer() {
    DoubleNode<Integer> head = getList(4);
    DoubleNode<Integer> rest = removeBeginning(head);

    assertNotSame(head, rest);
    assertSame(head.next, rest);
    assertEquals((Integer) 1, rest.item);
    assertNull(rest.prev);
  }

  @Test
  public void removeEndShouldClearNextPointer() {
    DoubleNode<Integer> head = getList(2);

    // Confirm that head points to the last node.
    assertNull(head.next.next);

    DoubleNode<Integer> rest = removeEnd(head);
    assertSame(head, rest);
    assertNull(head.next);
  }

  @Test
  public void removeBeginningOnSingleNodeShouldReturnNull() {
    DoubleNode<Integer> head = new DoubleNode<>(1);
    DoubleNode<Integer> rest = removeBeginning(head);
    assertNull(rest);
  }

  @Test
  public void removeEndOnSingleNodeShouldReturnNull() {
    DoubleNode<Integer> head = new DoubleNode<>(1);
    DoubleNode<Integer> rest = removeEnd(head);
    assertNull(rest);
  }

  // This is a special case of insertBefore which has exactly the same
  // result as insertBeginning.
  @Test
  public void insertBeforeFirstNodeShouldPutNewNodeFirst() {
    DoubleNode<Integer> head = new DoubleNode<>(1);
    DoubleNode<Integer> first = new DoubleNode<>(2);
    DoubleNode<Integer> result = insertBefore(head, first, 0);
    assertSame(first, result);
    assertSame(first.next, head);
    assertSame(first, head.prev);
  }

  // Given a one-node list, insertBefore with index 1 would insert the
  // new node before an imaginary last node. From one perspective this
  // doesn't make sense. From another perspective, this is just the same
  // as insertAfter with index 0.
  @Test
  public void insertingBeforeImaginaryEndOfListDoesNotWork() {
    DoubleNode<Integer> head = new DoubleNode<>(1);
    DoubleNode<Integer> second = new DoubleNode<>(2);
    DoubleNode<Integer> result = insertBefore(head, second, 1);
    assertSame(head, result);

    // Contrast this with insertBeforeFirstNodeShouldPutNewNodeFirst.
    assertNull(head.next);
    assertNull(second.next);
    assertNull(second.prev);
  }

  @Test
  public void insertBeforeEndShouldPutNewNodeInTheMiddle() {
    DoubleNode<Integer> head = getList(2);
    DoubleNode<Integer> tail = head.next;
    DoubleNode<Integer> middle = new DoubleNode<>(2);

    head = insertBefore(head, middle, 1);
    testHeadMiddleTail(head, middle, tail);
  }

  @Test
  public void insertAfterFirstShouldPutNewNodeAtTheEnd() {
    DoubleNode<Integer> head = new DoubleNode<>(1);
    DoubleNode<Integer> last = new DoubleNode<>(2);

    DoubleNode<Integer> result = insertAfter(head, last, 0);
    assertSame(head, result);
    assertSame(head.next, last);
    assertSame(head, last.prev);
  }

  // See comments for insertingBeforeImaginaryEndOfListDoesNotWork.
  @Test
  public void insertingAfterImaginaryFirstDoesNotWork() {
    DoubleNode<Integer> head = new DoubleNode<>(1);
    DoubleNode<Integer> second = new DoubleNode<>(2);
    DoubleNode<Integer> result = insertAfter(head, second, -1);
    assertSame(head, result);

    assertNull(head.next);
    assertNull(head.prev);
    assertNull(second.next);
  }

  @Test
  public void insertAfterFirstShouldPutNewNodeInTheMiddle() {
    DoubleNode<Integer> head = getList(2);
    DoubleNode<Integer> tail = head.next;
    DoubleNode<Integer> middle = new DoubleNode<>(2);

    head = insertAfter(head, middle, 0);
    testHeadMiddleTail(head, middle, tail);
  }

  private void testHeadMiddleTail(DoubleNode<Integer> head,
      DoubleNode<Integer> middle, DoubleNode<Integer> tail) {
    // Check that head and tail are really the head and tail.
    assertNull(head.prev);
    assertNull(tail.next);

    // Check that middle is really in the middle.
    assertSame(head, middle.prev);
    assertSame(tail, middle.next);
    assertSame(middle, head.next);
    assertSame(middle, tail.prev);
  }

  // Depends on the correct operation of insertEnd.
  private DoubleNode<Integer> getList(int len) {
    DoubleNode<Integer> head = new DoubleNode<Integer>(0);
    for (int i = 1; i < len; i++) {
      head = insertEnd(head, new DoubleNode<Integer>(i));
    }
    return head;
  }

  public static void main(String[] args) {
    String testName = "com.drguildo.algs4.ch1.sec3.DoublyLinkedListTest";
    org.junit.runner.JUnitCore.main(testName);
  }
}
