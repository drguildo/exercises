package com.drguildo.dailyprogrammer;

import java.security.InvalidParameterException;
import java.util.Random;

/**
 * Your challenge for today is to create a random password generator!
 * <p>
 * For extra credit, allow the user to specify the amount of passwords to
 * generate.
 * <p>
 * For even more extra credit, allow the user to specify the length of the
 * strings he wants to generate!
 * 
 * @author Simon Morgan <sjm@eml.cc>
 * @see <a href="http://goo.gl/j6YYO">Reddit</a>
 */
public class Challenge4Easy {
  private static final String ALPHABET = "0123456789abcdefghijklmnopqrstuvwxyz"
      + "ABCDEFGHIJKLMNOPQRSTUVWXYZ~@#%^&*()-_=+[]{}|;:,.<>?";

  private static final Random rand = new Random();

  private static String genPass(final int len) {
    String password = "";

    if (len < 1)
      throw new InvalidParameterException("Password length must be positive.");

    for (int i = 0; i < len; i++)
      password = password + ALPHABET.charAt(rand.nextInt(ALPHABET.length()));

    return password;
  }

  public static void main(final String[] args) {
    int n = 1;
    int len = 8;

    if (args.length > 0 && Integer.parseInt(args[0]) > 1)
      n = Integer.parseInt(args[0]);

    if (args.length > 1 && Integer.parseInt(args[1]) > 0)
      len = Integer.parseInt(args[1]);

    for (int i = 0; i < n; i++)
      System.out.println(genPass(len));
  }
}
