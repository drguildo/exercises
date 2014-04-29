package com.drguildo.dailyprogrammer.intermediate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * The Gorellians, at the far end of our galaxy, have discovered various samples
 * of English text from our electronic transmissions, but they did not find the
 * order of our alphabet. Being a very organized and orderly species, they want
 * to have a way of ordering words, even in the strange symbols of English.
 * Hence they must determine their own order.
 * 
 * For instance, if they agree on the alphabetical order:
 * 
 * UVWXYZNOPQRSTHIJKLMABCDEFG
 * 
 * Then the following words would be in sorted order based on the above alphabet
 * order:
 * 
 * WHATEVER
 * ZONE
 * HOW
 * HOWEVER
 * HILL
 * ANY
 * ANTLER
 * COW
 * 
 * URL: http://redd.it/20sjif
 */
public class GorellianAlphabetSort {
  private static class GorellianComparator implements Comparator<String> {
    private String alphabet;

    public GorellianComparator(String letters) {
      alphabet = letters.toLowerCase();
    }

    @Override
    public int compare(String a, String b) {
      a = a.toLowerCase();
      b = b.toLowerCase();

      int i = 0;
      while (i < a.length() && i < b.length()) {
        if (a.charAt(i) == b.charAt(i)) {
          i++;
          continue;
        }

        for (char c : alphabet.toCharArray()) {
          if (a.charAt(i) == c)
            return -1;
          if (b.charAt(i) == c)
            return 1;
        }

        i++;
      }

      if (i >= a.length())
        return -1;
      if (i >= b.length())
        return 1;

      return 0;
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner("5 ZYXWVuTSRQpONMLkJIHGFEDCBa\n" + "go\n"
        + "aLL\n" + "ACM\n" + "teamS\n" + "Go");

    int n = scanner.nextInt();
    String alphabet = scanner.nextLine();
    ArrayList<String> wordList = new ArrayList<>();

    while (scanner.hasNextLine() && n > 0) {
      wordList.add(scanner.nextLine());
      n--;
    }

    scanner.close();

    Collections.sort(wordList, new GorellianComparator(alphabet));

    for (String word : wordList)
      System.out.println(word);
  }
}
