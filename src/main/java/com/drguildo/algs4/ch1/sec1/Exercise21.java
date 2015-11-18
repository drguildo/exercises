package com.drguildo.algs4.ch1.sec1;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercise21 {
  public static void main(String[] args) {
    ArrayList<String> names = new ArrayList<>();
    ArrayList<Float> m = new ArrayList<>();
    ArrayList<Float> n = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNext()) {
      names.add(scanner.next());
      m.add(scanner.nextFloat());
      n.add(scanner.nextFloat());
    }
    scanner.close();

    for (String name : names)
      System.out.print(name + "\t");
    System.out.println();
    for (Float f : m)
      System.out.print(f + "\t");
    System.out.println();
    for (Float f : n)
      System.out.print(f + "\t");
    System.out.println();
    for (int i = 0; i < n.size(); i++)
      System.out.printf("%.3f\t", m.get(i) / n.get(i));
    System.out.println();
  }
}
