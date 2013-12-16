package com.drguildo.dailyprogrammer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Your challenge for today is to create a program which is password protected,
 * and wont open unless the correct user and password is given.
 * 
 * For extra credit, have the user and password in a separate .txt file.
 * 
 * For even more extra credit, break into your own program :)
 * 
 * URL: http://www.reddit.com/r/dailyprogrammer/comments/pnhyn/2122012_challenge_5_easy/
 */
public class Challenge5Easy {
  private static final String credentialsPath = "data/dailyprogrammer/Challenge5Easy.txt";

  public static void main(final String[] args) {
    Scanner scanner;
    String user = null, password = null;
    final String enteredUser, enteredPassword;

    scanner = new Scanner(System.in);
    System.out.print("Username: ");
    enteredUser = scanner.nextLine();
    System.out.print("Password: ");
    enteredPassword = scanner.nextLine();

    try {
      scanner = new Scanner(new FileReader(new File(credentialsPath)));
      user = scanner.nextLine();
      password = scanner.nextLine();
    } catch (final FileNotFoundException e) {
      System.err.println("Unable to open " + credentialsPath);
      System.exit(-1);
    }

    scanner.close();

    if (enteredUser.equals(user) || enteredPassword.equals(password))
      System.err.println("PERMISSION GRANTED.");
    else
      System.err.println("PERMISSION DENIED!");
  }
}
