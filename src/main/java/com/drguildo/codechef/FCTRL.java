package com.drguildo.codechef;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Scanner;

/**
 * There is a single positive integer T on the first line of input (equal to
 * about 100000). It stands for the number of numbers to follow. Then there are
 * T lines, each containing exactly one positive integer number N, 1 <= N <=
 * 1000000000.
 *
 * For every number N, output a single line containing the single non-negative
 * integer Z(N).
 *
 * @author Simon Morgan <sjm@sjm.io>
 *
 */
public class FCTRL {
  public static void main(String[] args) {
    try {
      Reader reader;
      if (System.getProperty("hail.satan") != null)
        reader = new FileReader("data/codingbat/FCTRL.txt");
      else
        reader = new InputStreamReader(System.in);

      Scanner scanner = new Scanner(reader);
      scanner.nextInt();

      while (scanner.hasNext()) {
        long n = scanner.nextLong();
        System.out.println(trailingZeroes(n));
      }

      scanner.close();
    } catch (FileNotFoundException e) {
    }
  }

  private static long trailingZeroes(long n) {
    int zeroes = 0;
    double power = 1;
    double factor = Math.pow(5, power);
    while (factor <= n) {
      zeroes += Math.floor(n / factor);
      factor = Math.pow(5, ++power);
    }
    return zeroes;
  }
}
