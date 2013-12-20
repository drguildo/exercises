package com.drguildo.dailyprogrammer.easy;

import java.util.Random;
import java.util.Scanner;

/*
 * The Monty Hall Problem is a probability puzzle that has a very non-intuitive
 * answer for the average person. Here's the problem description taken from
 * Wikipedia:
 * 
 * "Suppose you're on a game show, and you're given the choice of three doors:
 * Behind one door is a car; behind the others, goats. You pick a door, say No.
 * 1, and the host, who knows what's behind the doors, opens another door, say
 * No. 3, which has a goat. He then says to you,
 * "Do you want to pick door No. 2?" Is it to your advantage to switch your
 * choice?"
 * 
 * Your goal is to simulate two tactics to this puzzle, and return the
 * percentage of successful results. The first tactic is where you stick with
 * your initial choice. The second tactic is where you always switch doors.
 * 
 * Make sure to actually simulate both techniques. Write that code out in its
 * entirety, don't compute the second result being '100% - first techniques
 * percentage', though that's certainly true mathematically.
 * 
 * URL: http://www.reddit.com/r/dailyprogrammer/comments/1qdw40/111113_challenge_141_easy_monty_hall_simulation/
 */
public class Challenge141 {
  private static Random rand = new Random();

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    long n = scanner.nextLong();

    scanner.close();

    long tallyOne = 0, tallyTwo = 0;
    for (int i = 0; i < n; i++) {
      if (tacticOne() == true) {
        tallyOne++;
      }

      if (tacticTwo() == true) {
        tallyTwo++;
      }
    }

    System.out.println("Tactic 1: " + ((double) tallyOne / n) * 100
        + "% winning chance.");
    System.out.println("Tactic 2: " + ((double) tallyTwo / n) * 100
        + "% winning chance.");
  }

  // Stick with our original choice.
  private static boolean tacticOne() {
    boolean[] doors = new boolean[] { false, false, false };

    doors[rand.nextInt(3)] = true;

    return doors[rand.nextInt(3)];
  }

  // Switch doors.
  private static boolean tacticTwo() {
    boolean[] doors = new boolean[] { false, false, false };
    int prizeDoor = rand.nextInt(3);
    int chosenDoor = rand.nextInt(3);

    doors[prizeDoor] = true;

    int openDoor = 0;
    for (int i = 0; i < doors.length; i++) {
      if (i != chosenDoor && i != prizeDoor) {
        openDoor = i;
        break;
      }
    }

    for (int i = 0; i < doors.length; i++) {
      if (i != chosenDoor && i != openDoor) {
        chosenDoor = i;
        break;
      }
    }

    return doors[chosenDoor];
  }
}
