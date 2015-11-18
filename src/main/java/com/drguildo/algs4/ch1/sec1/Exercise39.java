package com.drguildo.algs4.ch1.sec1;

import java.util.Arrays;
import java.util.Random;

import edu.princeton.cs.algs4.BinarySearch;

public class Exercise39 {
  private static int[] genArray(int len) {
    Random rand = new Random();

    int[] nums = new int[len];
    for (int i = 0; i < nums.length; i++)
      nums[i] = rand.nextInt(1000000);

    Arrays.sort(nums);

    return nums;
  }

  public static void main(String[] args) {
    if (args.length < 1)
      System.exit(-1);

    int trials = Integer.parseInt(args[0]), same = 0;
    int[] nums1, nums2;
    double[] results = new double[4];

    for (int i = 3; i <= 6; i++) {
      for (int t = 0; t < trials; t++) {
        nums1 = genArray((int) Math.pow(10, i));
        nums2 = genArray((int) Math.pow(10, i));
        for (int n : nums1)
          if (BinarySearch.indexOf(nums2, n) != -1)
            same++;
        results[i - 3] += same;
      }
      System.out.println("10^" + i + ": " + (results[i - 3] / trials));
    }
  }
}
