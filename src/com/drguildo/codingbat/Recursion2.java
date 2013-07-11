package com.drguildo.codingbat;

public class Recursion2 {
  /**
   * Given an array of ints, is it possible to choose a group of some of the
   * ints, such that the group sums to the given target?
   *
   * @param start
   * @param nums
   * @param target
   * @return
   */
  public boolean groupSum(int start, int[] nums, int target) {
    if (target == 0)
      return true;
    if (start >= nums.length)
      return false;
    if (groupSum(start + 1, nums, target - nums[start]))
      return true;
    return groupSum(start + 1, nums, target);
  }

  /**
   * Given an array of ints, is it possible to choose a group of some of the
   * ints, beginning at the start index, such that the group sums to the given
   * target? However, with the additional constraint that all 6's must be
   * chosen.
   *
   * @param start
   * @param nums
   * @param target
   * @return
   */
  public boolean groupSum6(int start, int[] nums, int target) {
    if (start >= nums.length)
      if (target == 0)
        return true;
      else
        return false;
    if (nums[start] == 6)
      return groupSum6(start + 1, nums, target - nums[start]);
    if (!groupSum6(start + 1, nums, target - nums[start]))
      return groupSum6(start + 1, nums, target);
    return true;
  }

  /**
   * Given an array of ints, is it possible to choose a group of some of the
   * ints, such that the group sums to the given target with this additional
   * constraint: If a value in the array is chosen to be in the group, the value
   * immediately following it in the array must not be chosen.
   *
   * @param start
   * @param nums
   * @param target
   * @return
   */
  public boolean groupNoAdj(int start, int[] nums, int target) {
    if (target == 0)
      return true;
    if (start >= nums.length)
      return false;
    if (groupNoAdj(start + 2, nums, target - nums[start]))
      return groupNoAdj(start + 1, nums, target - nums[start]);
    return groupNoAdj(start + 1, nums, target);
  }

  /**
   * Given an array of ints, is it possible to choose a group of some of the
   * ints, such that the group sums to the given target with these additional
   * constraints: all multiples of 5 in the array must be included in the group.
   * If the value immediately following a multiple of 5 is 1, it must not be
   * chosen.
   *
   * @param start
   * @param nums
   * @param target
   * @return
   */
  public boolean groupSum5(int start, int[] nums, int target) {
    if (start >= nums.length)
      return target == 0;

    if (nums[start] % 5 == 0)
      if (start + 1 < nums.length && nums[start + 1] == 1)
        return groupSum5(start + 2, nums, target - nums[start]);
      else
        return groupSum5(start + 1, nums, target - nums[start]);
    else if (groupSum5(start + 1, nums, target - nums[start]))
      return true;
    else
      return groupSum5(start + 1, nums, target);
  }

  /**
   * Given an array of ints, is it possible to choose a group of some of the
   * ints, such that the group sums to the given target, with this additional
   * constraint: if there are numbers in the array that are adjacent and the
   * identical value, they must either all be chosen, or none of them chosen.
   * For example, with the array {1, 2, 2, 2, 5, 2}, either all three 2's in the
   * middle must be chosen or not, all as a group.
   *
   * @param start
   * @param nums
   * @param target
   * @return
   */
  public boolean groupSumClump(int start, int[] nums, int target) {
    if (start >= nums.length)
      return target == 0;

    if (start + 1 < nums.length && nums[start + 1] == nums[start]) {
      int count = 0;
      for (int i = start; i < nums.length; i++)
        if (nums[i] == nums[start])
          count++;
        else
          break;
      if (groupSumClump(start + count, nums, target - nums[start] * count))
        return true;
      else
        return groupSumClump(start + count, nums, target);
    } else if (groupSumClump(start + 1, nums, target - nums[start]))
      return true;
    else
      return groupSumClump(start + 1, nums, target);
  }

  /**
   * Given an array of ints, is it possible to divide the ints into two groups,
   * so that the sums of the two groups are the same. Every int must be in one
   * group or the other.
   *
   * @author Derek Harley Bikoff <dhbikoff@gmail.com>
   * @param nums
   * @return
   */
  public boolean splitArray(int[] nums) {
    return recArray(nums, 0, 0, 0);
  }

  private boolean recArray(int[] nums, int index, int sum1, int sum2) {
    if (index >= nums.length) {
      return sum1 == sum2;
    }

    return (recArray(nums, index + 1, sum1 + nums[index], sum2) || recArray(
        nums, index + 1, sum1, sum2 + nums[index]));
  }

  /**
   * Given an array of ints, is it possible to divide the ints into two groups,
   * so that the sum of one group is a multiple of 10, and the sum of the other
   * group is odd. Every int must be in one group or the other.
   *
   * @param nums
   * @return
   */
  public boolean splitOdd10(int[] nums) {
    return recOdd10(nums, 0, 0, 0);
  }

  private boolean recOdd10(int[] nums, int index, int sum1, int sum2) {
    if (index >= nums.length) {
      return (sum1 % 10 == 0 && sum2 % 2 == 1)
          || (sum1 % 2 == 1 && sum2 % 10 == 0);
    }

    return (recOdd10(nums, index + 1, sum1 + nums[index], sum2) || recOdd10(
        nums, index + 1, sum1, sum2 + nums[index]));
  }

  /**
   * Given an array of ints, is it possible to divide the ints into two groups,
   * so that the sum of the two groups is the same, with these constraints: all
   * the values that are multiple of 5 must be in one group, and all the values
   * that are a multiple of 3 (and not a multiple of 5) must be in the other.
   *
   * @param nums
   * @return
   */
  public boolean split53(int[] nums) {
    return rec53(nums, 0, 0, 0);
  }

  private boolean rec53(int[] nums, int index, int sum1, int sum2) {
    if (index >= nums.length) {
      return sum1 == sum2;
    }

    if (nums[index] % 5 == 0)
      return rec53(nums, index + 1, sum1 + nums[index], sum2);
    else if (nums[index] % 3 == 0)
      return rec53(nums, index + 1, sum1, sum2 + nums[index]);
    else
      return (rec53(nums, index + 1, sum1 + nums[index], sum2) || rec53(nums,
          index + 1, sum1, sum2 + nums[index]));
  }
}
