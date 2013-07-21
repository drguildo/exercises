package com.drguildo.algs4.ch1.sec2;

public class SmartDate {
  private static String[] days = new String[] { "Sunday", "Monday", "Tuesday",
                                               "Wednesday", "Thursday",
                                               "Friday", "Saturday" };
  private final int month;
  private final int day;
  private final int year;

  public SmartDate(int d, int m, int y) {
    month = m;
    day = d;
    year = y;

    if (month < 1 || month > 12)
      throw new IllegalArgumentException("illegal month");

    if (day < 0)
      throw new IllegalArgumentException("illegal day");
    if (isLeapYear() && month == 2 && day > 29)
      throw new IllegalArgumentException("illegal day");
    if (month == 2 && day > 28)
      throw new IllegalArgumentException("illegal day");
    if ((month == 4 || month == 6 || month == 9 || month == 11) && day > 30)
      throw new IllegalArgumentException("illegal day");
    if (day > 31)
      throw new IllegalArgumentException("illegal day");

    if (year < 0)
      throw new IllegalArgumentException("illegal year");
  }

  public boolean isLeapYear() {
    if (year % 400 == 0)
      return true;
    if ((year % 4 == 0) && (year % 100 != 0))
      return true;
    return false;
  }

  public int day() {
    return day;
  }

  public int month() {
    return month;
  }

  public int year() {
    return year;
  }

  // Source: http://jonathan.rawle.org/hyperpedia/day_calculation.php
  public String dayOfTheWeek() {
    int m, y;

    switch (month - 1) {
    case 0:
    case 9:
      m = 0;
      break;
    case 4:
      m = 1;
      break;
    case 7:
      m = 2;
      break;
    case 1:
    case 2:
    case 10:
      m = 3;
      break;
    case 5:
      m = 4;
      break;
    case 8:
    case 11:
      m = 5;
      break;
    case 3:
    case 6:
      m = 6;
      break;
    default:
      throw new IllegalStateException("illegal month");
    }

    if (isLeapYear()) {
      if (month == 1)
        m = 6;
      if (month == 2)
        m = 2;
    }

    y = year + (year / 4) - (year / 100) + (year / 400);

    return days[(y + day + m - 1) % 7];
  }

  public String toString() {
    return day() + "/" + month() + "/" + year();
  }

  public boolean equals(Object x) {
    if (this == x)
      return true;

    if (x == null)
      return false;

    if (this.getClass() != x.getClass())
      return false;

    SmartDate that = (SmartDate) x;
    if (this.day != that.day)
      return false;
    if (this.month != that.month)
      return false;
    if (this.year != that.year)
      return false;

    return true;
  }

  public static void main(String[] args) {
    SmartDate d;
    for (int i = 0; i < 2020; i++) {
      d = new SmartDate(1, 1, i);
      System.out.print(i);
      if (d.isLeapYear())
        System.out.print(" was ");
      else
        System.out.print(" wasn't ");
      System.out.println("a leap year.");
    }
    d = new SmartDate(18, 7, 2013);
    System.out.println(d);
    System.out.println(d.dayOfTheWeek());
  }
}
