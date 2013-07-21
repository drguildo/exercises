package com.drguildo.algs4.ch1.sec2;

public class Transaction implements Comparable<Transaction> {
  private String who;
  private SmartDate date;
  private double amount;

  public Transaction(String who, SmartDate when, double amount) {
    this.who = who;
    this.date = when;
    this.amount = amount;
  }

  public Transaction(String transaction) {
    // lolnope
  }

  public String who() {
    return who;
  }

  public SmartDate when() {
    return date;
  }

  public double amount() {
    return amount;
  }

  @Override
  public String toString() {
    return null;
  }

  @Override
  public boolean equals(Object that) {
    if (this == that)
      return true;
    if (that == null)
      return false;
    if (this.getClass() != that.getClass())
      return false;

    Transaction x = (Transaction) that;
    if (this.who != x.who)
      return false;
    if (this.date != x.date)
      return false;
    if (this.amount != x.amount)
      return false;

    return true;
  }

  @Override
  public int compareTo(Transaction that) {
    return 0;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public static void main(String[] args) {
  }
}
