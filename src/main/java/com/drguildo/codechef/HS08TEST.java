package com.drguildo.codechef;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Scanner;

/**
 * Pooja would like to withdraw X $US from an ATM. The cash machine will only
 * accept the transaction if X is a multiple of 5, and Pooja's account balance
 * has enough cash to perform the withdrawal transaction (including bank
 * charges). For each successful withdrawal the bank charges 0.50 $US.
 *
 * Calculate Pooja's account balance after an attempted transaction.
 *
 * @author Simon Morgan <sjm@sjm.io>
 *
 */
public class HS08TEST {
  public static void main(String[] args) {
    try {
      Reader reader;
      if (System.getProperty("hail.satan") != null)
        reader = new FileReader("data/codingbat/HS08TEST.txt");
      else
        reader = new InputStreamReader(System.in);
      Scanner scanner = new Scanner(reader);

      Double withdrawal = scanner.nextDouble();
      Double balance = scanner.nextDouble();

      scanner.close();

      if ((withdrawal % 5 == 0) && (withdrawal + 0.50 <= balance)) {
        balance = balance - (withdrawal + 0.50);
      }

      System.out.printf("%.2f%n", balance);
    } catch (FileNotFoundException e) {
    }
  }
}
