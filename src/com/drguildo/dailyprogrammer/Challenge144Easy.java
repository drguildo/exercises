package com.drguildo.dailyprogrammer;

import java.util.HashMap;
import java.util.Scanner;

public class Challenge144Easy {
  public static void main(String[] args) {
    final HashMap<String, Integer> prices = new HashMap<>();
    final Scanner scanner = new Scanner(System.in);

    int numRows = Integer.parseInt(scanner.nextLine());

    for (int i = 0; i < numRows; i++) {
      String line = scanner.nextLine();
      String[] split = line.split("\\s");

      String name = split[0];
      int origPrice = Integer.parseInt(split[1]);

      prices.put(name, origPrice);
    }

    for (int i = 0; i < numRows; i++) {
      String line = scanner.nextLine();
      String[] split = line.split("\\s");

      String name = split[0];
      int newPrice = Integer.parseInt(split[1]);

      if (prices.containsKey(name) && (newPrice != prices.get(name))) {
        int origPrice = prices.get(name);

        System.out.print(name);
        System.out.print(" ");
        if (newPrice > origPrice)
          System.out.print("+");
        System.out.println(newPrice - origPrice);
      }
    }

    scanner.close();
  }
}
