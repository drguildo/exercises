package com.drguildo.dailyprogrammer;

import java.util.HashMap;
import java.util.Scanner;

public class Challenge144Easy {
  public static void main(String[] args) {
    final HashMap<String, Integer> oldPrices = new HashMap<>();
    final Scanner scanner = new Scanner(System.in);

    int numRows = Integer.parseInt(scanner.nextLine());

    for (int i = 0; i < numRows; i++) {
      String line = scanner.nextLine();
      String[] split = line.split("\\s");

      String name = split[0];
      int oldPrice = Integer.parseInt(split[1]);

      oldPrices.put(name, oldPrice);
    }

    for (int i = 0; i < numRows; i++) {
      String line = scanner.nextLine();
      String[] split = line.split("\\s");

      String name = split[0];
      int newPrice = Integer.parseInt(split[1]);

      if (oldPrices.containsKey(name) && (newPrice != oldPrices.get(name))) {
        int oldPrice = oldPrices.get(name);

        System.out.println(String.format("%s %s%d", name,
            (newPrice > oldPrice) ? "+" : "", newPrice - oldPrice));
      }
    }

    scanner.close();
  }
}
