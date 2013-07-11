package com.drguildo.codingbat;

import java.util.ArrayList;
import java.util.List;

public class AP1 {
  /**
   * Given an array of scores, return true if each score is equal or greater
   * than the one before. The array will be length 2 or more.
   *
   * @param scores
   * @return
   */
  public boolean scoresIncreasing(int[] scores) {
    for (int i = 1; i < scores.length; i++)
      if (scores[i] < scores[i - 1])
        return false;
    return true;
  }

  /**
   * Given an array of scores, return true if there are scores of 100 next to
   * each other in the array. The array length will be at least 2.
   *
   * @param scores
   * @return
   */
  public boolean scores100(int[] scores) {
    for (int i = 1; i < scores.length; i++)
      if (scores[i] == 100 && scores[i - 1] == 100)
        return true;
    return false;
  }

  /**
   * Given an array of scores sorted in increasing order, return true if the
   * array contains 3 adjacent scores that differ from each other by at most 2,
   * such as with {3, 4, 5} or {3, 5, 5}.
   *
   * @param scores
   * @return
   */
  public boolean scoresClump(int[] scores) {
    for (int i = 2; i < scores.length; i++) {
      int a = scores[i - 2], b = scores[i - 1], c = scores[i];
      if (Math.abs(Math.max(Math.max(a, b), Math.max(b, c))
          - Math.min(Math.min(a, b), Math.min(b, c))) <= 2)
        return true;
    }
    return false;
  }

  /**
   * Given an array of scores, compute the int average of the first half and the
   * second half, and return whichever is larger. We'll say that the second half
   * begins at index length/2.
   *
   * @param scores
   * @return
   */
  public int scoresAverage(int[] scores) {
    int a = average(scores, 0, scores.length / 2);
    int b = average(scores, scores.length / 2, scores.length);
    return Math.max(a, b);
  }

  public int average(int[] scores, int start, int end) {
    int sum = 0;
    for (int i = start; i < end; i++)
      sum += scores[i];
    return sum / (end - start);
  }

  /**
   * Given an array of strings, return the count of the number of strings with
   * the given length.
   *
   * @param words
   * @param len
   * @return
   */
  public int wordsCount(String[] words, int len) {
    int cnt = 0;
    for (String s : words)
      if (s.length() == len)
        cnt++;
    return cnt;
  }

  /**
   * Given an array of strings, return a new array containing the first N
   * strings. N will be in the range 1..length.
   *
   * @param words
   * @param n
   * @return
   */
  public String[] wordsFront(String[] words, int n) {
    String[] a = new String[n];
    for (int i = 0; i < n; i++)
      a[i] = words[i];
    return a;
  }

  /**
   * Given an array of strings, return a new List (e.g. an ArrayList) where all
   * the strings of the given length are omitted.
   *
   * @param words
   * @param len
   * @return
   */
  public List<String> wordsWithoutList(String[] words, int len) {
    ArrayList<String> l = new ArrayList<String>();
    for (String s : words)
      if (s.length() != len)
        l.add(s);
    return l;
  }

  /**
   * Given a positive int n, return true if it contains a 1 digit.
   *
   * @param n
   * @return
   */
  public boolean hasOne(int n) {
    while (n > 0) {
      if (n % 10 == 1)
        return true;
      n /= 10;
    }
    return false;
  }

  /**
   * We'll say that a positive int divides itself if every digit in the number
   * divides into the number evenly. So for example 128 divides itself since 1,
   * 2, and 8 all divide into 128 evenly. We'll say that 0 does not divide into
   * anything evenly, so no number with a 0 digit divides itself.
   *
   * @param n
   * @return
   */
  public boolean dividesSelf(int n) {
    if (n == 0)
      return false;
    int x = n;
    while (x > 0) {
      if (x % 10 == 0 || n % (x % 10) != 0)
        return false;
      x /= 10;
    }
    return true;
  }

  /**
   * Given an array of positive ints, return a new array of length "count"
   * containing the first even numbers from the original array. The original
   * array will contain at least "count" even numbers.
   *
   * @param nums
   * @param count
   * @return
   */
  public int[] copyEvens(int[] nums, int count) {
    int[] a = new int[count];
    for (int i = 0, j = 0; i < nums.length && j < count; i++)
      if (nums[i] % 2 == 0)
        a[j++] = nums[i];
    return a;
  }

