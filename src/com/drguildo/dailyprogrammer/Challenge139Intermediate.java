package com.drguildo.dailyprogrammer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Telephone Keypads commonly have both digits and characters on them. This
 * is to help with remembering & typing phone numbers (called a Phoneword),
 * like 1-800-PROGRAM rather than 1-800-776-4726. This keypad layout is also
 * helpful with T9, a way to type texts with word prediction.
 * 
 * Your goal is to mimic some of the T9-features: given a series of digits from
 * a telephone keypad, and a list of English words, print the word or set of
 * words that fits the starting pattern. You will be given the number of
 * button-presses and digit, narrowing down the search-space.
 */
public class Challenge139Intermediate {
  private static final HashMap<Integer, String> map = new HashMap<>();

  public static void main(String[] args) {
    String prefix = "";

    map.put(2, "ABC");
    map.put(3, "DEF");
    map.put(4, "GHI");
    map.put(5, "JKL");
    map.put(6, "MNO");
    map.put(7, "PQRS");
    map.put(8, "TUV");
    map.put(9, "WXYZ");

    Scanner scanner = new Scanner("7777 666 555 3");

    String token;
    while (scanner.hasNext()) {
      token = scanner.next();
      prefix = prefix + pressesToCharacter(token);
    }
    prefix = prefix.toLowerCase();

    scanner.close();

    try {
      scanner = new Scanner(new File("data/brit-a-z.txt"));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    String word;
    while (scanner.hasNextLine()) {
      word = scanner.nextLine().trim();
      if (word.startsWith(prefix))
        System.out.println(word);
    }

    scanner.close();
  }

  public static char pressesToCharacter(String presses) {
    String group = map.get(Character.getNumericValue(presses.charAt(0)));
    int idx = (presses.length() - 1) % group.length();

    return group.toCharArray()[idx];
  }
}
