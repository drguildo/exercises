package com.drguildo.dailyprogrammer.easy;

import java.util.Scanner;

/**
 * A triangle on a flat plane is described by its angles and side lengths, and
 * you don't need to be given all of the angles and side lengths to work out the
 * rest. In this challenge, you'll be working with right-angled triangles only.
 * 
 * Here's a representation of how this challenge will describe a triangle
 * 
 * http://i.imgur.com/qtHozmc.png
 * 
 * Each side-length is a lower-case letter, and the angle opposite each side is
 * an upper-case letter. For the purposes of this challenge, the angle C will
 * always be the right-angle. Your challenge is, using basic trigonometry and
 * given an appropriate number of values for the angles or side lengths, to find
 * the rest of the values.
 * 
 * URL: http://redd.it/2451r5
 */
public class TrigonometricTriangleTrouble1 {
  private static final double RIGHT_ANGLE = 1.57079633; // 90 degrees in radians

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int n = scanner.nextInt();
    scanner.nextLine();

    double a = Float.NaN, b = Float.NaN, c = Float.NaN; // side lengths
    double A = Float.NaN, B = Float.NaN, C = RIGHT_ANGLE; // angles

    while (n > 0) {
      String line = scanner.nextLine();

      char letter = line.charAt(0);
      double value = Double.parseDouble(line.split("=")[1]);

      switch (letter) {
      case 'a':
        a = value;
        break;
      case 'b':
        b = value;
        break;
      case 'c':
        c = value;
        break;
      case 'A':
        A = Math.toRadians(value);
        break;
      case 'B':
        B = Math.toRadians(value);
        break;
      }

      n--;
    }

    scanner.close();

    if (!defined(A) && !defined(B)) {
      if (defined(a) && defined(b)) {
        A = Math.atan(a / b);
        B = Math.atan(b / a);
      } else if (defined(a) && defined(c)) {
        A = Math.asin(a / c);
        B = Math.acos(a / c);
      } else if (defined(b) && defined(c)) {
        A = Math.acos(b / c);
        B = Math.asin(b / c);
      }
    } else if (defined(A) && !defined(B)) {
      B = RIGHT_ANGLE - A;
    } else if (!defined(A) && defined(B)) {
      A = RIGHT_ANGLE - B;
    }

    if (!defined(A) && !defined(B)) {
      // TODO decent error message
      System.exit(-1);
    }

    if (defined(a)) {
      b = Math.tan(B) * a;
      c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    } else if (defined(b)) {
      a = Math.tan(A) * b;
      c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    } else if (defined(c)) {
      a = Math.sin(A) * (1 / c);
      b = Math.sin(B) * (1 / c);
    }

    System.out.println("a=" + a);
    System.out.println("b=" + b);
    System.out.println("c=" + c);
    System.out.println("A=" + Math.toDegrees(A));
    System.out.println("B=" + Math.toDegrees(B));
    System.out.println("C=" + Math.toDegrees(C));
  }

  private static boolean defined(double d) {
    return !Double.isNaN(d);
  }
}
