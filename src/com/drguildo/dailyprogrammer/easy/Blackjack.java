package com.drguildo.dailyprogrammer.easy;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/*
 * So went to a Casino recently. I noticed at the Blackjack tables the house
 * tends to use several decks and not 1. My mind began to wonder about how
 * likely natural blackjacks (getting an ace and a card worth 10 points on the
 * deal) can occur.
 * 
 * So for this monday challenge lets look into this. We need to be able to
 * shuffle deck of playing cards. (52 cards) and be able to deal out virtual 2
 * card hands and see if it totals 21 or not.
 * 
 * 1. Develop a way to shuffle 1 to 10 decks of 52 playing cards.
 * 
 * 2. Using this shuffle deck(s) deal out hands of 2s
 * 
 * 3. count how many hands you deal out and how many total 21 and output the
 * percentage.
 */
final class Blackjack {
  enum Suit {
    HEARTS, DIAMONDS, CLUBS, SPADES
  }

  enum Face {
    ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
  }

  static class Card {
    Suit suit;
    Face face;

    Card(Suit s, Face f) {
      suit = s;
      face = f;
    }

    public boolean isAce() {
      return face == Face.ACE;
    }

    public boolean isWorthTen() {
      return (face == Face.TEN) || (face == Face.JACK) || (face == Face.QUEEN)
          || (face == Face.KING);
    }

    @Override
    public String toString() {
      return face + " of " + suit;
    }
  }

  static class Deck {
    Random rand;
    ArrayList<Card> cards;

    Deck() {
      rand = new Random();
      cards = new ArrayList<>();

      for (Suit s : Suit.values())
        for (Face f : Face.values()) {
          Card c = new Card(s, f);
          cards.add(c);
        }
    }

    public Card deal() {
      Card c = cards.get(rand.nextInt(cards.size()));
      cards.remove(c);

      return c;
    }

    public Card[] dealHand() {
      Card[] hand = new Card[2];

      hand[0] = deal();
      hand[1] = deal();

      return hand;
    }

    public boolean isEmpty() {
      return cards.isEmpty();
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    scanner.close();

    Deck[] decks = new Deck[n];
    int nHands = 0;
    int nBlackjacks = 0;

    for (int i = 0; i < n; i++)
      decks[i] = new Deck();

    Card[] hand;
    for (Deck deck : decks)
      while (!deck.isEmpty()) {
        hand = deck.dealHand();
        nHands++;
        if (isBlackjack(hand))
          nBlackjacks++;
      }

    System.out.println("After " + nHands + " hands there was " + nBlackjacks
        + " blackjacks at " + (int)(((float) nBlackjacks / nHands) * 100) + "%.");
  }

  public static boolean isBlackjack(Card[] hand) {
    if (hand.length == 2) {
      if (hand[0].isWorthTen() && hand[1].isAce())
        return true;
      if (hand[0].isAce() && hand[1].isWorthTen())
        return true;
    }

    return false;
  }
}
