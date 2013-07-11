package com.drguildo.dailyprogrammer;

/**
 * Welcome to cipher day!
 * <p/>
 * Write a program that can encrypt texts with an alphabetical caesar cipher.
 * This cipher can ignore numbers, symbols, and whitespace.
 * <p/>
 * For extra credit, add a "decrypt" function to your program!
 *
 * @author Simon Morgan <sjm@eml.cc>
 * @see <a href="http://goo.gl/lzG6b">Reddit</a>
 * @see <a href="http://en.wikipedia.org/wiki/Caesar_cipher">Wikipedia</a>
 */
public class Challenge2Easy {
  private static final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

  private static String encrypt(final String s, final int shiftLen) {
    String encrypted = "";

    int val;
    int idx;
    for (final char c : s.toCharArray()) {
      val = Character.getNumericValue(c);
      if (val >= 0) {
        idx = (val + shiftLen + ALPHABET.length()) % ALPHABET.length();
        encrypted = encrypted + ALPHABET.charAt(idx);
      } else {
        encrypted = encrypted + c;
      }
    }

    return encrypted;
  }

  public static void main(final String[] args) {
    final String s = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    final String encrypted = encrypt(s, 2);
    final String decrypted = encrypt(encrypted, -2);

    System.out.println("Before encryption: " + s);
    System.out.println("After encryption: " + encrypted);
    System.out.println("After decryption: " + decrypted);
  }
}
