import java.util.*;
class Solution {
  // time complexity O(n^2) | space complexity O(1)
  public static int[] twoSum(int[] numbers, int targetSum) {
      if (numbers == null || numbers.length < 2) {
        return null;
      }

      for (int i = 0; i < numbers.length; i++) {
        int diff = targetSum - numbers[i];
        for (int j = i + 1; j < numbers.length; j++) {
          if (numbers[j] == diff) {
            return new int[]{numbers[i], numbers[j]};
          }
        }
      }
      return null;
  }
  
  public static void main(String[] args){
    System.out.println(Arrays.toString(
      twoSum(new int[]{3, 6, 10, 14}, 9))); // [6, 3] best case

    System.out.println(Arrays.toString( 
      twoSum(null, 4))); // null - invalid input
    
    System.out.println(Arrays.toString(
      twoSum(new int[]{3, 1, 4}, 9))); // null - no pair exists

    System.out.println(Arrays.toString(
      twoSum(new int[]{3}, 9))); // null - array with less than two integers 
  }
}