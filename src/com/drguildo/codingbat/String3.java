package com.drguildo.codingbat;

public class String3 {
  // Given a string, count the number of words ending in 'y' or 'z' -- so the
  // 'y' in "heavy" and the 'z' in "fez" count, but not the 'y' in "yellow" (not
  // case sensitive). We'll say that a y or z is at the end of a word if there
  // is not an alphabetic letter immediately following it.
  public int countYZ(String str) {
    int count = 0;
    char c;
    for (int i = 0; i < str.length() - 1; i++) {
      c = Character.toLowerCase(str.charAt(i));
      if ((c == 'y' || c == 'z') && !Character.isLetter(str.charAt(i + 1)))
        count++;
    }
    c = Character.toLowerCase(str.charAt(str.length() - 1));
    if (c == 'y' || c == 'z')
      count++;
    return count;
  }

  // Given two strings, base and remove, return a version of the base string
  // where all instances of the remove string have been removed (not case
  // sensitive). You may assume that the remove string is length 1 or more.
  // Remove only non-overlapping instances, so with "xxx" removing "xx" leaves
  // "x".
  public String withoutString(String base, String remove) {
    String str = "";
    String rlower = remove.toLowerCase();
    int blen = base.length(), rlen = remove.length();
    for (int i = 0; i < blen; i++)
      if (i <= blen - rlen
          && base.substring(i, i + rlen).toLowerCase().equals(rlower))
        i += rlen - 1;
      else
        str = str + base.charAt(i);
    return str;
  }

  // Given a string, return true if the number of appearances of "is" anywhere
  // in the string is equal to the number of appearances of "not" anywhere in
  // the string (case sensitive).
  public boolean equalIsNot(String str) {
    int icnt = 0, ncnt = 0;
    for (int i = 0; i < str.length() - 1; i++)
      if (str.substring(i, i + 2).equals("is"))
        icnt++;
    for (int i = 0; i < str.length() - 2; i++)
      if (str.substring(i, i + 3).equals("not"))
        ncnt++;
    return icnt == ncnt;
  }

  // We'll say that a lowercase 'g' in a string is "happy" if there is another
  // 'g' immediately to its left or right. Return true if all the g's in the
  // given string are happy.
  public boolean gHappy(String str) {
    if (str.length() == 0)
      return true;
    if (str.length() == 1 && str.charAt(0) == 'g')
      return false;
    if ((str.charAt(0) == 'g' && str.charAt(1) != 'g')
        || (str.charAt(str.length() - 1) == 'g' && str.charAt(str.length() - 2) != 'g'))
      return false;
    for (int i = 1; i < str.length() - 1; i++)
      if (str.charAt(i) == 'g' && str.charAt(i - 1) != 'g'
          && str.charAt(i + 1) != 'g')
        return false;
    return true;
  }

  // We'll say that a "triple" in a string is a char appearing three times in a
  // row. Return the number of triples in the given string. The triples may
  // overlap.
  public int countTriple(String str) {
    int cnt = 0;
    for (int i = 0; i < str.length() - 2; i++) {
      char c = str.charAt(i);
      if (str.charAt(i + 1) == c && str.charAt(i + 2) == c)
        cnt++;
    }
    return cnt;
  }

  // Given a string, return the sum of the digits 0-9 that appear in the string,
  // ignoring all other characters. Return 0 if there are no digits in the
  // string.
  public int sumDigits(String str) {
    int sum = 0;
    for (int i = 0; i < str.length(); i++)
      if (Character.isDigit(str.charAt(i)))
        sum += Integer.parseInt(String.valueOf(str.charAt(i)));
    return sum;
  }

  // Given a string, return the longest substring that appears at both the
  // beginning and end of the string without overlapping. For example,
  // sameEnds("abXab") is "ab".
  public String sameEnds(String string) {
    int a = 0, b = 0;

    switch (string.length()) {
    case 0:
    case 1:
      return "";
    case 2:
      a = 1;
      b = 1;
      break;
    case 3:
      a = 1;
      b = 2;
      break;
    default:
      a = string.length() / 2;
      if (string.length() % 2 != 0)
        a++;
      b = string.length() / 2;
      break;
    }

    while (a > 0) {
      if (string.substring(0, a).equals(string.substring(b)))
        return string.substring(0, a);
      a--;
      b++;
    }
    return "";
  }

  // Given a string, look for a mirror image (backwards) string at both the
  // beginning and end of the given string. In other words, zero or more
  // characters at the very beginning of the given string, and at the very end
  // of the string in reverse order (possibly overlapping). For example, the
  // string "abXYZba" has the mirror end "ab".
  public String mirrorEnds(String string) {
    int match = 0;
    for (int i = 1; i <= string.length(); i++) {
      String rev = new StringBuilder(string.substring(string.length() - i,
          string.length())).reverse().toString();
      if (string.substring(0, i).equals(rev))
        match = i;
      else
        return string.substring(0, match);
    }
    return string.substring(0, match);
  }

  // Given a string, return the length of the largest "block" in the string. A
  // block is a run of adjacent chars that are the same.
  public int maxBlock(String str) {
    if (str.length() == 0) {
      return 0;
    } else {
      int longest = 1, len = 1;
      char c = str.charAt(0);
      for (int i = 1; i < str.length(); i++) {
        if (str.charAt(i) == c) {
          len++;
        } else {
          if (len > longest)
            longest = len;
          len = 1;
          c = str.charAt(i);
        }
      }
      if (len > longest)
        longest = len;
      return longest;
    }
  }

  // Given a string, return the sum of the numbers appearing in the string,
  // ignoring all other characters. A number is a series of 1 or more digit
  // chars in a row.
  public int sumNumbers(String str) {
    int sum = 0;
    String num = "";
    for (int i = 0; i < str.length(); i++)
      if (Character.isDigit(str.charAt(i))) {
        num = num + str.charAt(i);
      } else {
        if (num.length() > 0) {
          sum += Integer.valueOf(num);
          num = "";
        }
      }
    if (num.length() > 0) {
      sum += Integer.valueOf(num);
      num = "";
    }
    return sum;
  }

  // Given a string, return a string where every appearance of the lowercase
  // word "is" has been replaced with "is not". The word "is" should not be
  // immediately preceded or followed by a letter -- so for example the "is" in
  // "this" does not count.
  public String notReplace(String str) {
    String s = "";
    for (int i = 0; i < str.length(); i++)
      if (i < str.length() - 1 && str.substring(i, i + 2).equals("is")
          && (i == 0 || !Character.isLetter(str.charAt(i - 1)))
          && (i + 2 >= str.length() || !Character.isLetter(str.charAt(i + 2)))) {
        s = s + "is not";
        i += 1;
      } else {
        s = s + str.charAt(i);
      }
    return s;
  }
}
