package com.drguildo.codingbat;

public class String2 {
  // Given a string, return a string where for every char in the original, there
  // are two chars.
  public String doubleChar(String str) {
    String s = "";
    for (char c : str.toCharArray())
      s = s + c + c;
    return s;
  }

  // Return the number of times that the string "hi" appears anywhere in the
  // given string.
  public int countHi(String str) {
    int count = 0;
    for (int i = 0; i < str.length() - 1; i++)
      if (str.charAt(i) == 'h' && str.charAt(i + 1) == 'i')
        count++;
    return count;
  }

  // Return true if the string "cat" and "dog" appear the same number of times
  // in the given string.
  public boolean catDog(String str) {
    int catCount = 0, dogCount = 0;
    for (int i = 0; i < str.length() - 2; i++) {
      if (str.substring(i, i + 3).equals("cat")) {
        catCount++;
        continue;
      }
      if (str.substring(i, i + 3).equals("dog")) {
        dogCount++;
        continue;
      }
    }
    return catCount == dogCount;
  }

  // Return the number of times that the string "code" appears anywhere in the
  // given string, except we'll accept any letter for the 'd', so "cope" and
  // "cooe" count.
  public int countCode(String str) {
    int count = 0;
    for (int i = 0; i < str.length() - 3; i++)
      if (str.charAt(i) == 'c' && str.charAt(i + 1) == 'o'
          && str.charAt(i + 3) == 'e')
        count++;
    return count;
  }

  // Given two strings, return true if either of the strings appears at the very
  // end of the other string, ignoring upper/lower case differences (in other
  // words, the computation should not be "case sensitive").
  public boolean endOther(String a, String b) {
    a = a.toLowerCase();
    b = b.toLowerCase();
    if (a.length() >= b.length()
        && a.substring(a.length() - b.length()).equals(b))
      return true;
    if (b.length() >= a.length()
        && b.substring(b.length() - a.length()).equals(a))
      return true;
    return false;
  }

  // Return true if the given string contains an appearance of "xyz" where the
  // xyz is not directly preceeded by a period (.). So "xxyz" counts but "x.xyz"
  // does not.
  public boolean xyzThere(String str) {
    for (int i = 0; i < str.length() - 2; i++) {
      if (str.charAt(i) == '.') {
        i++;
        continue;
      }
      if (str.substring(i, i + 3).equals("xyz"))
        return true;
    }
    return false;
  }

  // Return true if the given string contains a "bob" string, but where the
  // middle 'o' char can be any char.
  public boolean bobThere(String str) {
    for (int i = 0; i < str.length() - 2; i++)
      if (str.charAt(i) == 'b' && str.charAt(i + 2) == 'b')
        return true;
    return false;
  }

  // We'll say that a String is xy-balanced if for all the 'x' chars in the
  // string, there exists a 'y' char somewhere later in the string. So "xxy" is
  // balanced, but "xyx" is not. One 'y' can balance multiple 'x's. Return true
  // if the given string is xy-balanced.
  public boolean xyBalance(String str) {
    for (int i = str.length() - 1; i >= 0; i--) {
      if (str.charAt(i) == 'y')
        return true;
      if (str.charAt(i) == 'x')
        return false;
    }
    return true;
  }

  // Given two strings, A and B, create a bigger string made of the first char
  // of A, the first char of B, the second char of A, the second char of B, and
  // so on. Any leftover chars go at the end of the result.
  public String mixString(String a, String b) {
    String s = "";
    int lena = a.length(), lenb = b.length(), len = Math.max(lena, lenb);
    for (int i = 0; i < len; i++) {
      if (i < lena)
        s = s + a.charAt(i);
      if (i < lenb)
        s = s + b.charAt(i);
    }
    return s;
  }

  // Given a string and an int N, return a string made of N repetitions of the
  // last N characters of the string. You may assume that N is between 0 and the
  // length of the string, inclusive.
  public String repeatEnd(String str, int n) {
    String s = "";
    String ss = str.substring(str.length() - n, str.length());
    for (int i = 0; i < n; i++)
      s = s + ss;
    return s;
  }

  // Given a string and an int n, return a string made of the first n characters
  // of the string, followed by the first n-1 characters of the string, and so
  // on. You may assume that n is between 0 and the length of the string,
  // inclusive (i.e. n >= 0 and n <= str.length()).
  public String repeatFront(String str, int n) {
    String s = "";
    for (int i = n; i > 0; i--)
      s = s + str.substring(0, i);
    return s;
  }

