package com.drguildo.dailyprogrammer.easy;

import java.util.Scanner;
import java.util.StringTokenizer;

/*
 * Welcome to this week's Theme Week. We're going to be creating our very own
 * basic compression format for short novels or writing. This format will
 * probably not be practical for actual use, but may serve as a rudimentary
 * introduction to how data compression works. As a side task, it is advised to
 * use structured programming techniques, so your program is easy to extend,
 * modify and maintain later on (ie. later this week.) To keep in line with our
 * Easy-Intermediate-Hard trend, our first step will be to write the
 * decompresser.
 * 
 * The basic idea of this compression scheme will be the dictionary system.
 * Words used in the data will be put into a dictionary, so instead of repeating
 * phrases over and over again, you can just repeat a number instead, thus
 * saving space. Also, because this system is based around written text, it will
 * be specifically designed to handle sentences and punctuation, and will not be
 * geared to handle binary data.
 */
public class NovelCompression1 {
  private static String dictionary[];

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int n = scanner.nextInt();
    scanner.nextLine();

    dictionary = new String[n];
    for (int i = 0; i < n; i++) {
      dictionary[i] = scanner.nextLine();
    }

    String token;
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    while (scanner.hasNextLine()) {
      st = new StringTokenizer(scanner.nextLine());
      while (st.hasMoreTokens()) {
        token = st.nextToken();

        if (token.equals("E")) {
          System.out.println(sb.toString().trim());
          break;
        }

        if (Character.isDigit(token.charAt(0))) {
          if (sb.length() > 0) {
            char lastChar = sb.charAt(sb.length() - 1);
            if (!Character.isWhitespace(lastChar) && lastChar != '-')
              sb.append(' ');
          }

          int idx;
          if (token.endsWith("^")) {
            idx = Integer.parseInt(token.substring(0, token.length() - 1));
            sb.append(capitalise(dictionary[idx]));
          } else if (token.endsWith("!")) {
            idx = Integer.parseInt(token.substring(0, token.length() - 1));
            sb.append(dictionary[idx].toUpperCase());
          } else {
            idx = Integer.parseInt(token);
            sb.append(dictionary[idx]);
          }
        } else {
          switch (token) {
          case "R":
            sb.append(System.lineSeparator());
            break;
          case "-":
          case ".":
          case ",":
          case "?":
          case "!":
          case ";":
          case ":":
            sb.append(token);
            break;
          }
        }
      }
    }

    scanner.close();
  }

  private static String capitalise(String s) {
    if (s.isEmpty())
      return s;

    return Character.toTitleCase(s.charAt(0)) + s.substring(1);
  }
}
