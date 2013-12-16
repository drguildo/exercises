package com.drguildo.dailyprogrammer;

import java.util.HashMap;
import java.util.Scanner;

/**
 * You have just been hired at a local home improvement store to help compute
 * the proper costs of inventory. The current prices are out of date and wrong;
 * you have to figure out which items need to be re-labelled with the correct
 * price.
 * 
 * You will be first given a list of item-names and their current price. You
 * will then be given another list of the same item-names but with the correct
 * price. You must then print a list of items that have changed, and by how
 * much.
 * 
 * URL: http://www.reddit.com/r/dailyprogrammer/comments/1sob1e/121113_challenge_144_easy_nuts_bolts/
 */
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
