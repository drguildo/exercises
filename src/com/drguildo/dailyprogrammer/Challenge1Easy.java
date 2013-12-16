package com.drguildo.dailyprogrammer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Create a program that will ask the users name, age, and reddit username. Have
 * it tell them the information back, in the format:
 * 
 * your name is (blank), you are (blank) years old, and your username is (blank)
 * 
 * For extra credit, have the program log this information in a file to be
 * accessed later.
 */
public class Challenge1Easy {
  public static void main(final String[] args) {
    final Scanner scanner = new Scanner(System.in);

    System.out.print("Name: ");
    final String name = scanner.nextLine();

    System.out.print("Age: ");
    final String age = scanner.nextLine();

    System.out.print("Username: ");
    final String username = scanner.nextLine();

    scanner.close();

    final String s = String.format(
        "your name is %s, you are %s years old, and your username is %s", name,
        age, username);

    System.out.println(s);

    try {
      final FileWriter fileWriter = new FileWriter(new File("out.txt"));
      fileWriter.write(s);
      fileWriter.close();
    } catch (final IOException e) {
      e.printStackTrace();
    }
  }
}
