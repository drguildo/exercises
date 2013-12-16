package com.drguildo.dailyprogrammer;

/**
 * Welcome to cipher day!
 * 
 * Write a program that can encrypt texts with an alphabetical caesar cipher.
 * This cipher can ignore numbers, symbols, and whitespace.
 * 
 * For extra credit, add a "decrypt" function to your program!
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