  // Given two strings, word and a separator, return a big string made of count
  // occurences of the word, separated by the separator string.
  public String repeatSeparator(String word, String sep, int count) {
    String s = "";
    if (count == 0)
      return "";
    for (int i = 0; i < count - 1; i++)
      s = s + word + sep;
    s = s + word;
    return s;
  }

  // Given a string, consider the prefix string made of the first N chars of the
  // string. Does that prefix string appear somewhere else in the string? Assume
  // that the string is not empty and that N is in the range 1..str.length().
  public boolean prefixAgain(String str, int n) {
    String prefix = str.substring(0, n);
    for (int i = 1; i <= str.length() - n; i++)
      if (str.substring(i, i + n).equals(prefix))
        return true;
    return false;
  }

  // Given a string, does "xyz" appear in the middle of the string? To define
  // middle, we'll say that the number of chars to the left and right of the
  // "xyz" must differ by at most one. This problem is harder than it looks.
  public boolean xyzMiddle(String str) {
    if (str.length() < 3)
      return false;

    int mid = str.length() / 2;
    if (str.length() % 2 == 0) {
      if (str.substring(mid - 2, mid + 1).equals("xyz")
          || str.substring(mid - 1, mid + 2).equals("xyz")
          || str.substring(mid, mid + 3).equals("xyz"))
        return true;
    } else {
      if (str.substring(mid - 1, mid + 2).equals("xyz"))
        return true;
    }

    return false;
  }

  // A sandwich is two pieces of bread with something in between. Return the
  // string that is between the first and last appearance of "bread" in the
  // given string, or return the empty string "" if there are not two pieces of
  // bread.
  public String getSandwich(String str) {
    int start = 0, end = 0;
    for (int i = 0; i < str.length() - 5; i++)
      if (str.substring(i, i + 5).equals("bread")) {
        start = i + 5;
        break;
      }
    for (int i = str.length() - 5; i > start; i--)
      if (str.substring(i, i + 5).equals("bread")) {
        end = i;
        break;
      }
    if (end <= start)
      return "";
    else
      return str.substring(start, end);
  }

  // Returns true if for every '*' (star) in the string, if there are chars both
  // immediately before and after the star, they are the same.
  public boolean sameStarChar(String str) {
    for (int i = 1; i < str.length() - 1; i++)
      if (str.charAt(i) == '*')
        if (i == 0 || i == str.length() - 1
            || str.charAt(i - 1) != str.charAt(i + 1))
          return false;
    return true;
  }

  // Look for patterns like "zip" and "zap" in the string -- length-3, starting
  // with 'z' and ending with 'p'. Return a string where for all such words, the
  // middle letter is gone, so "zipXzap" yields "zpXzp".
  public String zipZap(String str) {
    String s = "";
    for (int i = 0; i < str.length(); i++)
      if (str.charAt(i) == 'z' && i + 2 < str.length()
          && str.charAt(i + 2) == 'p') {
        s = s + "zp";
        i += 2;
      } else {
        s = s + str.charAt(i);
      }
    return s;
  }

  // Return a version of the given string, where for every star (*) in the
  // string the star and the chars immediately to its left and right are gone.
  // So "ab*cd" yields "ad" and "ab**cd" also yields "ad".
  public String starOut(String str) {
    String s = "";
    for (int i = 0; i < str.length(); i++) {
      if (i + 1 < str.length() && str.charAt(i + 1) == '*') {
        i++;
        while (i < str.length() && str.charAt(i) == '*')
          i++;
      } else if (str.charAt(i) == '*') {
        i++;
      } else {
        s = s + str.charAt(i);
      }
    }
    return s;
  }

  // Given a string and a non-empty word string, return a version of the
  // original String where all chars have been replaced by pluses ("+"), except
  // for appearances of the word string which are preserved unchanged.
  public String plusOut(String str, String word) {
    int wlen = word.length();
    String s = "";
    for (int i = 0; i < str.length(); i++)
      if (i <= str.length() - wlen && str.substring(i, i + wlen).equals(word)) {
        s = s + word;
        i += wlen - 1;
      } else {
        s = s + '+';
      }
    return s;
  }

  // Given a string and a non-empty word string, return a string made of each
  // char just before and just after every appearance of the word in the string.
  // Ignore cases where there is no char before or after the word, and a char
  // may be included twice if it is between two words.
  public String wordEnds(String str, String word) {
    int wlen = word.length();
    String s = "";
    for (int i = 0; i <= str.length() - wlen; i++)
      if (str.substring(i, i + wlen).equals(word)) {
        if (i - 1 >= 0)
          s = s + str.charAt(i - 1);
        if (i + wlen < str.length())
          s = s + str.charAt(i + wlen);
        i += wlen - 1;
      }
    return s;
  }
}
