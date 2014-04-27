package com.drguildo.dailyprogrammer.intermediate;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * In the far future, demand for pre-manufactured housing, particularly in
 * planets such as Mars, has risen very high. In fact, the demand is so much
 * that traditional building planning techniques are taking too long, when faced
 * with the "I want it now!" mentality of the denizens of the future. You see an
 * opportunity here - if you can cheaply generate building designs, you are sure
 * to turn a huge profit.
 * 
 * You decide to use ASCII to design your buildings. However, as you are lazy
 * and wish to churn out many designs quickly, you decide to simply give the
 * computer a string, and have the computer make the building for you.
 * 
 * URL: http://redd.it/236va2
 * 
 */
public class TheASCIIArchitect {
  public static void main(String[] args) {
    int height = 0;
    ArrayList<String> columns = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);
    String bp = scanner.nextLine();
    scanner.close();

    int spaces;
    String line;
    for (int i = 0; i < bp.length(); i++) {
      spaces = 0;

      if (Character.isDigit(bp.charAt(i)))
        spaces = Character.getNumericValue(bp.charAt(i++));

      line = generateLine(spaces, bp.charAt(i));

      if (line.length() > height)
        height = line.length();

      columns.add(line);
    }

    for (int i = 0; i < columns.size(); i++) {
      String s = columns.get(i);
      while (s.length() < height)
        s = " " + s;
      columns.set(i, s);
    }

    for (int i = 0; i < height; i++) {
      for (String column : columns)
        System.out.print(column.charAt(i));
      System.out.println();
    }
  }

  private static String generateLine(int spaces, char code) {
    final String pattern = "---***--++";

    String s = "";

    int n = (code - 'a') + 1;

    s = s + pattern.substring(pattern.length() - n);

    for (int i = 0; i < spaces; i++)
      s = s + " ";

    return s;
  }
}