  /**
   * We'll say that a positive int n is "endy" if it is in the range 0..10 or
   * 90..100 (inclusive). Given an array of positive ints, return a new array of
   * length "count" containing the first endy numbers from the original array.
   * The original array will contain at least "count" endy numbers.
   *
   * @param nums
   * @param count
   * @return
   */
  public int[] copyEndy(int[] nums, int count) {
    int[] a = new int[count];
    for (int i = 0, j = 0; i < nums.length && j < count; i++)
      if (isEndy(nums[i]))
        a[j++] = nums[i];
    return a;
  }

  public boolean isEndy(int n) {
    return (n >= 0 && n <= 10) || (n >= 90 && n <= 100);
  }

  /**
   * Given 2 arrays that are the same length containing strings, compare the 1st
   * string in one array to the 1st string in the other array, the 2nd to the
   * 2nd and so on. Count the number of times that the 2 strings are non-empty
   * and start with the same char. The strings may be any length, including 0.
   *
   * @param a
   * @param b
   * @return
   */
  public int matchUp(String[] a, String[] b) {
    int count = 0;
    for (int i = 0; i < a.length; i++)
      if (a[i].length() > 0 && b[i].length() > 0
          && a[i].charAt(0) == b[i].charAt(0))
        count++;
    return count;
  }

  /**
   * The "key" array is an array containing the correct answers to an exam, like
   * {"a", "a", "b", "b"}. the "answers" array contains a student's answers,
   * with "?" representing a question left blank. The two arrays are not empty
   * and are the same length. Return the score for this array of answers, giving
   * +4 for each correct answer, -1 for each incorrect answer, and +0 for each
   * blank answer.
   *
   * @param key
   * @param answers
   * @return
   */
  public int scoreUp(String[] key, String[] answers) {
    int score = 0;
    for (int i = 0; i < answers.length; i++) {
      if (answers[i].equals("?"))
        continue;
      if (answers[i].equals(key[i]))
        score += 4;
      else
        score -= 1;
    }
    return score;
  }

  /**
   * Given an array of strings, return a new array without the strings that are
   * equal to the target string.
   *
   * @param words
   * @param target
   * @return
   */
  public String[] wordsWithout(String[] words, String target) {
    int count = 0;
    for (String s : words)
      if (s.equals(target))
        count++;

    String[] a = new String[words.length - count];
    int i = 0;
    for (String s : words)
      if (!s.equals(target))
        a[i++] = s;
    return a;
  }

  /**
   * Given two arrays, A and B, of non-negative int scores. A "special" score is
   * one which is a multiple of 10, such as 40 or 90. Return the sum of largest
   * special score in A and the largest special score in B.
   *
   * @param a
   * @param b
   * @return
   */
  public int scoresSpecial(int[] a, int[] b) {
    return largestSpecial(a) + largestSpecial(b);
  }

  public int largestSpecial(int[] a) {
    int largest = 0;
    for (int n : a)
      if (n % 10 == 0)
        largest = Math.max(n, largest);
    return largest;
  }

  /**
   * We have an array of heights, representing the altitude along a walking
   * trail. Given start/end indexes into the array, return the sum of the
   * changes for a walk beginning at the start index and ending at the end
   * index. For example, with the heights {5, 3, 6, 7, 2} and start=2, end=4
   * yields a sum of 1 + 5 = 6. The start end end index will both be valid
   * indexes into the array with start <= end.
   *
   * @param heights
   * @param start
   * @param end
   * @return
   */
  public int sumHeights(int[] heights, int start, int end) {
    if (start == end)
      return 0;

    int sum = 0;
    for (int i = start + 1; i <= end; i++)
      sum += Math.abs(heights[i] - heights[i - 1]);
    return sum;
  }

