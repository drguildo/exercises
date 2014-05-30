package com.drguildo.dailyprogrammer.intermediate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/*
 * The popular video games Fallout 3 and Fallout: New Vegas has a computer
 * hacking mini game.
 * 
 * This game requires the player to correctly guess a password from a list of
 * same length words. Your challenge is to implement this game yourself.
 * 
 * The game works like the classic game of Mastermind The player has only 4
 * guesses and on each incorrect guess the computer will indicate how many
 * letter positions are correct.
 * 
 * For example, if the password is MIND and the player guesses MEND, the game
 * will indicate that 3 out of 4 positions are correct (M_ND). If the password
 * is COMPUTE and the player guesses PLAYFUL, the game will report 0/7. While
 * some of the letters match, they're in the wrong position.
 * 
 * Ask the player for a difficulty (very easy, easy, average, hard, very hard),
 * then present the player with 5 to 15 words of the same length. The length can
 * be 4 to 15 letters. More words and letters make for a harder puzzle. The
 * player then has 4 guesses, and on each incorrect guess indicate the number of
 * correct positions.
 * 
 * You can draw words from our favorite dictionary file: enable1.txt. Your
 * program should completely ignore case when making the position checks.
 */
public class FalloutsHackingGame {
  final static int[][] difficulties = {
      // dummy difficulty so that array indeces don't have to be offset
      {},
      // very easy
      { 4, 5 },
      // easy
      { 6, 8 },
      // average
      { 9, 10 },
      // hard
      { 11, 12 },
      // very hard
      { 13, 15 } };

  final static Random rand = new Random();

  public static void main(String[] args) {
    List<String> chosen;
    Map<Integer, ArrayList<String>> words = loadWords();

    int difficulty, wordLength, guesses;
    boolean playing = true;

    Scanner scanner = new Scanner(System.in);

    String answer, response;
    while (playing) {
      System.out.print("Difficulty (1-5)? ");
      difficulty = scanner.nextInt();
      scanner.nextLine();

      if (difficulty < 1 || difficulty >= difficulties.length) {
        System.err.println("Invalid difficulty.");
        continue;
      }

      guesses = 4;
      wordLength = difficulties[difficulty][0]
          + rand.nextInt(difficulties[difficulty][1]
              - difficulties[difficulty][0]);
      chosen = chooseRandom(5 + rand.nextInt(11), words.get(wordLength));
      answer = chosen.get(rand.nextInt(chosen.size()));

      for (String word : chosen)
        System.out.println(word);

      while (guesses > 0) {
        System.out.print("Guess (" + guesses + " left)? ");
        response = scanner.nextLine().toUpperCase();
        if (!chosen.contains(response)) {
          System.err.println("Invalid answer.");
          continue;
        }
        if (response.equals(answer)) {
          System.out.println("You win!");
          break;
        } else {
          System.out.println(similarChars(response, answer) + "/"
              + answer.length() + " correct");
          guesses--;
          continue;
        }
      }

      System.out.print("Play again? ");
      response = scanner.nextLine();
      if (!response.equals("y"))
        playing = false;
    }

    scanner.close();
  }

  private static Map<Integer, ArrayList<String>> loadWords() {
    HashMap<Integer, ArrayList<String>> words = new HashMap<>();

    try {
      BufferedReader br = new BufferedReader(new FileReader("data/enable1.txt"));
      String word;
      int wordLength;
      while ((word = br.readLine()) != null) {
        wordLength = word.length();
        if (wordLength < 4 || wordLength > 15)
          continue;
        if (!words.containsKey(wordLength))
          words.put(wordLength, new ArrayList<String>());
        words.get(wordLength).add(word.toUpperCase());
      }
      br.close();
    } catch (IOException e) {
      System.err.println("Failed to read word list: " + e.getMessage());
      System.exit(-1);
    }

    return words;
  }

  /**
   * @param n
   *          the number of words
   * @param words
   *          the list of words to choose from
   * @return a list of n randomly selected words
   */
  private static List<String> chooseRandom(int n, List<String> words) {
    ArrayList<String> chosen = new ArrayList<>();

    assert words.size() > n;

    String word;
    while (chosen.size() < n) {
      word = words.get(rand.nextInt(words.size()));
      if (chosen.contains(word))
        continue;
      else
        chosen.add(word);
    }

    return chosen;
  }

  private static int similarChars(String a, String b) {
    int n = 0;

    assert a.length() == b.length();

    for (int i = 0; i < a.length(); i++)
      if (a.charAt(i) == b.charAt(i))
        n++;

    return n;
  }
}
