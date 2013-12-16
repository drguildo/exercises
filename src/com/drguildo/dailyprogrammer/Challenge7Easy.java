package com.drguildo.dailyprogrammer;

import java.io.FileNotFoundException;

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
public class Challenge7Easy {
  public static void main(String[] args) {
    String morse = ".... . .-.. .-.. --- / -.. .- .. .-.. -.-- / "
        + ".--. .-. --- --. .-. .- -- -- . .-. / --. --- --- -.. / "
        + ".-.. ..- -.-. -.- / --- -. / - .... . / "
        + "-.-. .... .- .-.. .-.. . -. --. . ... / - --- -.. .- -.--";

    try {
      MorseCode mc = new MorseCode();
      System.out.println(mc.fromMorse(morse));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }
}
