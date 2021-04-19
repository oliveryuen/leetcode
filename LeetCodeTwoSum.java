import java.util.HashMap;
import java.util.Map;

/**
 * #1
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 */
public class LeetCodeTwoSum {

    static class Solution1 {

        /**
         * Brute force approach
         *
         * @param nums
         * @param target
         * @return
         */

        public static int[] twoSum(int[] nums, int target) {
            int[] result = new int[2];

            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        result[0] = i;
                        result[1] = j;
                    }
                }
            }

            return result;
        }
    }

    static class Solution2 {

        /**
         * Hash approach
         *
         * @param nums
         * @param target
         * @return
         */
        public static int[] twoSum(int[] nums, int target) {

            int[] result = new int[2];
            Map<Integer, Integer> encounters = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                int complement = target - nums[i];
                if (encounters.containsKey(complement)) {
                    result[0] = i;
                    result[1] = encounters.get(complement);
                } else {
                    encounters.put(nums[i], i);
                }
            }

            return result;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 11, 7, 15};
        int target = 9;
        int[] result = null;

        result = Solution1.twoSum(nums, target);
        System.out.printf("Solution1: [%d, %d]\n", result[0], result[1]);

        result = Solution2.twoSum(nums, target);
        System.out.printf("Solution2: [%d, %d]\n", result[0], result[1]);
    }
}

