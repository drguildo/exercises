package com.drguildo.algs4.ch1.sec3;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise8<Item> {
  @SuppressWarnings("unchecked")
  private Item[] a = (Item[]) new Object[1];
  private int N = 0;

  public boolean isEmpty() {
    return N == 0;
  }

  public int size() {
    return N;
  }

  private void resize(int max) {
    @SuppressWarnings("unchecked")
    Item[] temp = (Item[]) new Object[max];
    for (int i = 0; i < N; i++)
      temp[i] = a[i];
    a = temp;
  }

  public void push(Item item) {
    if (N == a.length)
      resize(2 * a.length);
    a[N++] = item;
    System.out.println("push(" + item + ")");
    System.out.println("items: " + size());
    System.out.println("array size: " + a.length);
    System.out.println(Arrays.toString(a));
  }

  public Item pop() {
    Item item = a[--N];
    a[N] = null;
    if (N > 0 && N == a.length / 4)
      resize(a.length / 2);
    System.out.println("pop(" + item + ")");
    System.out.println("items: " + size());
    System.out.println("array size: " + a.length);
    System.out.println(Arrays.toString(a));
    return item;
  }

  public static void main(String[] args) {
    Exercise8<String> s = new Exercise8<>();

    Scanner scanner = new Scanner(
        "it was - the best - of times - - - it was - the - -");

    while (scanner.hasNext()) {
      String item = scanner.next();
      if (!item.equals("-"))
        s.push(item);
      else if (!s.isEmpty())
        s.pop();
    }

    scanner.close();
  }
}