  /**
   * We have an array of heights, representing the altitude along a walking
   * trail. Given start/end indexes into the array, return the sum of the
   * changes for a walk beginning at the start index and ending at the end
   * index, however increases in height count double. For example, with the
   * heights {5, 3, 6, 7, 2} and start=2, end=4 yields a sum of 1*2 + 5 = 7. The
   * start end end index will both be valid indexes into the array with start <=
   * end.
   *
   * @param heights
   * @param start
   * @param end
   * @return
   */
  public int sumHeights2(int[] heights, int start, int end) {
    if (start == end)
      return 0;

    int sum = 0;
    for (int i = start + 1; i <= end; i++) {
      if (heights[i] > heights[i - 1])
        sum += (heights[i] - heights[i - 1]) * 2;
      else
        sum += Math.abs(heights[i] - heights[i - 1]);
    }
    return sum;
  }

  /**
   * We have an array of heights, representing the altitude along a walking
   * trail. Given start/end indexes into the array, return the number of "big"
   * steps for a walk starting at the start index and ending at the end index.
   * We'll say that step is big if it is 5 or more up or down. The start and end
   * index will both be valid indexes into the array with start <= end.
   *
   * @param heights
   * @param start
   * @param end
   * @return
   */
  public int bigHeights(int[] heights, int start, int end) {
    if (start == end)
      return 0;

    int count = 0;
    for (int i = start + 1; i <= end; i++) {
      if (Math.abs(heights[i] - heights[i - 1]) >= 5)
        count++;
    }
    return count;
  }

  /**
   * We have data for two users, A and B, each with a String name and an int id.
   * The goal is to order the users such as for sorting. Return -1 if A comes
   * before B, 1 if A comes after B, and 0 if they are the same. Order first by
   * the string names, and then by the id numbers if the names are the same.
   * Note: with Strings str1.compareTo(str2) returns an int value which is
   * negative/0/positive to indicate how str1 is ordered to str2 (the value is
   * not limited to -1/0/1). (On the AP, there would be two User objects, but
   * here the code simply takes the two strings and two ints directly. The code
   * logic is the same.)
   *
   * @param aName
   * @param aId
   * @param bName
   * @param bId
   * @return
   */
  public int userCompare(String aName, int aId, String bName, int bId) {
    if (aName.compareTo(bName) > 0)
      return 1;

    if (aName.compareTo(bName) < 0)
      return -1;

    return aId > bId ? 1 : (aId < bId ? -1 : 0);
  }

  /**
   * Start with two arrays of strings, A and B, each with its elements in
   * alphabetical order and without duplicates. Return a new array containing
   * the first N elements from the two arrays. The result array should be in
   * alphabetical order and without duplicates. A and B will both have a length
   * which is N or more. The best "linear" solution makes a single pass over A
   * and B, taking advantage of the fact that they are in alphabetical order,
   * copying elements directly to the new array.
   *
   * @param a
   * @param b
   * @param n
   * @return
   */
  public String[] mergeTwo(String[] a, String[] b, int n) {
    String[] merged = new String[n];
    int ai = 0, bi = 0;
    for (int i = 0; i < n; i++) {
      if (i > 0) {
        String prev = merged[i - 1];
        while (a[ai].compareTo(prev) < 1)
          ai++;
        while (b[bi].compareTo(prev) < 1)
          bi++;
      }
      merged[i] = a[ai].compareTo(b[bi]) < 0 ? a[ai] : b[bi];
    }
    return merged;
  }

  /**
   * Start with two arrays of strings, a and b, each in alphabetical order,
   * possibly with duplicates. Return the count of the number of strings which
   * appear in both arrays. The best "linear" solution makes a single pass over
   * both arrays, taking advantage of the fact that they are in alphabetical
   * order.
   *
   * @param a
   * @param b
   * @return
   */
  public int commonTwo(String[] a, String[] b) {
    int ai = 0, bi = 0, count = 0;
    while (ai < a.length && bi < b.length) {
      while (ai < a.length && bi < b.length && a[ai].compareTo(b[bi]) < 0)
        ai++;
      while (ai < a.length && bi < b.length && b[bi].compareTo(a[ai]) < 0)
        bi++;

      if (ai < a.length && bi < b.length && a[ai].compareTo(b[bi]) == 0)
        count++;

      int tmp = ai;
      while (ai < a.length && a[ai].compareTo(a[tmp]) == 0)
        ai++;
      tmp = bi;
      while (bi < b.length && b[bi].compareTo(b[tmp]) == 0)
        bi++;
    }
    return count;
  }
}
