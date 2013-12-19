package com.drguildo.dailyprogrammer.easy;

/**
 * write a program that will print the song "99 bottles of beer on the wall".
 * 
 * for extra credit, do not allow the program to print each loop on a new line.
 * 
 * URL: http://www.reddit.com/r/dailyprogrammer/comments/pserp/2162012_challenge_8_easy/
 */
public class Challenge8 {
  public static void main(String[] args) {
    for (int bottles = 99; bottles > 1; bottles--) {
      System.out.print(bottles + " bottles of beer on the wall, ");
      System.out.println(bottles + " bottles of beer.");
      System.out.print("Take one down and pass it around, ");
      System.out.println((bottles - 1) + " bottle"
          + (bottles - 1 == 1 ? "" : "s") + " of beer on the wall.");
    }

    System.out.print("1 bottle of beer on the wall, ");
    System.out.println("1 bottle of beer. ");
    System.out.print("Take one down and pass it around, ");
    System.out.println("1 bottle of beer on the wall.");

    System.out.print("No more bottles of beer on the wall, ");
    System.out.println("no more bottles of beer. ");
    System.out.print("Go to the store and buy some more, ");
    System.out.println("99 bottles of beer on the wall.");
  }
}
