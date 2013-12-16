package com.drguildo.dailyprogrammer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Write a program that can translate Morse code in the format of ...---... A
 * space and a slash will be placed between words. ..- / --.-
 * 
 * For bonus, add the capability of going from a string to Morse code.
 * 
 * Super-bonus if your program can flash or beep the Morse.
 * 
 * This is your Morse to translate:
 * 
 * .... . .-.. .-.. --- / -.. .- .. .-.. -.-- / .--. .-. --- --. .-. .- -- -- .
 * .-. / --. --- --- -.. / .-.. ..- -.-. -.- / --- -. / - .... . / -.-. .... .-
 * .-.. .-.. . -. --. . ... / - --- -.. .- -.--
 */
public class MorseCode {
  private ArrayList<String[]> mapping;
  private static final String mappingsPath = "data/dailyprogrammer/MorseCode.txt";

  public MorseCode() throws FileNotFoundException {
    mapping = new ArrayList<>();

    Scanner scanner = new Scanner(new FileReader(new File(mappingsPath)));
    String[] s;
    while (scanner.hasNext()) {
      s = scanner.nextLine().split("\\s+");
      if (s.length == 2)
        mapping.add(new String[] { s[0], s[1] });
    }
    scanner.close();
  }

  /**
   * Converts a morse code string to plain text.
   * 
   * @param morse
   *          the string to convert
   * @return the string converted to plain text
   */
  public String fromMorse(String morse) {
    String text = "";

    String[] words = morse.split(" / ");
    for (int i = 0; i < words.length; i++) {
      String word = words[i];
      String[] letters = word.split("\\s+");
      for (int j = 0; j < letters.length; j++) {
        String letter = letters[j];
        for (String[] a : mapping) {
          if (a[0].equals(letter)) {
            text = text + a[1];
          }
        }
      }
      text = text + " ";
    }

    return text.trim();
  }

  /**
   * Converts a plain text string to morse code.
   * 
   * @param text
   *          the string to convert
   * @return the string converted to morse code
   */
  public String toMorse(String text) {
    String morse = "";

    String[] words = text.split(" ");
    for (int i = 0; i < words.length; i++) {
      String word = words[i];
      for (int j = 0; j < word.length(); j++) {
        String letter = "" + word.charAt(j);
        for (String[] a : mapping) {
          if (a[1].equals(letter.toUpperCase())) {
            morse = morse + a[0];
            if (j != word.length() - 1)
              morse = morse + " ";
          }
        }
      }
      if (i != words.length - 1)
        morse = morse + " / ";
    }

    return morse.trim();
  }
}
